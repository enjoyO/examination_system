<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/layoutit/src/css/style.css" rel="stylesheet">
<title>Sign Up</title>
</head>
<style>
.error{
color:red;
	}
</style>
<body>
<%@include file="navigate.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	var name_exist_tag=0;
	name_exist_tag=${tag};
	if(name_exist_tag==1){
		alert("user name exist");
		}
});
</script>
<%@include file="navigate.jsp" %>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/layoutit/src/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery_validation/lib/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery_validation/dist/jquery.validate.min.js"></script>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8;height:768px">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4" style="background-color:#f5f5f5;margin-top:80px">
				<br><br>
					<h2 style="text-align:center">Sign</h2>
					<br><br>
					<form role="form" id="signup" action="${pageContext.request.contextPath}/signup/adduser">
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
							 
							<label for="rpassword">
								Password again:
							</label>
							<input type="password" class="form-control" id="rpassword" name="rpassword"/>
						</div>
						<div class="form-group">
							 
							<label for="email">
								email:
							</label>
							<input type="email" class="form-control" id="email" name="email"/>
						</div>
						<div class="form-group">
							 
							<label for="phone">
								phone:
							</label>
							<input type="text" class="form-control" id="phone" name="phone"/>
						</div>
						<div class="form-group">
							 
							<label for="address">
								address:
							</label>
							<input type="text" class="form-control" id="address" name="address"/>
						</div>
						<button type="submit" class="btn btn-default" id="btn1">
							Submit
						</button>
						<br><br>
					</form>
					<script type="text/javascript">
						$("#signup").validate({
							rules:{
									username: "required",
									password: "required",
									rpassword: {
										required: true,
										equalTo: "#password",
										},
									email: "required",
									phone: "required"
									},
									
							errorPlacement: function(error, element) {
							// Append error within linked label
								$( element )
									.closest( "form" )
										.find( "label[for='" + element.attr( "id" ) + "']" )
											.append( error );
								},
							errorElement: "span",
							messages:{
									password:"please input password",
									rpassword:{
										required:"please input password",
										equalTo: "password not same"
										}
								}
						});
					</script>
				
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