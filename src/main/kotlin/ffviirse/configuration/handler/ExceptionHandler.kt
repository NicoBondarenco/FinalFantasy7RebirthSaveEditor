package ffviirse.configuration.handler

import com.database.tesis.adapter.ui.component.showErrorNotification
import com.database.tesis.adapter.ui.component.showWarningNotification
import ffviirse.domain.exception.ApplicationException
import ffviirse.domain.exception.ErrorType
import ffviirse.domain.extension.logMessage

class ExceptionHandler : Thread.UncaughtExceptionHandler {

    companion object {
        private val WARN_STATUS_LIST: Set<ErrorType> = setOf(
            ErrorType.NOT_FOUND,
        )
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        e.printStackTrace()
        e.takeIf {
            (e is ApplicationException) && WARN_STATUS_LIST.contains(e.type)
        }?.apply {
            showWarningNotification("Atenção", this.logMessage())
        } ?: showErrorNotification("Erro", e.logMessage())
    }

}
