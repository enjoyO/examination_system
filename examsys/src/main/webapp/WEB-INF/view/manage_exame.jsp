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
<title>Manage Exams</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8">
		<div class="col-md-2">
		</div>
		<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
		<div class="row" style="height:750px;margin-right:20px;margin-left:20px">
		<h2 style="text-align: center; color:red">All the test results of examiners</h2><br>
		<table class="table">
			<tr class="success">
				<td>name</td>
				<td>phone</td>
				<td>email</td>
				<td>total score</td>
				<td>single score</td>
				<td>multiple score</td>
				<td>judge score</td>
				<td>essay score</td>
				<td>your given score</td>
				<td>check</td>
			</tr>
			${result }
		</table>
		<!-- return -->
			<div class="row">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/manage/return">
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