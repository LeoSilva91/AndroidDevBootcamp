fun main() {
    // Leitura dos três valores inteiros
    print("Digite o primeiro valor inteiro: ")
    val valor1 = readLine()?.toIntOrNull() ?: 0

    print("Digite o segundo valor inteiro: ")
    val valor2 = readLine()?.toIntOrNull() ?: 0

    print("Digite o terceiro valor inteiro: ")
    val valor3 = readLine()?.toIntOrNull() ?: 0

    // Armazenando os valores em uma lista e ordenando em ordem decrescente
    val valores = listOf(valor1, valor2, valor3).sortedDescending()

    // Exibindo os valores em ordem decrescente
    println("Os valores em ordem decrescente são: ${valores.joinToString(", ")}")
}
