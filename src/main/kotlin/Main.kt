import org.fusesource.jansi.Ansi

fun main() {
    // Usando Jansi para colorir a saída
    println(Ansi.ansi().fg(Ansi.Color.MAGENTA).a("╔════════════════════════════╗").reset())
    println(Ansi.ansi().fg(Ansi.Color.MAGENTA).a("║      ✨ FiboMagic ✨       ║").reset())
    println(Ansi.ansi().fg(Ansi.Color.MAGENTA).a("╚════════════════════════════╝").reset())

    print(Ansi.ansi().fg(Ansi.Color.CYAN).a("Digite um número (mínimo 3): ").reset())
    val n = readlnOrNull()?.toIntOrNull()

    // Verifica se o número é válido (pelo menos 3)
    if (n != null && n >= 3) {
        val fibonacci = gerarFibonacci(n)

        println("\n" + Ansi.ansi().fg(Ansi.Color.GREEN).a("Sequência de Fibonacci com $n termos:").reset())
        println(fibonacci.joinToString(" "))

        exibirCalculos(fibonacci)
    } else {
        println(Ansi.ansi().fg(Ansi.Color.RED).a("Erro: O número deve ser MINÍMO 3.").reset())
    }
}

fun gerarFibonacci(n: Int): List<Int> {
    val fibonacci = MutableList(n) { 0 }
    if (n > 0) fibonacci[0] = 1
    if (n > 1) fibonacci[1] = 1

    for (i in 2 until n) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
    }

    return fibonacci
}

/**
 * Exibe os cálculos da sequência de Fibonacci.
 */
fun exibirCalculos(fibonacci: List<Int>) {
    println("\n" + Ansi.ansi().fg(Ansi.Color.BLUE).a("Cálculo passo a passo:").reset())

    fibonacci.indices.forEach { i ->
        val calculo = if (i < 2) "F(${i + 1}) = 1"
        else "F(${i + 1}) = F(${i}) + F(${i - 1}) → ${fibonacci[i - 1]} + ${fibonacci[i - 2]} = ${fibonacci[i]}"

        println(Ansi.ansi().fg(Ansi.Color.YELLOW).a(calculo).reset()) // Amarelo
    }
}
