package ffviirse.domain.extension

import java.text.Normalizer
import java.text.Normalizer.Form.NFD

private val INVALID_CHARACTERS = Regex("[\\\\/:*?\"<>|]")
private val RESERVED_NAMES = Regex("^(CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])$", RegexOption.IGNORE_CASE)

fun nullString(): String = ""

fun String.unaccentLower() = Normalizer.normalize(this, NFD)
    .replace("[^\\p{ASCII}]", nullString())
    .lowercase()

fun String.toSnakeCase(): String = this.replace("(?<=.)[A-Z]".toRegex(), "_$0").lowercase()

fun String.toDashCase(): String = this.replace("(?<=.)[A-Z]".toRegex(), "-$0").lowercase()

fun <T> String.parseOrNull(parser: (String) -> T?): T? = try {
    parser(this)
} catch (e: Exception) {
    null
}

fun String.onlyNumbers(): String = this.filter { it.isDigit() }
