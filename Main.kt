fun main(args: Array<String>) {
    println("Bem vindo ao ByteBank!")

    val contaLuis = Conta("Luís", 1610)
    contaLuis.depositar(77.00)

    val contaShrieker = Conta("Shrieker Agon", 202)
    contaShrieker.depositar(1300.0)

    println(contaShrieker.titular)
    println(contaShrieker.numeroConta)
    println(contaShrieker.saldo)

    println("Depositando na conta do Shrieker")
    contaShrieker.depositar(50.0)
    println(contaShrieker.saldo)

    println("Depositando na conta do Luís")
    contaLuis.depositar(78.0)
    println(contaLuis.saldo)

    println("Sacando na conta do Shrieker")
    contaShrieker.sacar(250.0)
    println(contaShrieker.saldo)

    println("Sacando na conta do Luís")
    contaLuis.sacar(10.0)
    println(contaLuis.saldo)

    println("Tranferência da conta do Shrieker para o Luís")
    if (contaShrieker.transferencia(100.0, contaLuis)) {
        println("Tranferência sucessida!!!")
    } else {
        println("[ERRO] Falha na transferência!!!")
    }

    println(contaShrieker.saldo)
    println(contaLuis.saldo)
}

class Conta(var titular: String, val numeroConta: Int) {
    var saldo = 0.0
        private set

    fun depositar(valor: Double) {
        if ( valor > 0 ) {
            this.saldo += valor
        }
    }

    fun sacar(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transferencia(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.depositar(valor)
            return true
        }
        return false
    }
}

fun testaCondicoes(saldo: Double) {
    when {
        saldo > 0.0 -> println("Conta é positiva")
        saldo == 0.0 -> println("Conta é neutra")
        else -> println("Conta é negativa")
    }
}