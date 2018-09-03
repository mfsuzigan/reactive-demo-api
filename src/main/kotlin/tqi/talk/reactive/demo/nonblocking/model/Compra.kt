package tqi.talk.reactive.demo.nonblocking.model

class Compra(val id: Long, val usuario: Usuario, val livro: Livro) {

    companion object {
        fun exemplo(usuario: Usuario, livro: Livro) = Compra(1L, usuario, livro)
    }
}