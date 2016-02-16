<jsp:include page="/framework-resouce.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Packaging Material Request</title>
<script type="text/javascript">
	function showSummary() {
		
		var total = 0;
		var tqty = 0;
		var Table = document.getElementById("modalTable");
		Table.innerHTML = "";
		
		var row = Table.insertRow(0);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		
		
		cell1.innerHTML = "Parameter";
		cell2.innerHTML = "Quantity";
		cell3.innerHTML = "Amount";
	

		$(".data").each(function() {
			
			var element = new Object();
			element = $("#dummyRow").clone();
			var label = $(this).find("label:first").text();
			var value = $(this).find("input").eq(0).val();
			var name = $(this).find("input:first").attr("name");
			var amount = $(this).find('input').eq(1).val() * value;
			
			element.attr("id", label);
			element.find("td.dataLabel").text(label);
			element.find("td.dataValue").text(value);
			 element.find("td.dataPrice").text(amount); 
			element.find("td.hiddenValue").attr({
				"name" : name,
				"value" : value
			});
			tqty = tqty * 1 + value * 1 ;	
			
			total = total + amount; 
			$("#modalTable").append(element);
		});
		
		var element = new Object();
		element = $("#dummyRow").clone();
		
		 var value1 = tqty; 
		 var label = 'Total ';
		 var amount = total ; 
		 element.attr("id", label); 
		 element.find("td.dataLabel").text(label);
		 element.find("td.dataValue").text(value1); 
		 element.find("td.dataPrice").text(amount);
		 /* element.find("td.hiddenValue").attr({
			"name" : name,
			"value" : value
		}); */
		/* total = total + amount; */ 
	 
	  	 $("#modalTable").append(element);  
		
		$("#myModal").modal('show');
	}

	function formValidate() {
		/* alert("called"); */
		var modalFlag = 0
		if ($(".para").hasClass("error50")) {
			modalFlag = 1
			/*noty({
				text : "Minimum quantity of bags should be 50 or multiple of 50",
				type : "error",
				layout : "topRight"
			});*/
			alert("Minimum quantity of bags should be 100 or multiple of 100");
		}
		
		if ($("#securitySticker").hasClass("error40")) {
			modalFlag = 1
			/*noty({
				text : "Minimum quantity of security stickers should be 40 or multiple of 40",
				type : "error",
				layout : "topRight"
			});*/
			alert("Minimum quantity of security stickers should be 40 or multiple of 40");
		}
		
		if ($("#tape").hasClass("error3")) {
			modalFlag = 1
			/*noty({
				text : "Minimum quantity of security stickers should be 40 or multiple of 40",
				type : "error",
				layout : "topRight"
			});*/
			alert("Minimum quantity of tape should be 3 or multiple of 3");
		}
		
		
		var flag = 0
		$(".common").each(function() {
			if ($(this).val().trim() != '' && $(this).val() != "0"  ) {
				flag = 1;
			}
		});
		if (flag == 0) {

			modalFlag = 1
			/*noty({
				text : "Atleast one field is required",
				type : "error",
				layout : "topRight"
			});*/
			alert("Atleast one field is required");
		}
		if (modalFlag == 0) {
			showSummary();
		}
		return false;

	}

	$(document)
			.ready(
					function() {
						if ("${message}" != "") {
							alert("${message}");
						}
						
						if ("${flag}" != ""){
							
							/* $("#divCreate").attr('disabled','disabled'); */
							$('.common').prop("disabled", true);
						}
						
						$("#form").validate();
						$(".para")
								.on(
										"change",
										function() {
											var value = $(this).val();
											//for (var i = 0, len = value.length; i < len; ++i) {
											if (value != "") {
												var result = value % 100;
												if (result != 0) {
													$(this).addClass("error50");
													/*noty({
														text : "Minimum quantity of bags should be 50 or multiple of 50",
														type : "error",
														layout : "topRight"
													});*/
													alert("Minimum quantity of bags should be 100 or multiple of 100");
												} else {
													$(this).removeClass(
															"error50");
												}
											} else {
												$(this).removeClass("error50");
											}
										});
						
						$("#securitySticker")
						.on(
								"change",
								function() {
									var value = $(this).val();
									//for (var i = 0, len = value.length; i < len; ++i) {
									if (value != "") {
										var result = value % 40;
										if (result != 0) {
											$(this).addClass("error40");
											/*noty({
												text : "Minimum quantity of security stickers should be 40 or multiple of 40",
												type : "error",
												layout : "topRight"
											});*/
											alert("Minimum quantity of security stickers should be 40 or multiple of 40");
										} else {
											$(this).removeClass(
													"error40");
										}
									} else {
										$(this).removeClass("error40");
									}
								});
						
						
						$("#tape")
						.on(
								"change",
								function() {
									var value = $(this).val();
									//for (var i = 0, len = value.length; i < len; ++i) {
									if (value != "") {
										var result = value % 3;
										if (result != 0) {
											$(this).addClass("error3");
											/*noty({
												text : "Minimum quantity of security stickers should be 40 or multiple of 40",
												type : "error",
												layout : "topRight"
											});*/
											alert("Minimum quantity of tapes should be 3 or multiple of 3");
										} else {
											$(this).removeClass(
													"error3");
										}
									} else {
										$(this).removeClass("error3");
									}
								});
						
						$(".common").keydown(function (e) {
							
					        // Allow: backspace, delete, tab, escape, enter and .
					        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110 ]) !== -1 ||
					             // Allow: Ctrl+A
					            (e.keyCode == 65 && e.ctrlKey === true) || 
					             // Allow: home, end, left, right, down, up
					            (e.keyCode >= 35 && e.keyCode <= 40)) {
					                 // let it happen, don't do anything
					                 return;
					        }
					        // Ensure that it is a number and stop the keypress
					        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105))
					        {
					            e.preventDefault();
					        }
					    });
						$('#daterange').daterangepicker({
							format : "DD/MM/YYYY"
						});
						
						$( "#saveForm" ).click(function() {
							  $( "#form" ).submit();
							});

					});
