package tqi.talk.reactive.demo.nonblocking.model

data class Livro(val id: Long, val titulo: String, val autor: String, val ano: Int) {

    companion object {

        fun exemplo(): Livro = Livro(1L, "Ação Humana", "Ludwig von Mises", 1949)

        fun exemplos(): List<Livro> = listOf(
                Livro(1L, "Ação Humana", "Ludwig von Mises", 1949),
                Livro(2L, "A ética da liberdade", "Murray Rothbard", 1982),
                Livro(3L, "O caminho da servidão", "F. A. Hayek", 1944))
    }
}