class ConservacaoMarinha(
    var tipoAmbiente: String,
    var areaProtegidaEmKm2: Double,
    var possuiProgramaMonitoramento: Boolean
) {
    // Inicializador secundário com mensagem de boas-vindas personalizada
    init {
        println("Nova instância de ConservacaoMarinha criada!")
        println("Ambiente: $tipoAmbiente, Área Protegida: $areaProtegidaEmKm2 km², Possui Monitoramento: ${if (possuiProgramaMonitoramento) "Sim" else "Não"}")
    }

    // Getter e Setter personalizados
    var descricaoAmbiente: String = ""
        get() = "O tipo de ambiente é $tipoAmbiente"
        set(value) {
            field = if (value.isNotBlank()) value else "Tipo de ambiente não especificado"
            println("Descrição do ambiente atualizada para: $field")
        }

    // Função para apresentar detalhes da área protegida
    fun detalhesAreaProtegida() {
        println("=== Detalhes da Área Protegida ===")
        println("Tipo de Ambiente: $tipoAmbiente")
        println("Área Protegida: $areaProtegidaEmKm2 km²")
        println("Possui Programa de Monitoramento: ${if (possuiProgramaMonitoramento) "Sim" else "Não"}")
        println("===============================")
    }
}

// Função principal para demonstrar a classe em ação
fun main() {
    val corais = ConservacaoMarinha("Coral", 100.0, true)
    corais.descricaoAmbiente = "Ambiente de recifes de coral, rico em biodiversidade."
    corais.detalhesAreaProtegida()
}
