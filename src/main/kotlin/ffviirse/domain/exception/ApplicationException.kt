package ffviirse.domain.exception

import ffviirse.domain.context.session.SessionContext.bundleMainApplication
import ffviirse.domain.exception.ErrorType.APPLICATION_ERROR


abstract class ApplicationException(
    override val message: String = bundleMainApplication.exceptionGenericErrorMessage,
    val type: ErrorType = APPLICATION_ERROR,
    val detail: Map<String, List<String>>? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)
