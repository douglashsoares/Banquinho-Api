package salguod.com.br.routes.test

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

data class Test(
    val id: Int?,
    val name: String
)

object Testes: IntIdTable(){

    val name : Column<String> = varchar("name",255)
}

class TestEntity (id:EntityID<Int>): IntEntity(id){

    companion object: IntEntityClass<TestEntity>(Testes)

    var name by Testes.name

}

fun TestEntity.toDomain(): Test {

    return Test(
        id = id.value,
        name = name
    )
}