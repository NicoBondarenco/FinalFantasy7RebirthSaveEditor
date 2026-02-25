package ffviirse.domain.extension

inline fun <reified R> Any.takeAs(): R? = this.takeIf { it is R }?.let { it as R }