</script>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header pull-right">
			<b> Welcome ${seller_name} &nbsp;&nbsp; </b>
		</div>
		<marquee id="flag">
			<font color="red">${flag}</font>
		</marquee>
	</div>
	</nav>
	<div id="content" class="col-sm-12 full">
		<%-- <div class="panel panel-primary">
		<div class="panel-heading">
			<h2 align="right" class="panel-title"> Welcome !  ${seller_name} </h2>
		</div> --%>

		<%-- <div class="col-lg-10">
				<h2 align="right" style="margin-top: 0px">Welcome</h2>
			</div>
			<div class="col-lg-2">
				<label align="right" style="margin-top: 0px">${seller_name}</label>
			</div> --%>

		<!-- <div class="panel-body"> -->

		<center>
			<form id="form" method="post" action="/PackagingMaterialTracker/save"
				name="SellerRequest">
				<input type="hidden" name="seller_name" value="${seller_name}">
				<input type="hidden" name="seller_email" value="${seller_email}">
				<input type="hidden" name="seller_mobile" value="${seller_mobile}">
				<input type="hidden" name="seller_address" value="${seller_address}">
				<input type="hidden" name="seller_city" value="${seller_city}">
				<input type="hidden" name="seller_state" value="${seller_state}">
				<input type="hidden" name="seller_pincode" value="${seller_pincode}">
				<input type="hidden" name="id" value="${id}" />
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h2 align="center" class="panel-title">Packaging Material
							Request</h2>
					</div>
					<div class="row" id="divCreate">
						<div class="col-lg-12 hidden" style="Margin-Top: 20px">
							<label>Seller Code</label><input type="text" name="SellerCode"
								value="${sellerCode}" class="form-control">
						</div>
						<div class="col-lg-12" style="Margin-Top: 20px">
							<div class="col-lg-4 data">
								<label>${label1} ( ₹ ${price1} )</label> <input type="text"
									name="para1" id="para1" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para1}"
									title="Minimum quantity of bags should be 100 or multiple of 100">
									 <input type="text"
									name="price1" id="price1" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price1}"> 
							</div>
							<div class="col-lg-4 data">
								<label>${label2} ( ₹ ${price2} )</label> <input type="text" name="para2"
									id="para2" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para2}"
									title="Minimum quantity of bags should be 100 or multiple of 100">
									<input type="text"
									name="price2" id="price2" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price2}"> 
							</div>
							<%-- <div class="col-lg-4 data">
								<label>${label3}</label> <input type="text" name="para3"
									id="para3" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para3}"
									title="Minimum quantity of bags should be 50 or multiple of 50"">
									<input type="text"
									name="price3" id="price3" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price3}">
							</div> --%>
							
							<div class="col-lg-4 data">
								<label>${label3} ( ₹ ${price3} ) </label> <input type="text" name="para4"
									id="para4" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para4}"
									title="Minimum quantity of bags should be 100 or multiple of 100">
									<input type="text"
									name="price4" id="price4" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price3}"> 
							</div>
							
						</div>
						<div class="col-lg-12" style="Margin-Top: 20px">
							
							<div class="col-lg-4 data">
								<label>${label4} ( ₹ ${price4} )</label> <input type="text" name="para5"
									id="para5" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para5}"
									title="Minimum quantity of bags should be 100 or multiple of 100"">
									 <input type="text"
									name="price5" id="price5" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price4}"> 
							</div>
							<div class="col-lg-4 data">
								<label>${label5} ( ₹ ${price5} )</label> <input type="text" name="para6"
									id="para6" class="form-control para digits common"
									maxlength="5" data-rel="tooltip" value="${para6}"
									title="Minimum quantity of bags should be 100 or multiple of 100">
									 <input type="text"
									name="price6" id="price6" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price5}"> 
								</div>
								<div class="col-lg-4 data">
									<label>${label6} ( ₹ ${price6} )</label> <input type="text"
										name="para7" id="para7"
										class="form-control para digits common" maxlength="5"
										data-rel="tooltip" value="${para7}"
										title="Minimum quantity of bags should be 100 or multiple of 100">
									 	<input type="text"
									name="price7" id="price7" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price6}">
 								</div>
																		
									
									
							</div>
							
							<div class="col-lg-12" style="Margin-Top: 20px">
								
								<div class="col-lg-4 data">
									<label>${label9} ( ₹ ${price9} )</label>
									
									<input type="text" name="Para10" id="para10" value="${para10}"
										class="form-control para digits common" maxlength="5"
										style="margin-bottom: 30px">
										 <input type="text"
									name="price10" id="price10" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price9}">
 								</div>
 								
 								<div class="col-lg-4 data">
									<label>${label10} ( ₹ ${price10} )</label>
									
	 								<input type="text" name="Para11" id="para11"
										value="${para11}" class="form-control para digits common"
										maxlength="5" style="margin-bottom: 30px">
									<input type="text"
									name="price11" id="price11" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price10}">
 								</div>
								
								<div class="col-lg-4 data">
									<label>${label7} ( ₹ ${price7} )</label>
									<div class="col-lg-1">
										<a class="btn btn-primary"
											style="margin-left: 250px; height: 25px" data-rel="tooltip"
											title="There is no requirement of putting Snapdeal Tapes on snapdeal poly bags. SD tapes can only be used if the product can not be accomodated in Snapdeal poly bags e.g. large shipments etc.. Seller has to raise separate requisition for Snapdeal Tape requirement.">?</a>
									</div>
									<input type="text" name="Para8" id="tape" value="${para8}"
										class="form-control digits common" maxlength="5"
										style="margin-bottom: 30px">
										 <input type="text"
									name="price8" id="price8" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price7}">
 								</div>
							</div>
							<div class="col-lg-12" style="Margin-Top: 20px">
								<div class="col-lg-4 data">
									<label>${label8} ( ₹ ${price8} )</label>
									<div class="col-lg-1">
										<a class="btn btn-primary"
											style="margin-left: 300px; height: 25px" data-rel="tooltip"
											title="Only for mentioned sub categories : Mobile, Laptops, Tablets, Watches">?</a>
									</div>
	 								<input type="text" name="Para9" id="securitySticker"
										value="${para9}" class="form-control digits common"
										maxlength="5" style="margin-bottom: 30px">
									<input type="text"
									name="price9" id="price9" class="form-control hidden"
									maxlength="5" data-rel="tooltip" value="${price8}">
 								</div>
 							</div>
							<!-- <div class="col-lg-12"
											style="text-align: center; margin-top: 30px">
											<input type="submit" value="Save" class="btn btn-primary">
											<br />
										</div> -->
							<div class="col-lg-12" style="text-align: center;">
								<button class="btn btn-primary common"
									onclick="return formValidate();">save</button>
							</div>
						</div>
					</div>

				</div>
			</form>
		</center>
		<p style="color: red;">
			Notes: -<br />
		</p>
		<p>
			1. Minimum Quantity of Bags should be 100 or Multiple of 100 for each
			size.<br /> 2. Please fill this form every time whenever you
			required packing material in 3-4 days (For Delhi/NCR) and 7-10 days
			(For other city) in advance.<br /> 3. There is no requirement of
			putting Snapdeal Tapes on snapdeal poly bags. SD tapes can only be
			used if the product can not be accomodated in Snapdeal poly bags e.g.
			large shipments etc.. Seller has to raise separate requisition for
			Snapdeal Tape requirement. <br /> 4. Security Stickers are only for
			mentioned sub categories : Mobile, Laptops, Tablets, Watches. <br />5
			. Any request received before 5 PM will dispatch the same business
			day; request received after 5 PM will be considered for next business
			day dispatch.
		</p>
		<!-- </div> -->
		<form action="/PackagingMaterialTracker/Retrieve" method="Post"
			name="Retrieve">
			<div class="col-lg-12 hidden" style="Margin-Top: 20px">
				<label>Seller Code</label><input type="text" name="SellerCode"
					value="${sellerCode}" class="form-control"> <input
					type="hidden" name="seller_name" value="${seller_name}"> <input
					type="text" name="seller_email" value="${seller_email}"
					class="form-control hidden "> <input type="text"
					name="seller_mobile" value="${seller_mobile}"
					class="form-control hidden "> <input type="hidden"
					name="seller_address" value="${seller_address}"> <input
					type="hidden" name="seller_city" value="${seller_city}"> <input
					type="hidden" name="seller_state" value="${seller_state}">
				<input type="hidden" name="seller_pincode" value="${seller_pincode}">
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h2 align="center" class="panel-title">Previous Requests</h2>
				</div>
				<div class="panel-body">

					<div class="col-lg-12">
						<div class="col-lg-1">
							<label>Date Range</label>
						</div>
						<div class="col-lg-3">
							<fieldset>
								<div class="control-group">
									<div class="controls ">
										<div class="input-prepend input-group">
											<span class="add-on input-group-addon"> <i
												class="glyphicon glyphicon-calendar fa fa-calendar "></i> </span> 
												<input class="form-control "
												type="text" style="width: 200px" name="Reservation" value="${Retrieve}"
												id="daterange" required>
										</div>

									</div>
								</div>
							</fieldset>
						</div>
						
						<div class="col-lg-1" style="margin-top: 12px">
							<label>Status</label>
						</div> 
						<div class="col-lg-2">
							<select  required class ="dropdown required form-control" name="status">
								
								<option value="">-----Select-----</option>
								<option value="ALL">-----ALL-----</option>
								<option value="Request Created">Request Created</option>
								<option value="Request Processing">Request Processing</option>
								<option value="Request Rejected">Request Rejected</option>
								<option value="Dispatched">Dispatched</option>
								<option value="Delayed">Delayed</option>
								<option value="Delivered">Delivered</option>
								<option value="RTO">RTO</option>
							</select>
						</div>
						<div class="col-lg-1">
							<input type="submit" value="submit" class="btn btn-primary">
						</div>
					</div>

					<div class="col-lg-12" style="margin-top: 40px">
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th class="hide">test</th>
									<th>Request No.</th>
									<th>Action</th>
									<th>Request Status</th>
									<th>Courier</th>
									<th>AWB</th>
									<th>Comment</th>
									<th>Action</th>
									<th>Created on</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="SellerRequest1" items="${requestList}">
									<tr>
										<td class="hide">${SellerRequest1.id}</td>
										<td>${SellerRequest1.sellerCode}/${SellerRequest1.created}/${SellerRequest1.id}</td>
										<td align="center"><c:if
												test="${SellerRequest1.requeststatus == 'Request Created'}">
												<a
													href="/PackagingMaterialTracker/Delete?id=${SellerRequest1.id}"
													class="btn btn-danger btn-sm"
													style="text-align: center; white-space; width: 50px;">Delete</a>
												<a
													href="/PackagingMaterialTracker/Edit?id=${SellerRequest1.id}"
													class="btn btn-primary btn-sm"
													style="text-align: center; white-space; width: 50px;">Edit</a>
											</c:if>
										</td>
										<td>${SellerRequest1.requeststatus}</td>
										<td>${SellerRequest1.courier}</td>
										<td>${SellerRequest1.AWB}</td>
										<td>${SellerRequest1.comment}</td>
										<td><a
											href="/PackagingMaterialTracker/showParameter?id=${SellerRequest1.id}"
											target="_blank">Show Details</a></td>
										<td>${SellerRequest1.created}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>

	</div>

	<div class="row">
		<div class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">

						<div style="margin-top: 10px; margin-left: 10px">You have
							requested for:</div>
						<table border="1"
							style="border: 1px solid black; border-collapse: collapse; margin-bottom: 30px; width: 50%"
							align="center" id="modalTable">
						</table>
					</div>
					<div class="modal-footer">

						<button type="button" id="saveForm" class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hide">
		<table>
			<tr id="dummyRow">
				<td class="dataLabel" align="left"></td>
				<td class="dataValue" align="left"><input type="hidden"
					class="hiddenValue" /></td>
				<td class="dataPrice" align="left"></td>	
				
			</tr>
		</table>

	</div>
</body>
</html>