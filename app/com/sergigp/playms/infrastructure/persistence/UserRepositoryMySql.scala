package com.sergigp.playms.infrastructure.persistence

import java.util.UUID
import javax.inject.Inject

import scala.concurrent.Future

import play.api.db.slick.DatabaseConfigProvider

import com.sergigp.playms.domain.model.{User, UserId, UserName, UserRepository}
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import slick.lifted.{ProvenShape, TableQuery, Tag}

trait ColumnMappings {
  implicit val userIdColumnType = MappedColumnType.base[UserId, String](
    userId => userId.value.toString,
    id => UserId(UUID.fromString(id))
  )

  implicit val userNameColumnType = MappedColumnType.base[UserName, String](
    userName => userName.value,
    name => UserName(name)
  )
}

class UsersTable(tag: Tag) extends Table[User](tag, "users") with ColumnMappings {

  def id: Rep[UserId] = column[UserId]("user_id")

  def name: Rep[UserName] = column[UserName]("name")

  override def * : ProvenShape[User] = (id, name) <>(User.tupled, User.unapply)
}

class UserRepositoryMySql @Inject()(dbConfigProvider: DatabaseConfigProvider)
  extends UserRepository with ColumnMappings {

  val dbConfig = dbConfigProvider.get[JdbcProfile]
  val users    = TableQuery[UsersTable]

  def find(userId: UserId): Future[Option[User]] = {
    dbConfig.db.run(users.filter(a => a.id === userId).result.headOption)
  }

  def create(user: User): Future[Int] = {
    dbConfig.db.run(users += user)
  }

  def findByName(name: UserName): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.name === name).result.headOption)
  }
}
