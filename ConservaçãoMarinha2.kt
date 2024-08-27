// Enum para os tipos de ambientes marinhos
enum class TipoAmbiente {
    CORAL, MANGUE, RECIFE, MAR_ABERTO
}

// Data class para armazenar informações específicas sobre proteção
data class InformacaoProtecao(
    val tipoProtecao: String,
    val descricao: String
)

// Classe base para conservação marinha
open class ConservacaoMarinha(
    open val tipoAmbiente: TipoAmbiente,
    open val areaProtegidaEmKm2: Double,
    open val possuiProgramaMonitoramento: Boolean
) {
    lateinit var descricao: String // Usando lateinit para inicializar depois

    // Método para inicializar a descrição da área de conservação
    fun inicializarDescricao() {
        println("Nova área de conservação criada: $descricao")
    }

    // Método para exibir os detalhes da área de conservação usando 'with'
    open fun exibirDetalhes() {
        with(this) {
            println("=== Detalhes da Área de Conservação Marinha ===")
            println("Tipo de Ambiente: $tipoAmbiente")
            println("Área Protegida: $areaProtegidaEmKm2 km²")
            println("Possui Programa de Monitoramento: ${if (possuiProgramaMonitoramento) "Sim" else "Não"}")
            println("===============================================")
        }
    }
}

// Classe para reservas marinhas usando herança
class ReservaMarinha(
    tipoAmbiente: TipoAmbiente,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {

    // Sobrescrevendo método para exibir detalhes específicos de ReservaMarinha
    override fun exibirDetalhes() {
        super.exibirDetalhes()
        println("Tipo de Ambiente: Reserva Marinha")
    }
}

// Classe para áreas protegidas marinhas usando herança
class AreaProtegidaMarinha(
    tipoAmbiente: TipoAmbiente,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean,
    private val infoProtecao: InformacaoProtecao
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {

    // Sobrescrevendo método para exibir detalhes específicos de AreaProtegidaMarinha
    override fun exibirDetalhes() {
        super.exibirDetalhes()
        println("Tipo de Proteção: ${infoProtecao.tipoProtecao}")
        println("Descrição da Proteção: ${infoProtecao.descricao}")
    }
}

// Função principal para demonstrar as classes em ação
fun main() {
    // Criação e configuração de uma reserva marinha
    val reserva = ReservaMarinha(
        tipoAmbiente = TipoAmbiente.CORAL,
        areaProtegidaEmKm2 = 120.0,
        possuiProgramaMonitoramento = true
    ).apply {
        descricao = "Reserva dedicada à proteção de recifes de corais."
        inicializarDescricao() // Chama após definir a descrição
    }
    reserva.exibirDetalhes()

    // Criação de uma instância de InformacaoProtecao usando DataClass
    val infoProtecao = InformacaoProtecao(
        tipoProtecao = "Parque Nacional",
        descricao = "Área protegida no mar aberto para preservação de espécies marinhas."
    )

    // Criação e configuração de uma área protegida marinha
    val areaProtegida = AreaProtegidaMarinha(
        tipoAmbiente = TipoAmbiente.MAR_ABERTO,
        areaProtegidaEmKm2 = 250.0,
        possuiProgramaMonitoramento = false,
        infoProtecao = infoProtecao
    ).apply {
        descricao = infoProtecao.descricao
        inicializarDescricao() // Chama após definir a descrição
    }
    areaProtegida.exibirDetalhes()
}
