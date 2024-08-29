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
            println("\n[INFO] Nova área de conservação criada: $descricao\n")
        } else {
            println("\n[WARN] Descrição não foi inicializada.\n")
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
open class ReservaMarinha( // Marcada como `open` para permitir herança
    tipoAmbiente: String,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean,
    private val tipoReserva: String // Ex: "Biológica", tipo específico de reserva
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {

    // Implementação do método abstrato para retornar detalhes específicos da conservação
    override fun detalhesConservacao(): String {
        return "Reserva do tipo $tipoReserva em ambiente $tipoAmbiente com área de ${"%.2f".format(areaProtegidaEmKm2)} km²."
    }

    // Sobrescrita do método da interface para calcular eficiência ajustada
    override fun calcularEficiencia(): Double {
        val fatorAjuste = Utilidades.calcularFatorAjuste(areaProtegidaEmKm2)
        return super.calcularEficiencia(fatorAjuste)
    }

    // Implementação adicional para atender a interface
    override fun descricaoCompleta(): String {
        val eficienciaFormatada = "%.2f".format(calcularEficiencia())
        return """
            |-------------------------------------------------
            | Tipo de Reserva: $tipoReserva
            | Detalhes da Conservação: ${detalhesConservacao()}
            | Programa de Monitoramento: ${if (possuiProgramaMonitoramento) "Sim" else "Não"}
            | Eficiência de Conservação: $eficienciaFormatada
            |-------------------------------------------------
        """.trimMargin()
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

    // Classe anônima que estende ReservaMarinha para adicionar detalhes específicos
    val reservaEspecifica = object : ReservaMarinha("CORAL", 200.0, true, "Ecológica") {
        override fun detalhesConservacao(): String {
            // Adiciona detalhes específicos além do comportamento normal
            return super.detalhesConservacao() + " Inclui programas de pesquisa ecológica avançada."
        }

        override fun calcularEficiencia(): Double {
            // Ajusta a eficiência com um fator específico para esta classe anônima
            val fatorEspecial = Utilidades.calcularFatorAjuste(areaProtegidaEmKm2) + 0.5
            return super.calcularEficiencia(fatorEspecial)
        }

        override fun descricaoCompleta(): String {
            val eficienciaFormatada = "%.2f".format(calcularEficiencia())
            return """
                |-------------------------------------------------
                | Tipo de Reserva: Ecológica
                | Detalhes da Conservação: ${detalhesConservacao()}
                | Foco Especial: Inclui programas de pesquisa ecológica avançada e biodiversidade marinha.
                | Eficiência de Conservação: $eficienciaFormatada
                |-------------------------------------------------
            """.trimMargin()
        }
    }

    println(reservaEspecifica.descricaoCompleta())  // Saída da classe anônima com comportamento modificado
}