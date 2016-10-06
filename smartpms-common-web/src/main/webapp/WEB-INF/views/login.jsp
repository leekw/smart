<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Integration Support</title>

  <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900&subset=latin,greek,greek-ext,vietnamese,cyrillic-ext,latin-ext,cyrillic' rel='stylesheet' type='text/css'>

  <link rel="icon" type="image/png" sizes="16x16" href="/int/angular/assets/img/favicon-16x16.png">
  <link rel="icon" type="image/png" sizes="32x32" href="/int/angular/assets/img/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="96x96" href="/int/angular/assets/img/favicon-96x96.png">

  <!-- build:css({.tmp/serve,src}) styles/vendor.css -->
  <!-- bower:css -->
  <link rel="stylesheet" href="/int/angular/lib/ionicons.css" >
  <link rel="stylesheet" href="/int/angular/lib/angular-toastr.css" >
  <link rel="stylesheet" href="/int/angular/lib/animate.css" >
  <link rel="stylesheet" href="/int/angular/lib/bootstrap.css" >
  <link rel="stylesheet" href="/int/angular/lib/bootstrap-select.css" >
  <link rel="stylesheet" href="/int/angular/lib/bootstrap-switch.css" >
  <link rel="stylesheet" href="/int/angular/lib/bootstrap-tagsinput.css" >
  <link rel="stylesheet" href="/int/angular/lib/font-awesome.css" >
  <link rel="stylesheet" href="/int/angular/lib/fullcalendar.css" >
  <link rel="stylesheet" href="/int/angular/lib/leaflet.css" >
  <link rel="stylesheet" href="/int/angular/lib/angular-progress-button-styles.min.css" >
  <link rel="stylesheet" href="/int/angular/lib/angular-chart.css" >
  <link rel="stylesheet" href="/int/angular/lib/chartist.min.css" >
  <link rel="stylesheet" href="/int/angular/lib/morris.css" >
  <link rel="stylesheet" href="/int/angular/lib/ion.rangeSlider.css" >
  <link rel="stylesheet" href="/int/angular/lib/ion.rangeSlider.skinFlat.css" >
  <link rel="stylesheet" href="/int/angular/lib/textAngular.css" >
  <link rel="stylesheet" href="/int/angular/lib/xeditable.css" >
  <link rel="stylesheet" href="/int/angular/lib/style.css" >
  <!-- endbower -->
  <!-- endbuild -->

  <!-- build:css({.tmp/serve,src}) styles/auth.css -->
  <!-- inject:css -->
  <link rel="stylesheet" href="/int/angular/app/auth.css">
  <!-- endinject -->
  <!-- endbuild -->
</head>
<body>
<main class="auth-main">
  <div class="auth-block">
    <h1>Login in to Intgr. Support</h1>
    <a href="reg.html" class="auth-link">New to Intgr. Support? Sign up!</a>

    <form class="form-horizontal" action="/int/login/process.do" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">UserName</label>

        <div class="col-sm-10">
          <input type="username" name="userId" class="form-control" id="inputEmail3" placeholder="UserName">
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>

        <div class="col-sm-10">
          <input type="password" name="userPassword" class="form-control" id="inputPassword3" placeholder="Password">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default btn-auth">Sign in</button>
          <a href class="forgot-pass">Forgot password?</a>
        </div>
      </div>
    </form>

    <div class="auth-sep"><span><span>or Sign in with one click</span></span></div>

    <div class="al-share-auth">
      <ul class="al-share clearfix">
        <li><i class="socicon socicon-facebook" title="Share on Facebook"></i></li>
        <li><i class="socicon socicon-twitter" title="Share on Twitter"></i></li>
        <li><i class="socicon socicon-google" title="Share on Google Plus"></i></li>
      </ul>
    </div>
  </div>
</main>
</body>
</html>