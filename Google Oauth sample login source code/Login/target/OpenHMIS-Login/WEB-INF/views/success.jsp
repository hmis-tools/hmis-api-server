<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login Success page</title>

<!-- Bootstrap Core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${contextPath}/resources/css/custom.css" rel="stylesheet">

<!-- Morris Charts CSS 
    <link href="css/plugins/morris.css" rel="stylesheet">-->

<!-- Custom Fonts -->
<link href="${contextPath}/resources/font/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

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
					<div class="col-xs-2 col-sm-2 col-md-2"></div>
					<div class="col-xs-8 col-sm-8 col-md-8">
						<a class="navbar-brand center-block" href="Client_add.html"></a>
					</div>
					<div class="col-xs-2 col-sm-2 col-md-2">
						<a href="${contextPath}/logout"><img
							src="${contextPath}/resources/img/logout.png"
							class="pull-right search_icon"></a>
					</div>
				</div>
			</div>
		</nav>

		<div id="page-wrapper">

			<div class="container">
				<div class="home_alignment">
					<!--<div class="row pull-right" >
                    	<div class="col-lg-2 col-sm-4 col-xs-6 pull-right">
                        	<a href="#" class="btn btn-lg btn-default btn-block">Add New Client</a>
                        </div>
                    </div>-->
					<div class="row">
						<div class="col-md-12 animated fadeIn" style="opacity: 10;text-align:center;font-size:26px;">
                            <strong ">User Logged In Successfully</strong>
                        </div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
</body>

<script type="text/javascript">
<!--
	// Form validation code will come here.
	function validate() {

		var firstName = myTrim(document.getElementById("firstName").value);

		if (firstName == "") {
			alert("Please provide your Firstname!");
			document.getElementById("firstName").focus();
			return false;
		}

		document.getElementById("firstName").value = firstName;

		return (true);
	}

	function myTrim(x) {
		return x.replace(/^\s+|\s+$/gm, '');
	}
//-->
</script>
<!-- jQuery -->
<script src="${contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>
