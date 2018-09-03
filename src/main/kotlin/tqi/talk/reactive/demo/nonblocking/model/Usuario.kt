package tqi.talk.reactive.demo.nonblocking.model

import java.util.*

class Usuario(val email:String, val nome:String, val dataCadastro:Date){

    companion object {
        fun exemplo():Usuario = Usuario("zezinho@ancap.com", "Jose Silva", Date())
    }
}
