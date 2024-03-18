package hverdag

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.http4k.core.ContentType.Companion.TEXT_HTML
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.with
import org.http4k.lens.Header
import org.http4k.routing.*
import org.http4k.server.SunHttp
import org.http4k.server.asServer

fun main() {

    val app = routes(
        static(ResourceLoader.Classpath("/META-INF/resources/webjars/github-com-mblode-marx/4.0.0")),
        htmxWebjars(),
        "/" bind GET to {
            response()
        }

    )

    app.asServer(SunHttp(9000)).start()

    System.err.println("htmx server started at http://localhost:9000")
}

private fun response() = htmlPage {
    head {
        script {
            type = "text/javascript"
            src = "/htmx.min.js"
        }
        script {
            type = "text/javascript"
            src = "/_hyperscript.min.js"
        }
        link {
            rel = "stylesheet"
            href = "/marx.css"
        }
        title {
            +"Banos"
        }
    }
    body {
        main {
            article {
                h1 { +"Hello World!" }
            }
        }
    }
}

fun htmlPage(status: Status = Status.OK, block: HTML.() -> Unit): Response {
    val text = buildString {
        append("<!DOCTYPE html>\n")
        appendHTML().html(block = block)
    }
    return Response(status)
        .with(Header.CONTENT_TYPE of TEXT_HTML)
        .body(text)
}