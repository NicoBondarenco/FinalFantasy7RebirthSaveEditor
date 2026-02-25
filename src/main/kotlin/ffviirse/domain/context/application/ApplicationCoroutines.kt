package ffviirse.domain.context.application

import java.util.concurrent.Executors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.withContext

val Dispatchers.VT
    get() = Executors.newVirtualThreadPerTaskExecutor().asCoroutineDispatcher()

suspend fun <T> withContextFX(
    block: suspend CoroutineScope.() -> T
): T = withContext(Dispatchers.JavaFx, block)

suspend fun <T> withContextMAIN(
    block: suspend CoroutineScope.() -> T
): T = withContext(Dispatchers.Main, block)

suspend fun <T> withContextIO(
    block: suspend CoroutineScope.() -> T
): T = withContext(Dispatchers.IO, block)

suspend fun <T> withContextVT(
    block: suspend CoroutineScope.() -> T
): T = withContext(Dispatchers.VT, block)
