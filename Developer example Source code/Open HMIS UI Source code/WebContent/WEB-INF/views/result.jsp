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

    <title>Client List</title>

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
                <div class="col-xs-2 col-sm-2 col-md-2">
                       
                    </div>
                   <div class="col-xs-8 col-sm-8 col-md-8">
                    	<a class="navbar-brand center-block" href="Client_add.html">Client List</a>
                    </div>
                    <div class="col-xs-2 col-sm-2 col-md-2">
							<a href="${contextPath}/logout"><img src="${contextPath}/resources/img/logout.png" class="pull-right search_icon" ></a>                            </div>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">

            <div class="container">
                <div class="home_alignment">
                	<!--<div class="row">
                    	<div class="col-lg-2 col-sm-4 col-xs-6 pull-right">
                        	<a href="#" class="btn btn-lg btn-default btn-block">Add New Client</a>
                        </div>
                    </div>-->
                    <div class="row">
                    <div class="col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1">
                        <table class="table">
                              <thead>
                                <tr>
                                  <th>Sr No</th>
                                  <th>Client Key</th>
                                  <th>Client Name</th>
                                  <th>Client DOB</th>
                                  <th>Ssn Number</th>
                                </tr>
                              </thead>
                              <c:forEach items="${clientList}" var="clientList"
                                  varStatus="itemCount">
                                  <tr>
                                  <td>${itemCount.index+1}</td>
                                      <td><a
                                          href="${contextPath}/clients/clientdetail/${clientList.clientKey}"><c:out
                                                  value="${clientList.clientKey}" /></a></td>
                                      <td><c:out value="${clientList.nameFirst}" />&nbsp;<c:out
                                              value="${clientList.nameMiddle}" />&nbsp;<c:out
                                              value="${clientList.nameLast}" /></td>
                                      <td><c:out value="${clientList.dateOfBirth}" /></td>
                                      <td><c:out value="${clientList.socSecNumber}" /></td>
              
                                  </tr>
                              </c:forEach>
                            </table>
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
