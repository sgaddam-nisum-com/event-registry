<html>
<body>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var url = 'http://localhost:8080/event-registry/event/registry/savePage';
			// process the form
			$('form').submit(function(event) {
				// get the form data
				// there are many ways to get this data using jQuery (you can use the class or id also)
				var formData = {
					'username' : $('input[name=username]').val(),
					'name' : $('input[name=name]').val(),
					'source' : $('#sample').html()
				};
				// process the form
				$.ajax({
					type : 'POST', // define the type of HTTP verb we want to use (POST for our form)
					url : url, // the url where we want to POST
					data : formData, // our data object
					dataType : 'json', // what type of data do we expect back from the server
					encode : true,
					success : function(msg) {//On Successfull service call   
						//console.log(msg);
					},
					error : function(xhr) {
						//console.log(xhr.responseText);
					} // When Service call fails             
				})
				// using the done promise callback
				.done(function(data) {
					// log data to the console so we can see
					console.log(data);
	
					// here we will handle errors and validation messages
				});
	
				// stop the form from submitting the normal way and refreshing the page
				event.preventDefault();
			});
	
		});
	</script>
	<h2>Event Registry Start Up!</h2>
	<p>
		<a href="event/registry/getPages">read</a>
	<p>
		<a href="event/registry/getPageByName?name=header">read by name header</a>
	<form name="pages" method="get">
		<div id="results"></div>
		<table>
			<tr>
				<th colspan="2">Save Data</th>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" id="username"
					value="sgaddam" disabled="disabled"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name" value="header">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Submit</button></td>
			</tr>
		</table>
	</form>

	<div id="sample">
		<table style="min-width: 100px;display: none;">
			<tr>
				<th>name</th>
				<th>rank</th>
			</tr>
			<tr>
				<td>sandy</td>
				<td>1</td>
			</tr>
		</table>


	</div>

</body>
</html>
