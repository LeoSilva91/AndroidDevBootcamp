fun main() {
    // Leitura do valor
    print("Digite um valor: ")
    val valor = readLine()?.toDoubleOrNull() ?: 0.0

    // Cálculo do reajuste de 5%
    val reajuste = valor * 0.05
    val valorReajustado = valor + reajuste

    // Exibição do valor reajustado
    println("O valor com um reajuste de 5% é: R$ ${"%.2f".format(valorReajustado)}")
}
