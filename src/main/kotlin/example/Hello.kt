package example

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(
            Netty,
            watchPaths = listOf("kotlin-ktor-auto-reload-in-idea-demo"),
            port = 8080,
            module = Application::routes
    ).apply {
        start(wait = true)
    }
}

fun Application.routes() {
    routing {
        get("/") {
            call.respondText("Hello World! <change me for testing!>")
        }
    }
}