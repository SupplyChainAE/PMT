<jsp:include page="/framework-resouce.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Packaging Material Request</title>

<script type="text/javascript">
	$(document).ready(function() {
		if ($("#message").val() != "") {
			alert("#message").val()");
		}
		$("#form").validate();

	});
	/* function geturl() {
		var sellercode = $('#seller').val();
		$("#form").attr("action",
				"/PackagingMaterialTracker/CreateRequest/" + sellercode);
	} */
</script>

</head>
<body>
	<div id="content" class="col-sm-12 full">
		<!--  -->
		<!--  -->
<input type="hidden" id="message" value="${message}" />
		
				<div class="panel panel-primary" style="margin-top: 20px;">
				<div class="panel-heading">
					<h2 align="center" class="panel-title">Packaging Material Request</h2>
				</div>
				<div class="panel-body">
						
						<center>
							<form id="form" method="post"
								action="/PackagingMaterialTracker/checkSeller">
								<div class="row">
									<div class="col-lg-12" style="Margin-Top: 20px">
										<div class="col-lg-2">
											<label>Seller Code</label>
										</div>
										<div class="col-lg-5">
											<input type="text" name="sellercode" id="seller"
												class="form-control required para ">
										</div>
										<div class="col-lg-5" style="text-align: left;">
											<input type="submit" id="sb" value="Submit"
												onclick="geturl()" class="btn btn-primary">
										</div>

									</div>
								</div>
							</form>
						</center>
						<br /> <br />
						<p>
							<b>*</b> If you don't have Seller Code .Please login to Seller
							Panel <a href="http://shipping.snapdeal.com"><font color="blue">shipping.snapdeal.com</font></a>
							For any queries please email to <a
								href="mailto:sellershelp@snapdeal.com"><font color="blue">sellershelp@snapdeal.com</font></a>
							or contact on 011-66610222
						</p>
					</div>
				</div>
				<p style="color: red;">
					Notes: -<br />
				</p>
				<p>
					1.
					Minimum Quantity of Bags should be 50 or Multiple of 50 for each
					size.<br /> 2. Please fill this form every time whenever you
					required packing material in 3-4 days (For Delhi/NCR) and 7-10 days
					(For other city) in advance.<br /> 3. There is no requirement of putting Snapdeal Tapes on snapdeal poly bags. SD tapes can only be used if the product can not be accomodated in Snapdeal poly bags e.g. large shipments etc.. Seller has to raise separate requisition for Snapdeal Tape requirement.
					<br />4. Security Stickers are only for mentioned sub categories : Mobile, Laptops, Tablets, Watches.
					<br />5 . Any request received before 5 PM will dispatch the same business day; request received after 5 PM will be considered for next business day dispatch. 
				</p>
			</div>
	
</body>
</html>