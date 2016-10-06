package net.smart.common.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.smart.common.domain.IntUser;
import net.smart.common.domain.UserDetail;
import net.smart.common.service.IntegrationCommonService;
import net.smart.common.support.util.IntegrationHttpSessionCollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private IntegrationCommonService integrationCommonService;
	
	private enum CodeValue {
		CATEGORY("_category"),
		UI("_ui"),
		VIEW("view");
		private String value;
		private CodeValue(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	@RequestMapping(value = "/{category}/{ui}/view.do", method = RequestMethod.GET)
	public ModelAndView movePage(@PathVariable("category") String category, 
			@PathVariable("ui") String ui, HttpServletRequest request, HttpServletResponse response) throws IOException {		
		ModelAndView modelAndView  = new ModelAndView();
		
		String modileYn = "N";
		String callLocation = "internal";
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		if (request.getHeader("User-Agent").indexOf("Mobile") != -1) {
			modileYn = "Y";
		}
		if (request.getRequestURL().indexOf("cutover.kt.com") != -1 
				|| request.getRequestURL().indexOf("14.63.248.74") != -1) {
			callLocation = "external";
		}
		request.setAttribute("IS_MOBILE", modileYn);
		request.setAttribute("CALL_LOC", callLocation);
		request.setAttribute("version", integrationCommonService.getSystemDeployVersion());
		request.setAttribute("IS_HANDS", integrationCommonService.isAdmin() ? "Y" :"N");
		request.setAttribute("IS_CT_HANDS", integrationCommonService.isCutOverAdmin() ? "Y" :"N");
		Map<String, String> mainResource = integrationCommonService.getMainResourceInfo();
		if (category.equals("layout") || category.equals("nlayout")) {
			request.setAttribute("M_RESOURCE_CONTENT", mainResource.get("resourcecontent"));
		}
		request.setAttribute("M_URL", mainResource.get("url"));
		request.setAttribute("M_RESOURCE_ID", mainResource.get("resourceid"));
		request.setAttribute("M_RESOURCE_NAME", mainResource.get("resourcename"));
		request.setAttribute("M_RESOURCE_TYPE", mainResource.get("resourcetype"));
			
		String boardNo = request.getParameter("boardNo");
		request.setAttribute("BOARD_NO", boardNo == null ? "0" : boardNo);
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext != null ) {
			Authentication authentication = securityContext.getAuthentication();
			if (authentication != null) {
				UserDetail userDetail = (UserDetail) authentication.getDetails();
				boolean isLogin = true;
				IntUser intUser = userDetail.getIntUser();
				request.setAttribute("IS_LOGIN", isLogin);
				request.setAttribute("LOGIN_NAME", intUser != null ? intUser.getUserName() : "");
				request.setAttribute("LOGIN_ID", intUser != null ? intUser.getUserId() : "");
				if ("external".equals(callLocation)
						&& integrationCommonService.isIntegrationDeveloper(intUser.getUserId())) {
					callLocation = "internal";
				}
			}
		}
		
		if ("nlayout".equals(category)) {
			if ("external".equals(callLocation) || "Y".equals(modileYn)) category = "nlayoutm";
			modelAndView.setViewName("viewNew");
		} else {
			modelAndView.setViewName(CodeValue.VIEW.getValue());
		}
		if ("external".equals(callLocation) || "Y".equals(modileYn)) {
			if(!integrationCommonService.isPermitExternalUrl(category)) {
				modelAndView.setViewName("notPermit");
			}
		}
		request.setAttribute(CodeValue.CATEGORY.getValue(), category);
		request.setAttribute(CodeValue.UI.getValue(), ui);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
	}
	 
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/loginFail.do", method = RequestMethod.GET)
	public ModelAndView loginFailPage(ModelAndView modelAndView, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			AuthenticationException exception =  (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (exception != null) {
				System.out.println(exception.getMessage());
				request.setAttribute("G_ERROR_MSG", exception.getMessage());
			}
		}
		modelAndView.setViewName("loginFail");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/wait.do", method = RequestMethod.GET)
	public ModelAndView connectionWait(HttpServletRequest request) {		
		ModelAndView modelAndView  = new ModelAndView();
		
		Map<String, HttpSession> sessions = IntegrationHttpSessionCollector.getConnectionSession();
		
		int limit = integrationCommonService.getLimitCount();
		
		modelAndView.setViewName("wait");
		request.setAttribute("maxConnection", limit + "");
		request.setAttribute("curConnection", sessions.size() + "");
		return modelAndView;
	}

}
