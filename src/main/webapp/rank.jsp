<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="css/jqcloud.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jqcloud-1.0.0.min.js"></script>
<script type="text/javascript">
      var word_list = new Array(
  		<c:forEach items="${ranks}" var="rank">
  			{text: "${rank.label}", weight: ${rank.rank}},
   		</c:forEach>
        {text: "", weight: 1}
      );
      $(document).ready(function() {
        $("#wordcloud").jQCloud(word_list);
      });
</script>
<style type="text/css">
.top-margin-25 {
	margin-top: 25px;
}
      body {
        background: #eee;
        font-family: Helvetica, Arial, sans-serif;
      }
      #wordcloud {
        margin: 30px auto;
        width: 600px;
        height: 371px;
        border: none;
      }
      #wordcloud span.w10, #wordcloud span.w9, #wordcloud span.w8, #wordcloud span.w7 {
        text-shadow: 0px 1px 1px #ccc;
      }
      #wordcloud span.w3, #wordcloud span.w2, #wordcloud span.w1 {
        text-shadow: 0px 1px 1px #fff;
      }
      #footer {
        font-size: 13px;
        color: #aaa;
        text-align: center;
        width: 600px;
        margin: 30px auto;
        padding: 0.5em;
        text-shadow: 0px 1px 1px #fff;
        border-top: 1px dotted #ddd;
      }
      #footer a {
        color: #0af;
        text-decoration: none;
      }
</style>
</head>
<body>
	<div class="col-md-12">
		<div class="row">
			<div style="width: 800px; height: 371px;" class="jqcloud" id="wordcloud"></div>
		</div>
		<div class="row">
			<h3 class="text-center">Big words are more important!</h3>
		</div>
	</div>
</body>
</html>
