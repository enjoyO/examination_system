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
<title>Create a paper</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
				<div class="row" style="margin-left: 20px;margin-right:20px">
				<!-- paper head -->
				<h2 style="text-align: center; color:red">Create a Paper</h2>
				<div class="row">
				<table class="table">
						<tr class="success">
							<td>name: ${papername }</td>
							<td>type: ${papertype }</td>
							<td>examine time: ${papertime }</td>
							<td></td>
						</tr>
						<tr class="danger">
							<td>paper info</td>
							<td>${paperinfo }</td>
							<td></td>
							<td></td>
						</tr>
				</table>
				</div>
				<!-- show the questions already created -->
				<div class="row">
					<h3>1. single choice questions</h3>
					<p style="color:red ">Select a choice which is an answer to the question. The question has only one answer</p>
					<table class="table">
					${singleques }
					</table>
				</div>
				<div class="row">
					<h3>2. multiple choice questions</h3>
					<p style="color:red ">The question may have more than one answer</p>
					<table class="table">
					${multipleques }
					</table>
				</div>
				<div class="row">
					<h3>3. judge questions</h3>
					<p style="color:red ">Judge the statement true or false</p>
					<table class="table">
					${judgeques }
					</table>
				</div>
				<div class="row">
					<h3>4. essay questions</h3>
					<p style="color:red ">Give your answers to the question</p>
					<table class="table">
					${essayques }
					</table>
				</div>
				
				<!-- hide all the question div when loading -->
				<script type="text/javascript">
					$(document).ready(function(){
						$("#single").hide();
						$("#multiple").hide();
						$("#judge").hide();
						$("#essay").hide();
						});
				</script>
				<!-- single choice div -->
				<div class="row" id="single">
				<h3>Create a single choice question</h3>
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/paper/addsingle">
						<div class="form-group">
							 
							<label for="question" class="col-sm-2 control-label">
								question
							</label>
							<div class="col-sm-10">
								<textarea rows="5" class="form-control" id="questions" name="question"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div>
								<input type="hidden" name="paperid" value="${paperid }"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="cha" class="col-sm-2 control-label">
								choice A:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="cha" name="choicea"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chb" class="col-sm-2 control-label">
								choice B:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chb" name="choiceb"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chc" class="col-sm-2 control-label">
								choice C:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chc" name="choicec"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								choice D:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chd" name="choiced"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								answer:
							</label>
							<div class="col-sm-10">
								<select class="form-control" id="answer" name="answer">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									create
								</button>
							</div>
						</div>
					</form>
				</div>
				
				<!-- multiple choice div -->
				<div class="row" id="multiple">
				<h3>Create a multiple choice question</h3>
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/paper/addmultiple">
						<div class="form-group">
							<div>
								<input type="hidden" name="paperid" value="${paperid }"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="question" class="col-sm-2 control-label">
								question
							</label>
							<div class="col-sm-10">
								<textarea rows="5" class="form-control" id="questions" name="question"></textarea>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="cha" class="col-sm-2 control-label">
								choice A:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="cha" name="choicea"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chb" class="col-sm-2 control-label">
								choice B:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chb" name="choiceb" />
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chc" class="col-sm-2 control-label">
								choice C:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chc" name="choicec"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								choice D:
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="chd" name="choiced"/>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								answer:
							</label>
							<div class="col-sm-10">
								<label class="checkbox-inline">
									<input type="checkbox" value="A" name="answer"/>A
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="B" name="answer"/>B
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="C" name="answer"/>C
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="D" name="answer"/>D
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									create
								</button>
							</div>
						</div>
					</form>
				</div>
				
				<!-- judge question div -->
				<div class="row" id="judge">
				<h3>Create a judge question</h3>
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/paper/addjudge">
						<div class="form-group">
							<div>
								<input type="hidden" name="paperid" value="${paperid }"/>
							</div>
						</div>
						<div class="form-group">
							<label for="question" class="col-sm-2 control-label">
								judge
							</label>
							<div class="col-sm-10">
								<textarea rows="5" class="form-control" id="questions" name="question"></textarea>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								answer:
							</label>
							<div class="col-sm-10">
								<label class="checkbox-inline">
									<input type="radio" value="right" name="answer" checked/>True
								</label>
								<label class="checkbox-inline">
									<input type="radio" value="wrong" name="answer"/>False
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									create
								</button>
							</div>
						</div>
					</form>
				</div>
				
				<!-- essay question div -->
				<div class="row" id="essay">
				<h3>Create a essay question</h3>
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/paper/addessay">
						<div class="form-group">
							<div>
								<input type="hidden" name="paperid" value="${paperid }"/>
							</div>
						</div>
						<div class="form-group">
							<label for="question" class="col-sm-2 control-label">
								question
							</label>
							<div class="col-sm-10">
								<textarea rows="5" class="form-control" id="questions" name="question"></textarea>
							</div>
						</div>
						<div class="form-group">
							 
							<label for="chd" class="col-sm-2 control-label">
								answer:
							</label>
							<div class="col-sm-10">
								<textarea rows="5" class="form-control" name="answer" ></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">
									create
								</button>
							</div>
						</div>
					</form>
				</div>
				
				<!-- choose and add questions -->
				<div class="row">
					<table class="table">
						<tr>
									<td>
										<div class="form-group">
											<label for="chd" class="col-sm-3 control-label">
												choose question type:  </label>
											<div class="col-sm-9">
												<select class="form-control"
													id="questiontype" name="questiontype">
													<option value="1">single choice</option>
													<option value="2">judge</option>
													<option value="3">multiple choice</option>
													<option value="4">essay questions</option>
												</select>
											</div>
										</div>

									</td>
									<td>
											<button type="submit" class="btn btn-primary" id="choseqtype">create</button>
									</td>
						</tr>
					</table>
				</div>	
				<!-- show the question type when choose creating this type of question -->
				<script type="text/javascript">
					$("#choseqtype").click(function(){
						var tag=$("#questiontype").val();
						if(tag=="1"){
							$("#single").show();
							$("#multiple").hide();
							$("#judge").hide();
							$("#essay").hide();
						}
						if(tag=="2"){
							$("#single").hide();
							$("#multiple").hide();
							$("#judge").show();
							$("#essay").hide();	
						}
						if(tag=="3"){
							$("#single").hide();
							$("#multiple").show();
							$("#judge").hide();
							$("#essay").hide();
						}
						if(tag=="4"){
							$("#single").hide();
							$("#multiple").hide();
							$("#judge").hide();
							$("#essay").show();
						}
						});
				</script>
				<!-- return to home page -->
				<div class="row">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/paper/return">
					<div class="form-group">
						<button type="submit" class="btn btn-default">
							return
						</button>
					</div>
				</form>
				</div>
				
				</div>
				<div class="col-md-2">
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>