fun main() {
    // Leitura do peso e altura
    print("Digite seu peso em kg: ")
    val peso = readLine()?.toDoubleOrNull() ?: 0.0

    print("Digite sua altura em metros: ")
    val altura = readLine()?.toDoubleOrNull() ?: 0.0

    // Cálculo do IMC
    if (altura > 0) {
        val imc = peso / (altura * altura)

        // Determinação da condição do IMC
        val condicao = when {
            imc < 18.5 -> "Abaixo do peso"
            imc in 18.5..24.9 -> "Peso ideal (parabéns)"
            imc in 25.0..29.9 -> "Levemente acima do peso"
            imc in 30.0..34.9 -> "Obesidade grau I"
            imc in 35.0..39.9 -> "Obesidade grau II (severa)"
            imc >= 40 -> "Obesidade grau III (mórbida)"
            else -> "IMC fora dos limites conhecidos"
        }

        // Exibição do IMC e da condição
        println("Seu IMC é: ${"%.2f".format(imc)}")
        println("Condição: $condicao")
    } else {
        println("Altura inválida. Não é possível calcular o IMC.")
    }
}
