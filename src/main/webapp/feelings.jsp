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
.anger {
	width: ${requestScope.Anger.scaleToShow()}%;
	height:auto;
}
.sadness {
	width: ${requestScope.Sadness.scaleToShow()}%;
	height:auto;
}
.joy {
	width: ${requestScope.Joy.scaleToShow()}%;
	height:auto;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row pushDown">
			<div class="col-md-12">
				<div class="col-md-4 text-center"></div>
				<div class="col-md-4 text-center">
					<div class="row text-center">
						<div class="col-md-4 text-center">
							<img class="anger" src="images/emoticon_anger.png" alt="anger" /><br /><br />
							<span class="label label-danger">Anger</span>
						</div>
						<div class="col-md-4 text-center">
							<img class="sadness" src="images/emoticon_sad.png" alt="sadness" /><br /><br />
							<span class="label label-warning">Sadness</span>
						</div>
						<div class="col-md-4 text-center">
							<img class="joy" src="images/emoticon_joy.png" alt="joy" /><br /><br />
							<span class="label label-success">Joy</span>
						</div>
					</div>
				</div>
				<div class="col-md-4 text-center"></div>
			</div>
		</div>
	</div>
</body>
</html>
