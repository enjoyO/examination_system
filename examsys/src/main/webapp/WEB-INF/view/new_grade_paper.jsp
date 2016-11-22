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
<title>Grade Paper</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8">
		<div class="col-md-2">
		</div>
		<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
			<div class="row" style="margin-left:20px;margin-right:20px;">
				<h2 style="text-align:center;color:red">Test information</h2><br>
				<table class="table">
					<tr class="success">
						<td>score of single</td>
						<td>score of multiple</td>
						<td>score of judge</td>
						<td>score of essay</td>
						<td>total score</td>
					</tr>
					<tr class="danger">
						<td>${singlescore }</td>
						<td>${multiplescore }</td>
						<td>${judgescore }</td>
						<td>${essayscore }</td>
						<td>${totalscore }/${paperscore }</td>
					</tr>
				</table>
				<table class="table">
					${result }
				</table>
				<!-- score given by teacher -->
			<div class="row">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/newmanage/submitscore">
					<div class="from-group">
					<input type="hidden" name="testid" value="${testid }">
						<label class="col-sm-3" >give a score for the paper</label>
						<div class="col-sm-3">
							<input type="text" name="teacherscore" class="form-control"/>
						</div>
						<div class="col-sm-2">
							<button type="submit" class="btn btn-default">
								submit
							</button>
						</div>
						<div class="col-sm-4">
						</div>
					</div>
				</form>
			</div>
			<!-- return -->
			<br><br>
			<div class="row">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/newmanage">
					<div class="form-group">
						<input type="hidden" name="paperid" value="${paperid }">
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