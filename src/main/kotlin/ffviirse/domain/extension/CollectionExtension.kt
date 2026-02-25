package ffviirse.domain.extension

import javafx.collections.FXCollections
import javafx.collections.ObservableList

fun <E> Collection<E>.asObservable(): ObservableList<E> = FXCollections.observableArrayList(this)
