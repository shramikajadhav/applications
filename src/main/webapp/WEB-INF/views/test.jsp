<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Art Gallery</title>
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
    <!-- end menu row (header) -->
    <div class="row">
      <div class="twelve columns">
        <div class="flex-video widescreen vimeo">
          <iframe src="http://player.vimeo.com/video/4749536?title=0&amp;byline=0&amp;portrait=0&amp;color=ffffff" width="900" height="506" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="twelve columns">
        <div class="panel callout">
          <h1 class="heading_supersize">Welcome to our ultra Artisitic website</h1>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="four columns">
        <h3>Adipiscing Elit</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc viverra, lacus id interdum ultrices, elit metus semper tellus, vel lacinia libero purus vitae risus. Integer a eros sit amet felis tincidunt commodo.</p>
        <a class="button round" href="#">More &raquo;</a> </div>
      <div class="four columns">
        <h3>Lectus Congue</h3>
        <p>Vivamus tortor tellus, rutrum sit amet mollis vel, imperdiet consectetur orci. Mauris pharetra congue enim, et sagittis lectus congue ut. Cum sociis natoque penatibus et magnis dis parturient montes.</p>
        <a class="button round" href="#">More &raquo;</a> </div>
      <div class="four columns">
        <h3>Gravida Pharetra</h3>
        <p>Sed vitae nisi leo. Nulla tincidunt, turpis non gravida pharetra, diam sapien posuere massa, non luctus leo mauris at sapien. Donec ut fermentum eros. Vestibulum placerat dui sit amet quam.</p>
        <a class="button round" href="#">More &raquo;</a> </div>
    </div>
    <div class="row">
      <div class="twelve columns">
        <ul id="menu3" class="footer_menu horizontal">
          <li ><a href="test.htm">Home</a></li>
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
