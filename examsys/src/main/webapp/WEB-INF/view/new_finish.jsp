<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/style.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/scripts.js"></script>
<title>Test Result</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8">
		<div class="col-md-2">
		</div>
		<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
			<div class="row" style="margin-left:20px;margin-right:20px">
				<h2 style="text-align: center;color: red">Your Total Score is ${totalscore } / ${paperscore }</h2><br>
				<table class="table">
					<tr class="success">
						<td>score of single</td>
						<td>score of multiple</td>
						<td>score of judge</td>
						<td>score of essay</td>
					</tr>
					<tr class="danger">
						<td>${singlescore }</td>
						<td>${multiplescore }</td>
						<td>${judgescore }</td>
						<td>${essayscore }</td>
					</tr>
				</table>
				<table class="table">
					${result }
				</table>
				<!-- return -->
			<div class="row">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/newscore/return">
					<div class="form-group">
						<button type="submit" class="btn btn-default">
							return
						</button>
					</div>
				</form>
			</div>
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>