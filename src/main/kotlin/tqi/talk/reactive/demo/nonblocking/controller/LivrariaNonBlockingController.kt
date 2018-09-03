package tqi.talk.reactive.demo.nonblocking.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tqi.talk.reactive.demo.nonblocking.model.Compra
import tqi.talk.reactive.demo.nonblocking.model.Livro
import tqi.talk.reactive.demo.nonblocking.model.Login
import tqi.talk.reactive.demo.nonblocking.service.LivrariaService

@RestController
@RequestMapping("/livraria")
class LivrariaNonBlockingController(private val service: LivrariaService) {

    @PostMapping("/login")
    fun login(): Mono<Login> {
        return service.login()
    }

    @GetMapping("/livros")
    fun recuperarLivros(): Flux<Livro> {
        return service.recuperarLivros()
    }

    @PostMapping("/compras/livros/{id}")
    fun comprar(): Mono<Compra> {
        return service.comprar()
    }
}