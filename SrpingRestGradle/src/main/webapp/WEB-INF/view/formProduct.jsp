<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Spring MVC - Ajax</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
body {
	background-color: #eee;
	font: helvetica;
}

#container {
	width: 600px;
	background-color: #fff;
	margin: 30px auto;
	padding: 30px;
	border-radius: 5px;
	box-shadow: 5px;
}

.green {
	font-weight: bold;
	color: maroon;
}

.message {
	margin-bottom: 10px;
}

label {
	width: 70px;
	display: inline-block;
}

.hide {
	display: none;
}

.error {
	color: red;
	font-size: 0.8em;
}
</style>
</head>
<body>

	<div id="container">

		<h1>Product Page</h1>



		<h2>Get By ID</h2>
		<form id="idForm">
			<div class="error hide" id="idError">Please enter a valid ID in
				range 0-100000</div>
			<label for="productId">ID (0-100000): </label><input name="id"
				id="productId" value="0" type="number" /> <input type="submit"
				value="Get Product By ID" /> <br />
			<br />
			<div id="productIdResponse"></div>
		</form>

		<hr />

		<h2>Submit new Product</h2>
		<form id="newProductForm">
			<table>
				<tr>
					<td><label for="descriptionInput">Description: </label></td>
					<td><input type="text" name="description" id="nameInput" /></td>
					<br />
				</tr>
				<tr>
					<td><label for="priceInput">Price: </label></td>
					<td><input type="text" name=price id="priceInput" /></td>
				</tr>
				<br />
				<tr>
					<td><input type="submit" value="Save Product" /><br /> <br /></td>
				</tr>
			</table>
			<div id="productFormResponse" class="green"></div>
		</form>

	</div>


	<script type="text/javascript">
	
		$(document).ready(function() {
			
			
			
			// Request Product by ID AJAX
			$('#idForm').submit(function(e) {
				var productId = +$('#productId').val();
				if(!validateProductId(productId)) 
					return false;
				$.get('${pageContext.request.contextPath}/products/product/' + productId, function(product) {
					$('#productIdResponse').text(' Product ID : ' +product.id + ', Description : ' + product.description+ ', Price : '+product.price);
				});
				e.preventDefault(); // prevent actual form submit
			});
			
		
			
			$('#newProductForm').submit(function(e) {
				// will pass the form date using the jQuery serialize function
				$.post('${pageContext.request.contextPath}/products/product', $(this).serialize(), function(response) {
					$('#productFormResponse').text(response);
				});
				
				e.preventDefault(); // prevent actual form submit and page reload
			});
			
		});
		
		function validateProductId(productId) {
			console.log(productId);
			if(productId === undefined || productId < 0 || productId > 100000) {
				$('#idError').show();
				return false;
			}
			else {
				$('#idError').hide();
				return true;
			}
		}
		
	
	</script>

</body>
</html>