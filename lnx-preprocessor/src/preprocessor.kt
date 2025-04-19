import java.io.File

val keywordMap = mapOf(
    "function" to "fun",
    "objectBlueprint" to "class",
    "print" to "println",
    "permanent" to "val",
    "mutable" to "var",
    "runIf" to "if",
    "runIfNot" to "else",
    "loopWhile" to "while",
    "loopFor" to "for"
)

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: preprocessor <input.lnx>")
        return
    }

    val inputFile = File(args[0])

    if (!inputFile.exists()) {
        println("File ${args[0]} not found.")
        return
    }

    if (!inputFile.name.endsWith(".lnx")) {
        println("Error: Please use a .lnx file.")
        return
    }

    val outputFile = File(inputFile.nameWithoutExtension + ".kt")

    // Read the file and replace keywords
    val processed = inputFile.readText().let { text ->
        keywordMap.entries.fold(text) { acc, (custom, real) ->
            val regex = Regex("\\b$custom\\b") // Ensure proper word boundaries
            val replaced = acc.replace(regex, real)
            replaced
        }
    }

    // Check if the processed content is correct
    println("Processed content preview:\n${processed.take(100)}...") // Print first 100 chars for preview

    outputFile.writeText(processed)
    println("Transpiled ${inputFile.name} -> ${outputFile.name}")

    try {
        val compile = Runtime.getRuntime().exec("kotlinc ${outputFile.name} -include-runtime -d output.jar")
        compile.waitFor()

        if (compile.exitValue() != 0) {
            println("Compilation failed:")
            println(compile.errorStream.bufferedReader().readText())
            return
        }

        println("Compiled successfully. Running program:")
        val run = Runtime.getRuntime().exec("java -jar output.jar")
        run.inputStream.bufferedReader().lines().forEach { println(it) }
        run.errorStream.bufferedReader().lines().forEach { println(it) }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
