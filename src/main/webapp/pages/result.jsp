<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/datatables.css" />
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/datatables.js"></script>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1 style="color:blue;background:green;">Elenco Telefonico</h1>
	<h2>Risultato</h2>

	<table id="datatable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Telefono</th>
				<th>Validit&agrave;</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listaTel"  status="status">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="smsPhone" /></td>
					<td><s:property value="risultato" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datatable').DataTable({
				"scrollY" : "200px",
				"scrollCollapse" : true,
				"paging" : true
			});
		});
	</script>

</body>
</html>