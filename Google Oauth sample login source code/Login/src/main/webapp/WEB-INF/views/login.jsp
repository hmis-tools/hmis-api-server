<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>HDI</title>

	<!-- Google Font CSS 
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>-->
    
    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/css/custom.css" rel="stylesheet">

    <!-- Morris Charts CSS 
    <link href="css/plugins/morris.css" rel="stylesheet">-->

    <!-- Custom Fonts -->
    <link href="${contextPath}/resources/font/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <div class="row">
                	
                    <div class="col-xs-12 col-sm-12 col-md-12 center-block">
                    	<a class="navbar-brand" href="index.html">Login</a>
                    </div>
                    
                </div>
            </div>
        </nav>

        <div id="page-wrapper">

            <div class="container">
            		<div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12">
                            <img src="${contextPath}/resources/img/logo.jpg" class="logo center-block">
                        </div>
                    </div>
                 <div class="row">
                      <form id="login-form"  class="form-signin" action="temp_login" method="POST" onsubmit="return(validate());" autocomplete="off">
                      	
                            <p style="color: red !important; text-align: center;">
					 <% 
					 if (request.getParameter("error_message") != "" && request.getParameter("error_message") != null) 
					 {
					 	 out.println(request. getParameter("error_message"));
					 	 
					 }
					 
					 %>
                            </p>
                        
                        <label for="inputEmail" class="sr-only">User ID</label>
                        <input type="text" name="j_username" id="j_username" class="form-control" placeholder="User ID" autofocus>
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" name="j_password" id="j_password" class="form-control" placeholder="Password" >
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" value="remember-me"> Remember me
                          </label>
                        </div>
                        <button type="submit" data-role="button" data-transition="slide" class="btn btn-lg btn-primary btn-block">Submit</button>
                        <!--<a href="Client_add.html" class="btn btn-lg btn-primary btn-block" type="submit">Submit</a>-->
                      </form>
                    </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script type="text/javascript">
<!--
// Form validation code will come here.
function validate()
{
   
   var username=myTrim(document.getElementById("j_username").value);
   var password=myTrim(document.getElementById("j_password").value);
     
   if(username == "")
   {
     alert( "Please provide your Username!" );
     document.getElementById("j_username").focus() ;
     return false;
   }
   if(password== "")
   {
     alert( "Please provide your Password!" );
     document.getElementById("j_password").focus() ;
     return false;
   } 
   document.getElementById("j_username").value=username;
   document.getElementById("j_password").value=password;
  
   return( true );
}

function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}

//-->
</script>
    <script src="${contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script> -->
      
</body>

</html>
