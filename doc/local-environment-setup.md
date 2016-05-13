# Local Environment Setup

## Global procedure
* Install SBT:
    * `curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo`
    * `yum install sbt`
* Install Git: `yum install git`
* Clone this repo: `git clone https://github.com/letgoapp/pusher.git .`
* Run SBT: `sbt`

## SBT
The very first thing you should want to do is to install the Scala Build Tools.
This is the tool used to compile, run, and test our application :)
In order to do so, you just need to follow [the described procedure based on your OS](http://www.scala-sbt.org/download.html).
Once you install SBT, run `sbt sbtVersion` in order to resolve all the dependencies and check which version do you have.

## Git hooks
First of all, you'll need to setup the git hooks from your local environment.
In order to do that, just adapt and execute the following commands from the host machine:
* `cd ~/your/pusher/repository/path`
* `rm -rf .git/hooks`
* `ln -s ../doc/hooks .git/hooks`
* `sudo chmod -R 777 doc/hooks/*`

## Scala Build Tools (SBT)
* Once you are in the SBT console. Launch tests with `test`
* You can also execute the test from outside the SBT console with: `sbt test`

## Errors log
* You can check the scala Chat application errors with the command:
  * `tail -f /var/log/pusher/pusher-app.log`
