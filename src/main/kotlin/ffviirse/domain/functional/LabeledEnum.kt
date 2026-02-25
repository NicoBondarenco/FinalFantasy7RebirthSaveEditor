package ffviirse.domain.functional

interface LabeledEnum : Labeled {

    override val label: String
        get() = ""
//        get() = EnumLabelI18N.labelFor(
//            this::class.simpleName!!.toDashCase(),
//            this.toString().toDashCase(),
//        )

//    private object EnumLabelI18N : BundleResolver("strings/value") {
//        fun labelFor(clazz: String, name: String): String = formattedMessage("value.$clazz.$name.label")
//    }

}
