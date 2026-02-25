package ffviirse.domain.extension

import ffviirse.domain.exception.ApplicationException


fun Throwable.logMessage(): String = if (this is ApplicationException) {
    this.message.let {
        "$it\n" + (this.detail?.map { entry ->
            "\t${entry.key}\n\t\t${entry.value.joinToString("\n\t\t")}"
        }?.joinToString("\n") ?: nullString())
    }
} else {
    this.message ?: nullString()
}
