fun main() {
    // Definindo o valor do salário mínimo
    val salarioMinimo = 1293.20

    // Leitura do valor do salário do usuário
    print("Digite o valor do seu salário: ")
    val salarioUsuario = readLine()?.toDoubleOrNull() ?: 0.0

    // Cálculo de quantos salários mínimos o usuário ganha
    val quantidadeSalarios = salarioUsuario / salarioMinimo

    // Exibição do resultado
    println("Você ganha o equivalente a ${"%.2f".format(quantidadeSalarios)} salários mínimos.")
}
