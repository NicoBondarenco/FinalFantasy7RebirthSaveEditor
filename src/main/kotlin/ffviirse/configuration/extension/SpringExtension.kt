package ffviirse.configuration.extension

import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.ApplicationContext

inline fun <reified T : Any> ApplicationContext.beans(): Map<String, T> = this.getBeansOfType<T>()

inline fun <reified T : Any> ApplicationContext.bean(): T = this.getBean(T::class.java)

inline fun <reified T : Any> ApplicationContext.bean(name: String): T = this.getBean(name, T::class.java)
