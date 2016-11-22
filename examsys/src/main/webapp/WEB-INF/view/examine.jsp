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
<title>Examine</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row" style="background-color:#39D8D8;height:768px">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8" style="background-color:#f5f5f5;margin-top:80px">
					<!-- test information -->
					<div class="row" style="margin-left:100px;margin-right:100px">
						<table class="table">
							<tr class="success">
								<td>Question Type:  <span style="color:red"> ${type }</span></td>
								<td>Number: <span style="color:red">${number } </span></td>
								<td>Total Number: <span style="color:red">${total } </span></td>
								<td>Score:<span style="color:red"> ${score }</span></td>
							</tr>
						</table>
					</div>
					<!-- single div -->
					<div class="row" id="single" style="margin-left:100px;margin-right:100px">
						<p>${question }</p>
						<form role="form" action="${pageContext.request.contextPath }/examine/submitanswer">
						<input type="hidden" name="questionid" value="${questionid }"/>
						<div class="form-group">
						<label>
							<input type="radio" value="A" name="answer" />A. ${choicea }
						</label>
						</div>
						<div class="form-group">
						<label>
							<input type="radio" value="B" name="answer" />B. ${choiceb }
						</label>
						</div>
						<div class="form-group">
						<label>
							<input type="radio" value="C" name="answer" />C. ${choicec }
						</label>
						</div>
						<div class="form-group">
						<label>
							<input type="radio" value="D" name="answer" />D. ${choiced }
						</label>
						</div>
						<button type="submit" class="btn btn-primary">submit and go to next</button>
						</form>
					</div>
					<!-- multiple div-->
					<div class="row" id="multiple" style="margin-left:100px;margin-right:100px">
						<p>${question }</p>
						<form action="${pageContext.request.contextPath }/examine/submitanswer">
						<input type="hidden" name="questionid" value="${questionid }"/>
						<div class="form-group">
							<label>
								<input type="checkbox" value="A" name="answer" />A. ${choicea }
							</label>
						</div>
						<div class="form-group">
							<label>
								<input type="checkbox" value="B" name="answer" />B. ${choiceb }
							</label>
						</div>
						<div class="form-group">
							<label>
								<input type="checkbox" value="C" name="answer" />C. ${choicec }
							</label>
						</div>
						<div class="form-group">
							<label>
								<input type="checkbox" value="D" name="answer" />D. ${choiced }
							</label>
						</div>
							<button type="submit" class="btn btn-primary">submit and go to next</button>
						</form>
					</div>
					<!-- judge div-->
					<div class="row" id="judge" style="margin-left:100px;margin-right:100px">
						<p>${question }</p>
						<form action="${pageContext.request.contextPath }/examine/submitanswer">
						
						<input type="hidden" name="questionid" value="${questionid }"/>
						<div class="form-group">
							<label>
								<input type="radio" value="right" name="answer"/>True
							</label>
						</div>
						<div class="form-group">
							<label>
								<input type="radio" value="wrong" name="answer"/>false
							</label>
						</div>
							<button type="submit" class="btn btn-primary">submit and go to next</button>
						</form>
					</div>
					<!-- essay div -->
					<div class="row" id="essay" style="margin-left:100px;margin-right:100px">
						<p>${question }</p>
						<form role="form" action="${pageContext.request.contextPath }/examine/submitanswer">
						<input type="hidden" name="questionid" value="${questionid }"/>
						<div class="form-group">
							<label>
								give you answer here:
							</label>
						</div>
						<div class="form-group">
							<textarea rows="15" name="answer" class="form-control"></textarea>
						</div>
							<button type="submit" class="btn btn-primary">submit and go to next</button>
						</form>
					</div>
					<!-- no question div -->
					<div class="row" id="noques" style="margin-left:100px;margin-right:100px">
						<h2>there are no questions!</h2>
					</div>
					<!-- return -->
					<div class="row" style="margin-left:100px;margin-right:100px">
					<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/examine/return">
					<br><br>
					<div class="form-group">
						<button type="submit" class="btn btn-default">
							return
						</button>
					</div>
				</form>
				</div>
				<div class="col-md-2">
				</div>
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
			$("#single").show();
			$("#multiple").hide();
			$("#judge").hide();
			$("#essay").hide();
			$("#noques").hide();
			}
		if(tag1==1){
			$("#single").hide();
			$("#multiple").show();
			$("#judge").hide();
			$("#essay").hide();
			$("#noques").hide();
			}
		if(tag1==2){
			$("#single").hide();
			$("#multiple").hide();
			$("#judge").show();
			$("#essay").hide();
			$("#noques").hide();
			}
		if(tag1==3){
			$("#single").hide();
			$("#multiple").hide();
			$("#judge").hide();
			$("#essay").show();
			$("#noques").hide();
			}
		if(tag1==4){
			$("#single").hide();
			$("#multiple").hide();
			$("#judge").hide();
			$("#essay").hide();
			$("#noques").show();
			}
		});
</script>
<%@include file="bottom.jsp" %>
</body>
</html>