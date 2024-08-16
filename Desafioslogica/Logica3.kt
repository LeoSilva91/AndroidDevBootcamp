fun main() {
    // Leitura dos valores de A e B
    print("Digite o valor de A: ")
    val A = readLine()?.toIntOrNull() ?: 0

    print("Digite o valor de B: ")
    val B = readLine()?.toIntOrNull() ?: 0

    // Declaração da variável C
    val C: Int

    // Verificação se A e B são iguais
    if (A == B) {
        // Se forem iguais, soma A e B
        C = A + B
    } else {
        // Caso contrário, multiplica A por B
        C = A * B
    }

    // Exibe o valor de C
    println("O valor de C é: $C")
}
