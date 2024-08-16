fun main() {
    // Leitura do número
    print("Digite um número: ")
    val numero = readLine()?.toIntOrNull() ?: 0

    // Verificação se o número é par ou ímpar
    if (numero % 2 == 0) {
        println("O número $numero é par.")
    } else {
        println("O número $numero é ímpar.")
    }

    // Verificação se o número é positivo, negativo ou zero
    when {
        numero > 0 -> println("O número $numero é positivo.")
        numero < 0 -> println("O número $numero é negativo.")
        else -> println("O número é zero.")
    }
}

