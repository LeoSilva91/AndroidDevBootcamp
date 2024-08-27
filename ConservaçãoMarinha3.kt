// Interface para definir funcionalidades de conservação
interface Conservacao {
    fun calcularEficiencia(): Double // Calculo baseado em dados da classe
    fun descricaoCompleta(): String  // Retorna uma descrição completa com base nos dados da classe
}

// Classe abstrata para conservação marinha
abstract class ConservacaoMarinha(
    val tipoAmbiente: String,         // Ex: "CORAL", especifica o tipo de ambiente marinho
    val areaProtegidaEmKm2: Double,   // Ex: 150.0, especifica a área protegida em km²
    val possuiProgramaMonitoramento: Boolean // Ex: true/false, indica se há monitoramento
) : Conservacao {
    lateinit var descricao: String    // Inicializada posteriormente para detalhar a conservação

    // Método para inicializar e exibir a descrição da área de conservação
    fun inicializarDescricao() {
        if (::descricao.isInitialized) {
            println("Nova área de conservação criada: $descricao")
        } else {
            println("Descrição não foi inicializada.")
        }
    }

    // Método abstrato que será implementado pelas subclasses
    abstract fun detalhesConservacao(): String

    // Método sobrecarregado para calcular eficiência com um fator de ajuste opcional
    fun calcularEficiencia(fator: Double = 1.0): Double {
        // Ajusta o cálculo da eficiência com base no fator e no programa de monitoramento
        return if (possuiProgramaMonitoramento) areaProtegidaEmKm2 * fator * 1.5 else areaProtegidaEmKm2 * fator
    }
}

// Companion Object para definir constantes ou funções utilitárias
class Utilidades {
    companion object {
        const val FACTOR_CONSERVACAO = 1.2 // Fator fixo usado para ajustar cálculos de eficiência

        // Método para calcular um fator de ajuste baseado na área protegida
        fun calcularFatorAjuste(area: Double): Double {
            return area * FACTOR_CONSERVACAO
        }
    }
}

// Classe concreta que herda de ConservacaoMarinha
class ReservaMarinha(
    tipoAmbiente: String,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean,
    private val tipoReserva: String // Ex: "Biológica", tipo específico de reserva
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {

    // Implementação do método abstrato para retornar detalhes específicos da conservação
    override fun detalhesConservacao(): String {
        return "Reserva do tipo $tipoReserva em ambiente $tipoAmbiente com área de $areaProtegidaEmKm2 km²."
    }

    // Sobrescrita do método da interface para calcular eficiência ajustada
    override fun calcularEficiencia(): Double {
        val fatorAjuste = Utilidades.calcularFatorAjuste(areaProtegidaEmKm2)
        return super.calcularEficiencia(fatorAjuste)
    }

    // Implementação adicional para atender a interface
    override fun descricaoCompleta(): String {
        return "$tipoReserva: ${detalhesConservacao()} - Eficiência de conservação: ${calcularEficiencia()}"
    }
}

// Classe objeto para gerenciar conservação, garantindo uma única instância
object GerenciadorConservacao {
    fun criarReserva(tipoAmbiente: String, areaProtegidaEmKm2: Double, possuiProgramaMonitoramento: Boolean, tipoReserva: String): ReservaMarinha {
        // Cria uma nova instância de ReservaMarinha com os dados fornecidos
        return ReservaMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento, tipoReserva)
    }
}

// Função principal para demonstrar as classes em ação
fun main() {
    // Criação de uma reserva usando o GerenciadorConservacao com dados fornecidos
    val reserva = GerenciadorConservacao.criarReserva("CORAL", 150.0, true, "Biológica").apply {
        descricao = "Reserva dedicada à proteção de recifes de corais."
        inicializarDescricao() // Inicializa a descrição com base nos dados fornecidos
    }
    println(reserva.descricaoCompleta())
}