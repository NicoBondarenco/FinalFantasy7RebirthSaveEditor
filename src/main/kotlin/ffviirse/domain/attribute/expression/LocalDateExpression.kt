package ffviirse.domain.attribute.expression

import ffviirse.domain.attribute.binder.LocalDateBinder
import ffviirse.domain.attribute.binding.LocalDateBinding
import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.extension.toZoneSameInstant
import java.time.LocalDate
import java.time.ZoneId
import javafx.beans.value.ObservableObjectValue

interface LocalDateExpression : BaseTemporalExpression<LocalDate, ObservableLocalDateValue, LocalDateBinding>, ObservableLocalDateValue {

    companion object {

        fun localDateExpression(
            value: ObservableLocalDateValue
        ): LocalDateExpression = localDateExpression(value as ObservableObjectValue<LocalDate>)

        fun localDateExpression(
            value: ObservableObjectValue<LocalDate>
        ): LocalDateExpression = value.takeIf {
            it is LocalDateExpression
        }?.let {
            it as LocalDateExpression
        } ?: LocalDateBinder(value, { it }, listOf(value))

    }

    override fun toZoneSameInstant(
        zone: ZoneId
    ): LocalDateBinding = LocalDateBinder(this, { it.toZoneSameInstant(zone) }, listOf(this))

}
