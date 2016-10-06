package net.smart.common.controller;

import net.smart.common.service.IntegrationCommonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractPageController {
	
	protected static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	protected IntegrationCommonService integrationCommonService;
	
	protected enum CodeValue {
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
	
	private enum BaseInfo {
		SYS_TITLE("Smart Project Management System"),
		MIN_TITLE("Smart PMS"),
		RESOURCE_VERSION("1.0.0"),
		SYS_CONTEXT_PATH("/smart"),
		SYS_OWNER("songmax");
		private String value;
		private BaseInfo(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	protected final void setPageBasedInfo(ModelAndView modelAndView) {
		modelAndView.addObject("sysTitle", BaseInfo.SYS_TITLE.getValue());
		modelAndView.addObject("resVersion", BaseInfo.RESOURCE_VERSION.getValue());
		modelAndView.addObject("sysContext", BaseInfo.SYS_CONTEXT_PATH.getValue());
		modelAndView.addObject("minTitle", BaseInfo.MIN_TITLE.getValue());
		modelAndView.addObject("sysOwner", BaseInfo.SYS_OWNER.getValue());
	}

}
