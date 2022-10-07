package salguod.com.br.routes.test

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


fun Application.configureTest(){

    configureTables()

   routing {
       get("/test") {
           val tests = transaction {
               TestEntity.all().map {
                   Test(
                       id = it.id.value,
                       name = it.name
                   )
               }
           }
           call.respond(tests)

//           call.respond(status = HttpStatusCode.NotFound, "Não encontramos")


       }

       post("/test") {
           val testBody = call.receive<Test>()

           val newTest = transaction {
               TestEntity.new {
                   name = testBody.name
               }.toDomain()
           }

           call.respond(newTest)

       }
   }
}

fun configureTables() {
    transaction {
        SchemaUtils.create(
            Testes
        )
    }
}
