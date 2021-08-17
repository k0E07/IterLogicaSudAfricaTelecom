<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<s:head />
</head>

<body>
	<h1 style="color:blue;background:green;">Elenco Telefonico</h1>
	<s:form
		action="uploadAction"
		namespace="/"
		method="POST"
		enctype="multipart/form-data">
		<s:file name="fileUpload" label="Seleziona un file" />
		<s:submit method="execute" label="Invia" value="Invia" />
	</s:form>
</body>
</html>