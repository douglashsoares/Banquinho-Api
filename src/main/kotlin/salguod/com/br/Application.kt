package salguod.com.br

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import salguod.com.br.db.configureDatabase
import salguod.com.br.plugins.*
import salguod.com.br.routes.test.configureTest

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
        configureDatabase()
        configureTest()

    }.start(wait = true)
}
