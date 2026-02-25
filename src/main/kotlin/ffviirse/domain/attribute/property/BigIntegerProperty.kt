package ffviirse.domain.attribute.property

import ffviirse.domain.attribute.observable.ObservableBigIntegerValue
import ffviirse.domain.attribute.readonly.ReadOnlyBigIntegerProperty
import ffviirse.domain.attribute.writable.WritableBigIntegerPropertyValue
import java.math.BigInteger
import javafx.beans.property.Property

interface BigIntegerProperty: BaseProperty<BigInteger, ObservableBigIntegerValue>, ReadOnlyBigIntegerProperty, WritableBigIntegerPropertyValue, Property<BigInteger>
