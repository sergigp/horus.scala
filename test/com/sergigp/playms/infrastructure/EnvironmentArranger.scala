package com.sergigp.playms.infrastructure

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

import play.api.db.slick.DatabaseConfigProvider
import play.api.inject.Injector

import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import slick.jdbc.SQLActionBuilder
import slick.jdbc.SetParameter.SetUnit

object EnvironmentArranger {
  def cleanDatabase(injector: Injector): Unit = {
    val dbConfig = injector.instanceOf[DatabaseConfigProvider].get[JdbcProfile]
    val truncatesFuture = dbConfig.db.run(
      sql"""show full tables where Table_Type = "BASE TABLE"""".as[(String, String)]
    ).map {
      _.map { case (tableName, _) => SQLActionBuilder(List(s"TRUNCATE TABLE $tableName"), SetUnit).asUpdate }
    }

    Await.result(truncatesFuture.flatMap(
      truncates =>
        dbConfig.db.run(
          DBIO.sequence(
            List(
              List( sqlu"""SET FOREIGN_KEY_CHECKS = 0;"""),
              truncates,
              List( sqlu"""SET FOREIGN_KEY_CHECKS = 1;""")
            ).flatten
          )
        )
    ), 5.seconds)
  }
}
