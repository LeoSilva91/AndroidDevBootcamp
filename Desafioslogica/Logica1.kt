fun main() {
    // Leitura dos valores de A, B e C
    print("Digite o valor de A: ")
    val A = readLine()?.toIntOrNull() ?: 0

    print("Digite o valor de B: ")
    val B = readLine()?.toIntOrNull() ?: 0

    print("Digite o valor de C: ")
    val C = readLine()?.toIntOrNull() ?: 0

    // Cálculo da soma entre A e B
    val soma = A + B

    // Exibição do resultado da soma
    println("A soma de A e B é: $soma")

    // Verificação se a soma é menor que C
    if (soma < C) {
        println("A soma é menor que C.")
    } else {
        println("A soma não é menor que C.")
    }
}
