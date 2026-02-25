package ffviirse.domain.attribute.readonly.base

import ffviirse.domain.attribute.observable.ObservableLocalDateValue
import ffviirse.domain.attribute.readonly.ReadOnlyLocalDateProperty
import java.time.LocalDate

interface ReadOnlyLocalDatePropertyBase : ReadOnlyPropertyBase<LocalDate, ObservableLocalDateValue>, ReadOnlyLocalDateProperty
