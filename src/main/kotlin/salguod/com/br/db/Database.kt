package salguod.com.br.db

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager

fun Application.configureDatabase(){
    val db = Database.connect("jdbc:mysql://127.0.0.1:3306/banquinho_schema", driver = "com.mysql.cj.jdbc.Driver",
        user = "salguod", password = "789789")

    TransactionManager.defaultDatabase = db
}