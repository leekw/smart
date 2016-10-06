<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
    <head>
       <title> Integration Dashboard System</title>
      <link rel="stylesheet" type="text/css" href="/int/resources/theme-triton/resources/theme-triton-all-debug.css?version=${version}">
      <link rel="stylesheet" type="text/css" href="/int/resources/theme-extends/Admin-all.css?version=${version}">
      <link rel="stylesheet" type="text/css" href="/int/resources/ux/triton/resources/ux-all-debug.css?version=${version}">
     <!--   <link rel="stylesheet" type="text/css" href="/int/resources/ext-theme-neptune/build/resources/ext-theme-neptune-all-debug.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="/int/resources/ext-theme-gray/build/resources/ext-theme-gray-all-debug.css"> -->
      <!-- <link rel="stylesheet" type="text/css" href="/int/resources/ext-theme-crisp/build/resources/ext-theme-crisp-all-debug.css">  -->
      <!--  <link rel="stylesheet" type="text/css" href="/int/resources/ext-charts/build/resources/ext-charts-all-debug.css"> -->
       <link rel="stylesheet" type="text/css" href="/int/resources/theme-int/charts-all.css?version=${version}">
       <link rel="stylesheet" type="text/css" href="/int/resources/css/traffic-lignt.css?version=${version}">
       <link rel="stylesheet" type="text/css" href="/int/resources/css/flipclock.css?version=${version}">
       <meta http-equiv="X-UA-Compatible" content="IE=9">
       <meta name="_csrf" content="${_csrf.token}"/>
       <meta name="_csrf_header" content="${_csrf.headerName}"/>
       <meta http-equiv="X-Frame-Options" content="SAMEORIGIN"/>
       <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
       <meta name="apple-mobile-web-app-capable" content="yes">
       <style type="text/css">
		#app-header {
		background-image: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #8fc33a), color-stop(100%, #739b2e));
		background-image: -webkit-linear-gradient(top, #8fc33a, #739b2e);
		background-image: -moz-linear-gradient(top, #8fc33a, #739b2e);             
		background-image: -o-linear-gradient(top, #8fc33a, #739b2e);
		background-image: -ms-linear-gradient(top, #8fc33a, #739b2e);
		background-image: linear-gradient(top, #8fc33a, #739b2e);
		filter: progid:DXImageTransform.Microsoft.gradient.(GradientType=0, startColorstr='#8fc33a', endColorstr='#739b2e');
		border-bottom: 1px solid #567422;
		}
		#app-header-title {
		padding: 15px 10px 10px 31px;
		color: white;
		font-size: 18px;
		font-weight: bold;
		text-shadow: 0 1px 0 #4e691f;
		}
		// There is no required CSS for this plugin to work properly 
		// but here is what is being used to style this demo
		.horizontal-nav {
		  border-radius: 6px;
		}
		.horizontal-nav ul {
		position: absolute;
		  left: 180px;
		  top : -12px;
		  float: left;
		  list-style:none;
		  text-align: center;
		  font-size: 14px;
		  font-weight: bold;
		  border-radius: 6px;
		}
		.horizontal-nav ul li {
		  float: left;
		}
		.horizontal-nav ul li:first-child {
		  border-left: 0 none;
		}
		.horizontal-nav ul li a {
		  display: block;
		  padding: 10px 20px;
		  color: #fff;
		  text-decoration:none;
		  border-top: 1px solid rgba(255,255,255, 0.25);
		  border-left: 1px solid rgba(255,255,255, 0.25);
		}
		.horizontal-nav ul li:first-child a {
		  border-left: 0 none;
		}
		.horizontal-nav ul li a:hover {
		  background: #567422;
		}
		.horizontal-nav ul li:first-child a {
		  border-top-left-radius: 6px;
		  border-bottom-left-radius: 6px;
		}
		.horizontal-nav ul li:last-child a {
		  border-top-right-radius: 6px;
		  border-bottom-right-radius: 6px;
		}
		.rowedit .x-grid-cell{
			background-color : #ffffcc !important;
		}
		.rowerror .x-grid-cell{
			background-color : #ffbbbb !important;
		}
		.rowecomfirm .x-grid-cell{
			background-color : #afe4fc !important;
		}
		.grid-delay {
			background-color : #f497b8 !important;
			color : #ffffff !important;
		}
		.grid-important {
			background-color : #fbd5e2 !important;
			color : #ffffff !important;
		}
		.grid-workreay {
			background-color : #ffd862 !important;
			color : #ffffff !important;
		}
		.grid-working {
			background-color : #7cc781 !important;
			color : #ffffff !important;
		}
		.grid-complete {
			background-color : #73abdd !important;
			color : #ffffff !important;
		}
		.grid-assignreay {
			background-color : #c2c2c2 !important;
			color : #ffffff !important;
		}
		.fa-check-circle:before{color:#36bbf7;}
		.fa-search:before{color:#36bbf7;}
		.fa-cloud-download:before{color:#ffcc00;}
		.x-label{
			vertical-align: middle;
		}
		.x-column-header-inner.redheader {
			color:red;
		}
		<c:if test="${_category  == 'qualityhist'}">
		.x-grid-item{
			color:#404040;
			font:normal 12px/19px 'Open Sans', 'Helvetica Neue', helvetica, arial, verdana, sans-serif;
			background-color:#fff
		}
		.x-column-header{
			border-right:1px solid #d0d0d0;
			color:#404040;
			font:400 12px/19px 'Open Sans', 'Helvetica Neue', helvetica, arial, verdana, sans-serif;
			outline:0;
			background-color:#fff
		}
		</c:if>
		<c:if test="${_category  == 'stabilization' || _category  == 'stabilizationm'}">
		.x-panel-header-title-default{
			color : #000000;
			font-weight : 800;
		}
		</c:if>
		<c:if test="${_category  == 'stabilizationm'}">
	 	.clock {
			/* transform-origin: 0 0;
			transform: scale(.55);
			-ms-transform: scale(.55);
			-webkit-transform-origin: 0 0;
			-webkit-transform: scale(.55);
			-o-transform-origin: 0 0;
			-o-transform: scale(.55);
			-moz-transform-origin: 0 0;
			-moz-transform: sacle(.55); */
			zoom:0.73;
			-moz-transform:sacle(.73);
		}
		</c:if>
		.grid-row-span .x-grid3-row {
			border-bottom: 0;
		}
		.grid-row-span .x-grid3-col {
			border-bottom: 1px solid #ededed;
		}
		.grid-row-span .row-span-first {
			position: relative;
		}
		.grid-row-span .row-span-first .x-grid3-cell-inner {
			position : absolute;
		}
		.grid-row-span .row-span-last {
			border-bottom: 1px solid #ededed;
		}
		.x-legend-container {
			border:0;
		}
		.x-docked-left.x-legend .x-legend-item,
		.x-docked-right.x-legend .x-legend-item,
		.x-docked-left.x-legend-panel .x-legend-item,
		.x-docked-right.x-legend-panel .x-legend-item{
			border-top: 0;
		}
		.x-viewport, .x-viewport > .x-body {
			touch-action : auto;
		}
	   </style>
       <script type="text/javascript" src="/int/resources/ext/ext-all.js?version=${version}"></script>
       <!-- <script type="text/javascript" src="/int/resources/ext-charts/build/ext-charts.js"></script> -->
       <script type="text/javascript" src="/int/resources/ext/charts.js"></script>
       <script type="text/javascript" src="/int/resources/ux/ux-debug.js"></script>
       <script type="text/javascript" src="/int/resources/ux/BoxReorderer.js"></script>
       <script type ="text/javascript" src="/int/ext/core/core.js?version=${version}"></script>  
      <!--  <script type="text/javascript" src="/int/resources/ext/Exporter-all.js"></script> -->
       <script type ="text/javascript" src="/int/ext/${_category}/${_ui}.js?version=${version}"></script>
        <script type="text/javascript" src="/int/resources/js/jquery-1.7.1.min.js"></script>
       <c:if test="${(_category  == 'nlayout' || _category  == 'portal') && CALL_LOC == 'internal'}">
       <script type="text/javascript" src="/int/resources/js/sockjs-0.3.4.min.js"></script>
       <script type="text/javascript" src="/int/resources/js/stomp.js"></script>
       </c:if>
       <c:if test="${_category  == 'stabilization' || _category  == 'stabilizationm'}">
       <script type="text/javascript" src="/int/resources/js/flipclock.js"></script>
       </c:if>
    </head>
    <body>
    	<script type="text/javascript">
    	var G_IS_HADNS = "${IS_HANDS}";
    	var G_IS_CT_HANDS = "${IS_CT_HANDS}";
    	var M_URL = "${M_URL}";
    	var M_RESOURCE_ID = "${M_RESOURCE_ID}";
    	var M_RESOURCE_NAME = "${M_RESOURCE_NAME}";
    	var M_RESOURCE_TYPE = "${M_RESOURCE_TYPE}";
    	var M_RESOURCE_CONTENT = '${M_RESOURCE_CONTENT}';
    	var G_MAX_CONNECTION = "${_maxConnection}";
    	var G_IS_LOGIN = "${IS_LOGIN}";
    	var G_LOGIN_NAME = "${LOGIN_NAME}";
    	var G_LOGIN_ID = "${LOGIN_ID}";
    	var G_BOARD_NO = "${BOARD_NO}";
    	G_TOKEN = "${_csrf.token}";
    	var app = window.navigator.userAgent.toLowerCase();
    	/* if (app.indexOf("chrome") == -1) {
    		alert("Chrome 브라우저에서 최적화 되어 있습니다.\nChrome 브라우저로 실행하시기 바랍니다.")
    		document.location.href = "/int/etc/guide.html";
    	} else {
    		var version = window.navigator.appVersion.toLowerCase();
    		var index = version.indexOf("chrome");
    		if (index != -1) {
    			var temp = parseInt(version.substring(index+7).substring(0,2));
    			if (temp < 40) {
    				alert("지원되는 브라우저의 버전이 낮습니다.\nChrome 40.x.x 이상 버전을 사용하시기 바랍니다.");
    	    		document.location.href = "/int/etc/guide.html";
    			}
    		}
    	} */
    	</script>
    	<c:if test="${_category  == 'nlayout'  && CALL_LOC == 'internal'}">
    	<script type="text/javascript">
    	window.addEventListener('load', function() {
    		if (Notification.permission !== "granted")
    			Notification.requestPermission();
    	});
    	</script>
    	<script type="text/javascript" src="/int/resources/js/notice-websocket.js?version=${version}"></script>
    	</c:if>
    	<c:if test="${_category  == 'portal'  && CALL_LOC == 'internal'}">
    	<script type="text/javascript" src="/int/resources/js/portal-websocket.js?version=${version}"></script> 
    	<script type="text/javascript" src="/int/resources/js/portal-event-websocket.js?version=${version}"></script>
    	</c:if>
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 	
    </body>
</html>