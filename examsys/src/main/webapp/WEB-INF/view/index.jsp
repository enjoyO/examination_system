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
<title>index</title>
</head>
<body>
<%@include file="navigate.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row" style="background-color: #338FCC; height: 650px">
				<div class="col-md-12" style="margin-top: 80px">
					<h2 class="text-center" style="color: white">
						New Type of Examine and Judge System
					</h2>
					<br><br>
					<div class="row">
						<div class="col-md-4">
						</div>
						<div class="col-md-4">
							<div class="carousel slide" id="carousel-614831">
								<ol class="carousel-indicators">
									<li class="active" data-slide-to="0" data-target="#carousel-614831">
									</li>
									<li data-slide-to="1" data-target="#carousel-614831">
									</li>
									<li data-slide-to="2" data-target="#carousel-614831">
									</li>
								</ol>
								<div class="carousel-inner">
									<div class="item active">
										<img alt="Carousel Bootstrap First" src="${pageContext.request.contextPath}/resources/img/pic1.jpg"/ width="550px">
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
									<div class="item">
										<img alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/img/pic2.jpg" width="550px" />
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
									<div class="item">
										<img alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/img/pic3.jpg" width="550px" />
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
									<div class="item">
										<img alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/img/pic4.jpg" width="550px" />
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
									<div class="item">
										<img alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/img/pic5.jpg" width="550px" />
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
									<div class="item">
										<img alt="Carousel Bootstrap Third" src="${pageContext.request.contextPath}/resources/img/pic6.jpg" width="550px" />
										<div class="carousel-caption">
											<h4>
												picture description
											</h4>
											<p>
												details
											</p>
										</div>
									</div>
								</div> <a class="left carousel-control" href="#carousel-614831" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-614831" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
							</div>
							<div class="row" style="text-align: center">
								<br><br>
								<a href="${pageContext.request.contextPath }/login" class="btn btn-default">Start Now</a>
							</div>
						</div>
						<div class="col-md-4">
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="background: #f5f5f5; height: 300px">
				<div class="col-md-12">
					<br><br>
					<h2 class="text-center">
						Introduction
					</h2>
					<br>
					<div class="row" style="margin-left: 100px;margin-right:100px">
						<div class="col-md-4">
							<h4 style="text-align:center">Create Paper Online</h4>
							<p>
								The system supports creating test papers online. There are four kinds of question types for users to 
								choose. The first kind is single choice question. The second kind is multiple choices question. The
								third kind is judge question and the last kind is essay question.
							</p>
						</div>
						<div class="col-md-4">
							<h4 style="text-align:center">Examine Online</h4>
							<p>
								Users can search the paper by name or by id and join the test online. There are two kinds of tests. The 
								first kind is common type. Examines only need to give the answer to the question and submit the answer.
								The second kind is the new type. Examines not only need to give the answer but also need to give his confidence
								about the answer.
							</p>
						</div>
						<div class="col-md-4">
							<h4 style="text-align:center">Judge Online</h4>
							<p>
								The system can auto judge the answer given by examines and give a score. Examines can check their paper after examine.
								The creator of the test can check all the test results of examines. At the same time, he or she also can give
								a score for the examines.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>