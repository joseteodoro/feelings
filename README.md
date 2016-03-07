How are people feeling and talking about some subject?

This web application get information from social media (like Twitter) to
evaluate the emotion inside the messages.

It uses Watson Alchemy Sentiment Analysis API to evaluate the sentiments
from a set of messages got from Twitter.  After that, the Twitter message
set is  evaluated by Relationship Extraction and the terms are ranked by
word frequency count.

Requirement's:
Maven 3.3.x;
JDK 8;
Tested browsers: Firefox and Google Chrome.
Tested application servers: jetty and tomcat.

Before deploy:
The application uses system properties to configure Twitter, Watson and Bluemix.

Properies for Twitter (you can get this on Twitter developer's website):
-Dtwitter4j.oauth.consumerKey=*********************
-Dtwitter4j.oauth.consumerSecret=*********************
-Dtwitter4j.oauth.accessToken=*********************
-Dtwitter4j.oauth.accessTokenSecret=*********************

To create these credentials visit https://apps.twitter.com/, create your application and authorize
it on your Twitter profile.

Properies for Alchemy and Sentiment Analysis (you can get this on Watson Alchemy website):
-Dwatson.alchemy.api.key=*********************

Add instances for this service on your Bluemix account before run the application.

Properies for Relationship Extraction (you can get this on Watson Relationship Extraction website):
-Dwatson.relation.extraction.user=*********************
-Dwatson.relation.extraction.pass=*********************
-Dwatson.relation.extraction.service=https://gateway.watsonplatform.net/relationship-extraction-beta/api/v1/sire/0

Add instances for this service on your Bluemix account before run the application.

To test if your credentials and remote service instances are working:
There are three artifacts to test your connections inside the package br.ime.usp.feelings.retriever.connection.
- TwitterSearcherTest.java
- WatsonRestAlchemyEmotionClientTest.java
- WatsonRestRelationExtractionClientTest.java
You can use this to test if your credentials are valid and running.

You need to link Relationship Extraction and Alchemy and Sentiment Analysis services with your application before
deploy and run inside Liberty for Java. You can use maven to build and deploy the application or configure the
Liberty for Java to deploy it. Remember to set the ENV to use jdk 1.8+.

Make, deploy and run:
make using mvn package;
deploy inside an application server;
To run, just go to the root application page.