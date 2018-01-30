<html>
<head>
  <title>Ticket</title>
</head>
<body>

<%@include file="../helpers/ticket.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.8.0/dist/JsBarcode.all.min.js"></script>
<script>
  JsBarcode(".barcode").init();
</script>

</body>
</html>