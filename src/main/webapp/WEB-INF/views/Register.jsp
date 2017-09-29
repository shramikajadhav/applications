
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>BabyShower</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resources/stylesheets/foundation.min.css">
<link rel="stylesheet" href="resources/stylesheets/main.css">
<link rel="stylesheet" href="resources/stylesheets/app.css">
<script src="resources/javascripts/modernizr.foundation.js"></script>
<script src="resources/http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="resources/javascripts/blur/blur.min.js"></script>
<script>
$(document).ready(function ($) {
	$('.blur').blurjs({
		source: 'body',
		radius: 7,
		overlay: 'rgba(255,255,255,0.4)',
		optClass: 'blurred',
		cache: false
	});
});

</script>
<style>
hr{
height : 4px;
color: black;
border-style: inset;}
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #00264d;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '�';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Ranchers' rel='stylesheet' type='text/css'>
<!-- IE Fix for HTML5 Tags -->
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
<div class="row blur">
  <!-- page wrap -->
  <div class="twelve columns">
    <!-- page wrap -->
    <div class="row">
      <div class="nine columns" style="margin-bottom: 10px">
        <ul id="menu-header" class="nav-bar horizontal">
          
          <li style="padding : 30px; border : 2px;"><a href="loginuser.htm"><h style= "font-size : 30px; ">Login</h></a></li>
        	
        </ul>
        <script>$('ul#menu-header').nav-bar();</script>
        <div style="clear:both"></div>
      </div>
      <div class="three columns"><img src="resources/images/MainImage.jpg" style=" height : 150px;width : 250px;  padding-top: 15px" alt=""></div>
    </div>
    <hr></hr>
    <!-- end menu row (header) -->
    <div></div>
    
    <div>
   <form:form commandName="user" action="Register.htm" method="post">
<p><h4>USERNAME:</h4><br>
<form:input type="text" name="username" path="username"/><form:errors path="username"/>
<p><h4>FIRSTNAME:</h4><br>
<form:input type="text" name="firstname" path="firstname"/><form:errors path="firstname"/>
<p><h4>LASTNAME:</h4><br>
<form:input type="text" name="lastname" path="lastname"/><form:errors path="lastname"/>
<p><h4>PASSWORD:</h4><br>
<input type="password" name="password" path="password"><form:errors path="password"/>

<p><h4>User Type:</h4><br>
<select style=" height: 35px; font-size : 20px;" name="UserType" >
        
        <option  value="Customer" name="Customer">Customer
        <option value="Seller">Seller
        
    </select>
    
     <p></p>
<input type='checkbox' name='rememberMe' value="rememberMe"> 
                    Remember Me <br /><br />
                   
                    <input class = "button" type="submit" name="submit" value="Register" />
                    <input type="hidden" name="action" value="Register1" />
             
                
</form:form>

    <div></div>
   
   
    <div class="row">
      <div class="twelve columns">
        <ul id="menu3" class="footer_menu horizontal">
          <li ><a href="loginuser.htm">Home</a></li>
        </ul>
      </div>
    </div>
    <script>$('ul#menu3').nav-bar();</script>
  </div>
</div>
<!-- end page wrap) -->
<!-- Included JS Files (Compressed) -->
<script src="javascripts/foundation.min.js"></script>
<!-- Initialize JS Plugins -->
<script src="javascripts/app.js"></script>
</body>
</html>
