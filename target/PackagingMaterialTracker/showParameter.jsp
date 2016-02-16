<jsp:include page="/framework-resouce.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page isELIgnored="false"%>
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
<html>
<head>
</head>
<body>
	<div class="col-md-6 col-md-offset-3" style="margin-top: 20px" >
		<div class="panel panel-primary">
			<div class="panel-heading" align="center">
				<h3 class="panel-title" >Parameter Details of Request id - ${requestID}</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
					<thead>
						<tr>
							<th>Sr no.</th>
							<th>Parameter</th>
							<th>Quantity </th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>6.5" * 6.5"</td>
							<td>${para1}</td>
						</tr>
						
						<tr>
							<td>2</td>
							<td>8.5" * 11.5"</td>
							<td>${para2}</td>
						</tr>
						<tr>
							<td>3</td>
							<td>11.5" * 13.5"</td>
							<td>${para4}</td>
						</tr>
						<tr>
							<td>4</td>
							<td>13.5" * 16"</td>
							<td>${para5}</td>
						</tr>
						<tr>
							<td>5</td>
							<td>15.5" * 18"</td>
							<td>${para6}</td>
						</tr>
						<tr>
							<td>6</td>
							<td>17.5" * 19"</td>
							<td>${para10}</td>
						</tr>
						<tr>
							<td>7</td>
							<td>20" * 22.5"</td>
							<td>${para11	}</td>
						</tr>
						<tr>
							<td>8</td>
							<td>22.5" * 24.5"</td>
							<td>${para7}</td>
						</tr>
						
						<tr>
							<td>9</td>
							<td>Tape</td>
							<td>${para8}</td>
						</tr>
						<tr>
							<td>10</td>
							<td>Security Sticker</td>
							<td>${para9}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>