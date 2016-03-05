<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style type="text/css">
.pushDown {
	margin-top: 20%;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row pushDown">
			<div class="col-md-4"></div>
			<div class="form-group has-success">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<span id="helpBlock2" class="help-block text-center">How
								does people feel about?</span>
						</div>
					</div>
					<form role="form" action="/feelingsSeach">
						<div class="row">
							<div class="col-md-10">
								<input class="form-control" placeholder="Type a subject here"
									id="subject" type="text" />
							</div>
							<div class="col-md-2">
								<button type="submit" class="btn btn-success">?</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

</body>
</html>
