fun main() {
    // Leitura do primeiro valor booleano
    print("Digite o primeiro valor booleano (true ou false): ")
    val valor1 = readLine()?.toBoolean() ?: false

    // Leitura do segundo valor booleano
    print("Digite o segundo valor booleano (true ou false): ")
    val valor2 = readLine()?.toBoolean() ?: false

    // Verificação se ambos os valores são verdadeiros
    if (valor1 && valor2) {
        println("Ambos os valores são VERDADEIROS.")
    } else if (!valor1 && !valor2) {
        println("Ambos os valores são FALSOS.")
    } else {
        println("Os valores são diferentes (um verdadeiro e outro falso).")
    }
}
