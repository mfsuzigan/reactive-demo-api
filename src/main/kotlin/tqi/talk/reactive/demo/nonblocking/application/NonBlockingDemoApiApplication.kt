package tqi.talk.reactive.demo.nonblocking.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("tqi.talk.reactive.demo.nonblocking.controller", "tqi.talk.reactive.demo.nonblocking.service")
class NonBlockingDemoApiApplication

fun main(args: Array<String>) {
    runApplication<NonBlockingDemoApiApplication>(*args)
}
