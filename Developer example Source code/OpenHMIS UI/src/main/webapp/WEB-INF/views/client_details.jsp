<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- @author Haridharan Durairaj -->
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Client Details</title>

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
						<a class="navbar-brand center-block" href="Client_add.html">Client
							List</a>
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
					<div class="row">
						<div
							class="col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1">
							<div class="bs-callout bs-callout-danger"
								id="callout-fieldset-disabled-ie">
<%-- 								<c:forEach items="${clientList}" var="clientList" --%>
<%-- 									varStatus="itemCount"> --%>

									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Client Key</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.clientKey}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>First Name</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.nameFirst}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Middle Name</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.nameMiddle}" /></span>
										</div>
									</div>

									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Last Name</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.nameLast}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>DOB</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.dateOfBirth}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Entry Date Time</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.entryDateTime}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Log Date Time</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.logDateTime}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Rec Active Gct</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.recActiveGct}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>SOC SecType Code</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.socSecTypeCode}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>ethnicityVO Description</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out
													value="${clientList.getEthnicityVO().getDescription()}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>Veteran Status Gct</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.veteranStatusGct}" /></span>
										</div>
									</div>
									<div class="full_detail row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><strong>socSecNumber</strong></span>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<span><c:out value="${clientList.socSecNumber}" /></span>
										</div>
									</div>
<%-- 								</c:forEach> --%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="${contextPath}/resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>

</html>
