fun main() {
    // Nome e introdução do programa
    println("=== PegadaCO2 ===")

    // Solicitar e calcular consumo de eletricidade e gás natural
    val eletricidade = solicitarConsumo("eletricidade", "kWh")
    val gas = solicitarConsumo("gás natural", "m³")
    val pegadaTotal = calcularPegada(eletricidade, gas)

    // Exibir resultados e fornecer dicas para reduzir pegada de CO2
    exibirResultados(eletricidade, gas, pegadaTotal)
    fornecerDicasParaReduzirPegada()
}

// Função para introduzir o programa ao usuário
fun introducao() {
    println("Bem-vindo ao Calculador de Pegada de CO2!")
    println("Este programa ajuda você a calcular sua pegada de carbono com base no consumo de eletricidade e gás natural.")
}

// Função para solicitar o consumo de energia do usuário
fun solicitarConsumo(tipo: String, unidade: String): Double {
    print("Por favor, insira o consumo de $tipo mensal em $unidade: ")
    return readLine()?.toDoubleOrNull() ?: 0.0 // Lê a entrada do usuário e converte para Double, ou 0.0 se inválido
}

// Função para calcular a pegada de carbono com base no consumo
fun calcularPegada(eletricidade: Double, gas: Double): Double {
    val fatorEletricidade = 0.475 // kg CO2 por kWh
    val fatorGas = 2.0 // kg CO2 por m³
    val emissaoEletricidade = eletricidade * fatorEletricidade
    val emissaoGas = gas * fatorGas
    return emissaoEletricidade + emissaoGas
}

// Função para exibir os resultados ao usuário
fun exibirResultados(eletricidade: Double, gas: Double, pegadaTotal: Double) {
    println("Sua pegada de CO2 mensal é de:")
    println("Eletricidade: %.2f kg CO2".format(eletricidade * 0.475))
    println("Gás natural: %.2f kg CO2".format(gas * 2.0))
    println("Total: %.2f kg CO2".format(pegadaTotal))

    // Estrutura de decisão para fornecer feedback ao usuário
    if (pegadaTotal > 100) {
        println("Alerta: Sua pegada de CO2 é alta. Considere reduzir seu consumo de energia.")
    } else {
        println("Sua pegada de CO2 está dentro de um limite aceitável, mas é sempre bom buscar reduzir ainda mais.")
    }
}

// Função para fornecer dicas sobre como reduzir a pegada de CO2
fun fornecerDicasParaReduzirPegada() {
    println("Dicas para reduzir sua pegada de CO2:")
    println("1. Reduza o consumo de eletricidade desligando aparelhos não utilizados.")
    println("2. Utilize fontes de energia renovável sempre que possível.")
    println("3. Considere alternativas de transporte mais ecológicas.")
}
