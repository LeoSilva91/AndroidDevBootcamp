fun main() {
    // Leitura das três notas
    print("Digite a primeira nota: ")
    val nota1 = readLine()?.toDoubleOrNull() ?: 0.0

    print("Digite a segunda nota: ")
    val nota2 = readLine()?.toDoubleOrNull() ?: 0.0

    print("Digite a terceira nota: ")
    val nota3 = readLine()?.toDoubleOrNull() ?: 0.0

    // Cálculo da média
    val media = (nota1 + nota2 + nota3) / 3

    // Exibição da média
    println("A média das notas é: ${"%.2f".format(media)}")
}
