# Horus.scala

## About the name
Horus is the codename of [Akamon](http://www.akamon.com) 's core PHP project (my last job). It's strongly inspired in DDD concepts and separation of concerns. I've tried to copy some of concepts used there in this repo. 
 

## Motivation
In my opinion there is a lack of documentation and full examples on how to get a Play 2.5 application running with Guice and Slick3 running and how to test it correctly (IMHO).
For this, I've created this repo with all stuff I've learned with blood and tears in last months. I'm pretty noob with all this tools, so feel free to do some Pull Requests!

## Summary
This App is a simple "users microservice" which you can create users and store it in MySql database. There isn't too much functionality but what's important with this repo is infrastucture and testing.

## Installation
Only need to create a database, import schema located on `doc/database.sql` and set up parameters in `conf/application.conf`

## Testing
I've used [Scalatest](http://www.scalatest.org) and [Scalamock](http://scalamock.org) in this project and I've defined 3 levels of testing:

### Behaviour
Commonly named unit tests. Mocking infrastructure without HTTP stack.

### Persistence
Testing repositories against database in isolation. Before each test we are truncating the database with `EnvironmentArranger`

### Acceptance
Testing a running application with a HTTP client checking the responses.

## To improve
* parallelize tests which use database
* use akka event stream as command bus and query bus
* domain events
* check responses in acceptance tests in addition of HTTP status codes


# Thanks
 To Akamon's team [Jordi Llonch](https://github.com/jordillonch) , [Eloi Poch](https://github.com/eloipoch), [Joan Valduvieco](https://github.com/jvalduvieco) [Pablo Diez](https://github.com/pablodip), [Jesus Diez](https://github.com/jesusdiez), [Rafael Gomez](https://github.com/rgomezcasas) and another [basque guy](https://github.com/jorgeavilacardenosa) who works there. Without their help I couldn't learn all this stuff.

 
