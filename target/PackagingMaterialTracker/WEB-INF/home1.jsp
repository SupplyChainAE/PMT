<jsp:include page="/framework-resouce.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--<html> 
<head> -->
<title>Packaging Material Request</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#form").validate();
						$("form")
								.submit(
										function(e) {
											$("#form").validate();
											if ($(".para").hasClass("error50")) {
												e.preventDefault();
												noty({
													text : "Minimum quantity of bags should be 50 or multiple of 50",
													type : "error",
													layout : "topRight"
												});
											}
										});
						$(".para")
								.on(
										"change",
										function() {
											var value = $(this).val();
											// 											for (var i = 0, len = value.length; i < len; ++i) {
											if (value != "") {
												var result = value % 50;
												if (result != 0) {
													$(this).addClass("error50");
													noty({
														text : "Minimum quantity of bags should be 50 or multiple of 50",
														type : "error",
														layout : "topRight"
													});
												} else {
													$(this).removeClass(
															"error50");
												}
											} else {
												$(this).removeClass("error50");
											}
											// 											}
										});
						$('#daterange').daterangepicker({
							format : "DD/MM/YYYY"
						});

					});
</script>
<c:if test="${not empty message}">
	<script type="text/javascript">
		alert("${message}");
		window.location = "CreateRequest/${sellerCode}";
		</c:if>
	</script>

	</head>
	<body>
		<div id="content" class="col-sm-12 full">
			<!--  -->
			<!--  -->

			<div class="panel panel-primary">
				<div class="panel-body">
					<div class="panel panel-primary">
						<div class="panel-body">
							<h2 align="center">Packaging Material Request</h2>
							<center>
								<form id="form" method="post"
									action="/PackagingMaterialTracker/save" name="SellerRequest">

									<div class="row">
										<div class="col-lg-12 hidden" style="Margin-Top: 20px">
											<label>Seller Code</label><input type="text"
												name="SellerCode" value="${sellerCode}" class="form-control">
										</div>
										<div class="col-lg-12" style="Margin-Top: 20px">
											<div class="col-lg-4">
												<div class="form-group">
													<label>6.5&quot * 6.5&quot</label> <input type="text"
														name="para1" class="form-control para digits"
														data-rel="tooltip"
														title="Minimum quantity of bags should be 50 or multiple of 50">
												</div>
											</div>
											<div class="col-lg-4">
												<label>8&quot * 8&quot</label> <input type="text"
													name="para2" class="form-control para digits"
													data-rel="tooltip"
													title="Minimum quantity of bags should be 50 or multiple of 50">
											</div>
											<div class="col-lg-4">
												<label>10&quot * 10&quot</label> <input type="text"
													name="para3" class="form-control para digits"
													data-rel="tooltip"
													title="Minimum quantity of bags should be 50 or multiple of 50"">
											</div>
										</div>
										<div class="col-lg-12" style="Margin-Top: 20px">
											<div class="col-lg-4">
												<label>12&quot * 12&quot</label> <input type="text"
													name="para4" class="form-control para digits"
													data-rel="tooltip"
													title="Minimum quantity of bags should be 50 or multiple of 50">
											</div>
											<div class="col-lg-4">
												<label>14&quot * 16&quot</label> <input type="text"
													name="para5" class="form-control para digits"
													data-rel="tooltip"
													title="Minimum quantity of bags should be 50 or multiple of 50"">
											</div>
											<div class="col-lg-4">
												<label>18&quot * 18&quot</label> <input type="text"
													name="para6" class="form-control para digits"
													data-rel="tooltip"
													title="Minimum quantity of bags should be 50 or multiple of 50">
											</div>
											<div class="col-lg-12" style="Margin-Top: 20px">
												<div class="col-lg-4">
													<label>24&quot * 24&quot</label> <input type="text"
														name="para7" class="form-control para digits"
														data-rel="tooltip"
														title="Minimum quantity of bags should be 50 or multiple of 50">
												</div>

												<div class="col-lg-7">
													<label>Tape</label>
													<div class="col-lg-1">
														<a class="btn btn-primary"
															style="margin-left: 360px; height: 25px"
															data-rel="tooltip"
															title="We are not supplying tapes in Apparels, Footwear, Home Furnishing & large items like TV, microwave etc. Please use temper proof poly envelops to seal the product. Also Please use SD tapes only to wrap on the seal of product and if required on corners. Please don’t wrap on whole product or inside. So 2 tapes are sufficient for 100 bags as tapes we are sending with respect to bags size and quantity for sealing purpose.">?</a>
													</div>
													<input type="text" name="Para8" class="form-control digits"
														style="margin-bottom: 30px">
												</div>

											</div>
											<div class="col-lg-12"
												style="text-align: center; margin-top: 20px">
												<input type="submit" value="Save" class="btn btn-primary">
											</div>

										</div>
									</div>
								</form>
							</center>
						</div>
					</div>
					<form action="/PackagingMaterialTracker/Retrieve" method="Post"
						name="Retrieve">
						<div class="col-lg-12 hidden" style="Margin-Top: 20px">
							<label>Seller Code</label><input type="text" name="SellerCode"
								value="${sellerCode}" class="form-control">
						</div>
						<div class="panel panel-primary">
							<div class="panel-body">
								<h2 align="center">Previous Requests</h2>
								<div class="col-lg-12">
									<div class="col-lg-1">
										<label>Date Range</label>
									</div>
									<div class="col-lg-3">
										<fieldset>
											<div class="control-group">
												<div class="controls">
													<div class="input-prepend input-group">
														<span class="add-on input-group-addon"> <i
															class="glyphicon glyphicon-calendar fa fa-calendar"></i>
														</span> <input type="text" style="width: 200px"
															name="Reservation" id="daterange" class="form-control">
													</div>

												</div>
											</div>
										</fieldset>

										<!-- <script type="text/javascript">
										$(document)
												.ready(
														function() {
															$('#daterange')
																	.daterangepicker(
																			null,
																			function(
																					start,
																					end,
																					label) {
																				console
																						.log(
																								start
																										.toISOString(),
																								end
																										.toISOString(),
																								label);
																			});
														});
									</script> -->
									</div>
									<div class="col-lg-1">
										<input type="submit" value="submit" class="btn btn-primary">
									</div>
								</div>
								<div class="col-lg-12">
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable">
										<thead>
											<tr>
												<th>Request No.</th>
												<th>Request Status</th>
												<th>Comment</th>
												<th>6.5&quot * 6.5&quot</th>
												<th>8&quot * 8&quot</th>
												<th>10&quot * 10&quot</th>
												<th>12&quot * 12&quot</th>
												<th>14&quot * 16&quot</th>
												<th>18&quot * 18&quot</th>
												<th>24&quot * 24&quot</th>
												<th>Tape</th>
												<th>Created on</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="SellerRequest1" items="${requestList}">
												<tr>
													<td>${SellerRequest1.id}</td>
													<td>${SellerRequest1.requeststatus}</td>
													<td>${SellerRequest1.comment}</td>
													<td>${SellerRequest1.para1}</td>
													<td>${SellerRequest1.para2}</td>
													<td>${SellerRequest1.para3}</td>
													<td>${SellerRequest1.para4}</td>
													<td>${SellerRequest1.para5}</td>
													<td>${SellerRequest1.para6}</td>
													<td>${SellerRequest1.para7}</td>
													<td>${SellerRequest1.para8}</td>
													<td>${SellerRequest1.created}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	</html>