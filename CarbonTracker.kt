fun main() {
    // Definindo fatores de emissão para diferentes tipos de transporte
    val fatoresEmissao = arrayOf(0.21, 0.105, 0.133) // Valores em kg CO2/km

    // Listas para armazenar as distâncias percorridas e os tipos de transporte utilizados
    val distancias = mutableListOf<Double>()
    val tiposTransporte = mutableListOf<Int>()

    // Loop para coletar dados do usuário - adicione quantas viagens quiser!
    var continuar = true
    while (continuar) {
        print("Insira a distância percorrida (em km): ")
        val distancia = readLine()?.toDoubleOrNull() ?: 0.0
        distancias.add(distancia)

        print("Escolha o tipo de transporte (0: Carro, 1: Ônibus, 2: Avião): ")
        val tipoTransporte = readLine()?.toIntOrNull() ?: 0
        tiposTransporte.add(tipoTransporte)

        print("Deseja adicionar outra viagem? (s/n): ")
        continuar = readLine()?.toLowerCase() == "s"
    }

    // Calculando a pegada de carbono para cada viagem registrada
    val pegadas = calcularPegada(distancias, tiposTransporte, fatoresEmissao)

    // Exibindo os resultados detalhados para o usuário
    exibirResultados(distancias, tiposTransporte, pegadas)

    // Calculando e exibindo a pegada de carbono total
    val pegadaTotal = pegadas.sum()
    println("Sua pegada total de CO2: %.2f kg".format(pegadaTotal))
}

// Função para calcular a pegada de carbono para cada viagem
fun calcularPegada(distancias: List<Double>, tiposTransporte: List<Int>, fatores: Array<Double>): List<Double> {
    val pegadas = mutableListOf<Double>()
    for (i in distancias.indices) {
        val pegada = distancias[i] * fatores[tiposTransporte[i]]
        pegadas.add(pegada)
    }
    return pegadas
}

// Função para exibir os resultados da pegada de carbono ao usuário
fun exibirResultados(distancias: List<Double>, tiposTransporte: List<Int>, pegadas: List<Double>) {
    val transportes = arrayOf("Carro", "Ônibus", "Avião")
    for (i in distancias.indices) {
        println("Detalhes da Viagem ${i + 1}:")
        println(" - Distância percorrida: ${distancias[i]} km")
        println(" - Tipo de Transporte: ${transportes[tiposTransporte[i]]}")
        println(" - Pegada de CO2: %.2f kg".format(pegadas[i]))
    }
}
