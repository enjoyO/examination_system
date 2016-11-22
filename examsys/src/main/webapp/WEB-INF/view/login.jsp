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
<title>login</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	var password_right=0;
	password_right=${tag};
	if(password_right==1){
		alert("password or username is wrong!");
		}
});
</script>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8;height:768px">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4" style="background-color:#f5f5f5;margin-top:180px">
					<h2 style="text-align: center">Log In</h2>
					<br>
					<form role="form" action="${pageContext.request.contextPath }/login/userlogin">
						<div class="form-group">
							 
							<label for="username">
								user name:
							</label>
							<input type="text" class="form-control" id="username" name="username"/>
						</div>
						<div class="form-group">
							 
							<label for="password">
								Password:
							</label>
							<input type="password" class="form-control" id="password" name="password"/>
						</div>
						<div class="form-group">
							<div class="col-md-3">
								<button type="submit" class="btn btn-default">
									Log in
								</button>
							</div>
							<div class="col-md-3">
								<a href="${pageContext.request.contextPath }/signup" class="btn btn-default">Sign up</a>
							</div>
							<div class="col-md-6"></div>
						</div>
						<br><br><br><br>
					</form>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>