package tqi.talk.reactive.demo.nonblocking.service

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import tqi.talk.reactive.demo.nonblocking.model.Compra
import tqi.talk.reactive.demo.nonblocking.model.Livro
import tqi.talk.reactive.demo.nonblocking.model.Login
import tqi.talk.reactive.demo.nonblocking.model.Usuario
import java.time.Duration

@Component
class LivrariaService {

    fun login(): Mono<Login> = esperar(1000).flatMap { Login(Usuario.exemplo()).toMono() }

    fun recuperarUsuario(): Mono<Usuario> = esperar(200).flatMap { Usuario.exemplo().toMono() }

    fun recuperarLivro(): Mono<Livro> = esperar(200).flatMap { Livro.exemplo().toMono() }

    fun recuperarLivros(): Flux<Livro> = esperar(200).flatMapMany { Livro.exemplos().toFlux() }

    fun comprar(): Mono<Compra> =
            recuperarUsuario()
                    .zipWith(recuperarLivro())
                    .flatMap { usuarioComLivro ->
                                esperar(1000)
                                .flatMap {
                                    Compra.exemplo(usuarioComLivro.t1, usuarioComLivro.t2).toMono()
                                }
                    }


//    private fun esperar(milissegundos: Long): Mono<Long> {
//        return Mono.just(System.out.println("Esperando $milissegundos milissegundos"))
//                .then(Mono.delay(Duration.ofMillis(milissegundos)))
//    }

    private fun esperar(milissegundos: Long) =  Mono.delay(Duration.ofMillis(milissegundos))
}