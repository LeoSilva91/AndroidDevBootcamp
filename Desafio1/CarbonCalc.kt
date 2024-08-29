import java.io.File // Importa a classe File, que permite a leitura de arquivos do sistema de arquivos

fun main() {
    // Mensagem de boas-vindas e introdução ao programa
    println("Calculadora de Pegada de CO2")
    println("Vamos juntos descobrir o impacto das suas escolhas diárias no meio ambiente.")
    println("Este programa irá calcular sua pegada de carbono com base nos itens de consumo listados em um arquivo de texto.")

    val fileName = "consumo.txt" // Nome do arquivo de texto que contém os dados de consumo

    // Tenta ler as linhas do arquivo especificado
    val linhas = try {
        File(fileName).readLines() // Lê todas as linhas do arquivo e armazena em uma lista de strings
    } catch (e: Exception) {
        // Em caso de erro ao ler o arquivo, exibe uma mensagem de erro e encerra o programa
        println("Oops! Parece que houve um problema ao tentar ler o arquivo: ${e.message}")
        println("Por favor, verifique se o arquivo está no local correto e tente novamente.")
        return // Encerra a função main, pois não há dados para processar
    }

    // Calcula o total de CO2 gerado com base nas linhas lidas do arquivo
    val totalCO2 = calcularPegadaTotal(linhas)
    // Exibe o total de CO2 gerado
    println("\nParabéns! Você completou a análise.")
    println("Sua pegada total de CO2 gerada é: %.2f kg".format(totalCO2))

    // Fornece dicas para reduzir a pegada de carbono
    fornecerDicasParaReduzirPegadaAvancada()
}

// Função que calcula a pegada total de CO2 com base nos itens e quantidades lidas do arquivo
fun calcularPegadaTotal(linhas: List<String>): Double {
    var totalCO2 = 0.0 // Variável para acumular o total de CO2 gerado

    // Itera sobre cada linha do arquivo
    for ((index, linha) in linhas.withIndex()) {
        val partes = linha.split(",") // Divide a linha em partes separadas por vírgula

        // Obtém o nome do item e a quantidade consumida
        val item = partes.getOrNull(0)?.trim() ?: "Desconhecido" // Se o item não for encontrado, usa "Desconhecido"
        val quantidade = partes.getOrNull(1)?.trim()?.toDoubleOrNull() ?: run {
            // Se a quantidade for inválida ou nula, exibe uma mensagem de erro e assume 0.0
            println("Atenção: Quantidade inválida encontrada na linha ${index + 1}. Vamos considerar 0.0 por segurança.")
            0.0
        }

        // Calcula o CO2 gerado para o item com base na quantidade e no fator de emissão
        val co2 = calcularCO2(item, quantidade)
        // Exibe o item, a quantidade e o CO2 gerado
        println("Item analisado: $item | Quantidade: $quantidade | CO2 gerado: %.2f kg".format(co2))
        // Acumula o CO2 gerado no total
        totalCO2 += co2
    }

    return totalCO2 // Retorna o total de CO2 gerado
}

// Função que calcula o CO2 gerado para um item específico com base na quantidade consumida
fun calcularCO2(item: String, quantidade: Double): Double {
    // Determina o fator de emissão para o item
    val fator = when (item.toLowerCase()) {
        "arroz" -> 0.005  // Fator de emissão para arroz
        "feijao" -> 0.01  // Fator de emissão para feijão
        "carne" -> 0.027  // Fator de emissão para carne (exemplo)
        "leite" -> 0.015  // Fator de emissão para leite (exemplo)
        else -> {
            // Se o item não for reconhecido, exibe um aviso e assume fator de emissão como 0
            println("Aviso: O item \"$item\" não foi reconhecido. Assumindo fator de emissão como 0.")
            0.0
        }
    }

    return quantidade * fator // Retorna o CO2 gerado para a quantidade informada
}

// Função que fornece dicas para reduzir a pegada de carbono
fun fornecerDicasParaReduzirPegadaAvancada() {
    println("\n=== Dicas Personalizadas para Reduzir sua Pegada de CO2 ===")
    println("1. Diminua o consumo de carne e produtos de origem animal para reduzir significativamente suas emissões.")
    println("2. Prefira produtos locais e sazonais, assim você ajuda a cortar emissões do transporte.")
    println("3. Planeje suas compras para evitar desperdícios de alimentos, comprando apenas o necessário.")
    println("Lembre-se: pequenas ações podem fazer uma grande diferença!")
}
