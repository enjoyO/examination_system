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
<title>Your page</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8">
		<div class="col-md-12" >
			<div class="row">
				<div class="col-md-2" >
				</div>
				<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
					<div class="row">
					<!-- left -->
						<div class="col-md-2" style="margin-top:80px">
						<a class="btn btn-block btn-primary" id="personcontroller">Personal Information</a>
						<a class="btn btn-block btn-primary" id="createcontroller">Create Papers</a>
						<a class="btn btn-block btn-primary" id="joincontroller">Joined Tests</a>
						<a class="btn btn-block btn-primary" id="searchcontroller">Search Tests</a>
						</div>
					<!-- right -->	
						<div class="col-md-10">
						<!-- personal information layer -->
							<div class="row" id="personlayer" style="height:750px">
								<div class="col-md-12">
								<div class="row">
								<br>
								<h2>Your Information</h2>
								<br>
								<table class="table">
									<tr class="success">
										<td>name </td>
										<td>email</td>
										<td>phone</td>
										<td>address</td>
									</tr>
									<tr class="danger">
										<td>${username }</td>
										<td>${email }</td>
										<td>${phone }</td>
										<td>${address }</td>
									</tr>
								</table>
								</div>
								
								<div class="row">
									<h2>Modify Your Information</h2><br>
										<form role="form" id="signup"
											action="${pageContext.request.contextPath}/homepage/modify">
											<input type="hidden" name="userid" value="${userid }"/>
											<div class="form-group row">
												<label for="username" class="col-sm-2"> user name: </label>
												<div class="col-sm-4">
												 <input type="text" class="form-control" id="username" name="username" />
												 </div>
												 <div class="col-sm-5"></div>
											</div>
											<div class="form-group row">
												<label for="password" class="col-sm-2"> Password: </label> 
												<div class="col-sm-4">
												<input type="password" class="form-control" id="password" name="password" />
												</div>
												<div class="col-sm-5"></div>
											</div>
											<div class="form-group row">
												<label for="email" class="col-sm-2"> email: </label> 
												<div class="col-sm-4">
												<input type="email" class="form-control" id="email" name="email" />
												</div>
												<div class="col-sm-5"></div>
											</div>
											<div class="form-group row">
												<label for="phone" class="col-sm-2"> phone: </label> 
												<div class="col-sm-4">
												<input type="text" class="form-control" id="phone" name="phone" />
												</div>
											</div>
											<div class="form-group row">
												<label for="address" class="col-sm-2"> address: </label> 
												<div class="col-sm-4">
												<input type="text" class="form-control" id="address" name="address" />
												</div>
												<div class="col-sm-5"></div>
											</div>
											<button type="submit" class="btn btn-default" id="btn1">
												Submit</button>
										</form>
										<br><br><br>
									</div>
								</div>
							</div>
						<!-- create paper layer -->
							<div class="row" id="createlayer" style="height:750px">
								<div class="col-md-12">
									<br>
									<h2>Create a Paper</h2>
									<br>
										<table class="table">
											<thead>
												<tr class="success">
													<td>paper id</td>
													<td>paper name</td>
													<td>paper type</td>
													<td>examine time</td>
													<td>add questions</td>
													<td>manage</td>
													<td>new type manage</td>
												</tr>
											</thead>
											<tbody>
											${papers }
											</tbody>
										</table>
										<br>
										<h2>Input the Paper Informations</h2><br>
										<form role="form"
											action="${pageContext.request.contextPath }/homepage/createpaper">
											<div class="form-group">
												<label for="papername"> paper name: </label> <input
													type="text" class="form-control" id="papername"
													name="papername" />
											</div>
											
											<div class="form-group">
											<label for="type"> paper type: </label>
												<select class="form-control" id="type" name="papertype">
													<option value="english">English</option>
													<option value="chinese">Chinese</option>
													<option value="math">Math</option>
													<option value="physis">Physics</option>
												</select>
											</div>
											
											<div class="form-group">
											<label for="time"> examine time: </label>
												<select class="form-control" id="time" name="papertime">
													<option value="0.5">30 minutes</option>
													<option value="1">1 hour</option>
													<option value="1.5">1.5 hour</option>
													<option value="2">2 hour</option>
													<option value="2.5">2.5 hour</option>
													<option value="3">3 hour</option>
												</select>
											</div>
											
											<div class="form-group">

												<label for="notice"> notice: </label> <textarea
													rows="10" class="form-control" id="notice"
													name="paperinfo" ></textarea>
											</div>
											<button type="submit" class="btn btn-default">
												Submit</button>
										</form>
										<br><br>
									</div>
							</div>
							
						<!-- joined test layer -->
							<div class="row" id="joinlayer" style="height:750px">
								<div class="col-md-12">
								<br>
									<h2>Joined Tests</h2><br>
									<table class="table">
										<tr class="success">
											<td>paper name</td>
											<td>type</td>
											<td>score by system</td>
											<td>score by teacher</td>
											<td>check</td>
											<td>test again</td>
										</tr>
										${joined }
									</table>
									<br>
									<h2>Joined New Type Tests</h2><br>
									<table class="table">
										<tr class="success">
											<td>paper name</td>
											<td>type</td>
											<td>score by system</td>
											<td>score by teacher</td>
											<td>check</td>
											<td>test again</td>
										</tr>
										${newjoined }
									</table>
								</div>
							</div>
							
						<!-- search paper layer -->
							<div class="row" id="searchlayer" style="height:750px">
								<div class="col-md-12">
								<br>
									<h2>Search Tests</h2>
									<p>Use the paper name or paper id to search and join the paper text</p><br>
									<form  class="form-horizontal" action="${pageContext.request.contextPath }/search/bypapername" >
										<div class="form-group">
											<label class="col-sm-2 control-label">
												Search by paper name:
											</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="papername"/>
											</div>
											<div class="col-sm-2">
												<button type="submit" class="form-control">search</button>
											</div>
											<div class="col-sm-4"></div>
										</div>
									</form>
									<form  class="form-horizontal" action="${pageContext.request.contextPath }/search/bypaperid" >
										<div class="form-group">
											<label class="col-sm-2 control-label">
												Search by paper id:
											</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="paperid"/>
											</div>
											<div class="col-sm-2">
												<button type="submit" class="form-control">search</button>
											</div>
											<div class="col-sm-4"></div>
										</div>
									</form>
									<table class="table">
									<tr class="success">
										<td>paper id</td>
										<td>paper name</td>
										<td>paper info</td>
										<td>paper type</td>
										<td>test</td>
										<td>new type test</td>
									</tr>
									${pps }
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var tag1=0;
		var tag2=${tag};
		if(tag2!=null){
			tag1=tag2;
			}
		if(tag1==0){
			$("#personlayer").show();
			$("#createlayer").hide();
			$("#joinlayer").hide();
			$("#searchlayer").hide();
			}
		if(tag1==1){
			$("#personlayer").hide();
			$("#createlayer").show();
			$("#joinlayer").hide();
			$("#searchlayer").hide();
			}
		if(tag1==2){
			$("#personlayer").hide();
			$("#createlayer").hide();
			$("#joinlayer").show();
			$("#searchlayer").hide();
			}
		if(tag1==3){
			$("#personlayer").hide();
			$("#createlayer").hide();
			$("#joinlayer").hide();
			$("#searchlayer").show();
			}
		});
	$("#personcontroller").click(function(){
		$("#personlayer").show();
		$("#createlayer").hide();
		$("#joinlayer").hide();
		$("#searchlayer").hide();
		});
	$("#createcontroller").click(function(){
		$("#personlayer").hide();
		$("#createlayer").show();
		$("#joinlayer").hide();
		$("#searchlayer").hide();
		});
	$("#joincontroller").click(function(){
		$("#personlayer").hide();
		$("#createlayer").hide();
		$("#joinlayer").show();
		$("#searchlayer").hide();
		});
	$("#searchcontroller").click(function(){
		$("#personlayer").hide();
		$("#createlayer").hide();
		$("#joinlayer").hide();
		$("#searchlayer").show();
		});
</script>
<%@include file="bottom.jsp" %>
</body>
</html>