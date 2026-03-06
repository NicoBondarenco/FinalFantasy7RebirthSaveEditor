package ffviirse.random

import ffviirse.domain.extension.snakeToCamelCase
import ffviirse.domain.model.value.ItemType
import java.io.File
import org.junit.jupiter.api.Test

class RandomTest {

    @Test
    fun `Generate Item Data`() {
        val offsetList = mutableListOf<String>()
        val offsetNames = mutableListOf<String>()
        val labelMap = ItemType.entries.associateWith { mutableListOf<String>() }
        val enumMap = mutableMapOf<Int, String>()
        itemRawList.forEachIndexed { index, line ->

            val (offsetString, nameString, typeString) = line.split(";")
            if (nameString.split(" ").size != 4) {
                throw RuntimeException("Invalid Item Data Name: $nameString")
            }

            val snakeName = nameString.replace(" ", "_")
            val camelName = snakeName.snakeToCamelCase().replace("_", "")
            val offsetName = "${camelName}Offset"
            val labelName = "${camelName}Label"

            val type = ItemType.entries.firstOrNull { itemType ->
                itemType.fileValue == typeString.removePrefix("0x").toInt(16)
            } ?: throw RuntimeException("Invalid Item Data Type: $typeString")

            offsetList.add("val $offsetName:Int = $offsetString")
            offsetNames.add(offsetName)
            labelMap[type]!!.add("val $labelName:String = nullString(),")
            enumMap[index] = "${snakeName.uppercase()}($index, $offsetName, $type, { bundlePartyTab.${type.name.lowercase().snakeToCamelCase()}Labels.$labelName }),"
        }

        val content = buildString {
            appendLine("-".repeat(100))
            appendLine()
            offsetList.forEach { appendLine(it) }
            appendLine()
            appendLine("-".repeat(100))
            appendLine()
            appendLine(enumMap.writeEnum(offsetNames))
            appendLine()
            appendLine("-".repeat(100))
            appendLine()
            appendLine(labelMap.writeClasses())
        }

        File("D:\\projects\\FinalFantasy7RebirthSaveEditor\\src\\test\\resources\\item-result.txt").writeText(content)
    }

    private fun MutableMap<Int, String>.writeEnum(
        offsetNames: List<String>,
    ): String = buildString {
        appendLine()
        appendLine("package ffviirse.domain.model.value")
        appendLine()
        appendLine("import ffviirse.domain.context.session.SessionContext.bundlePartyTab")
        appendLine("import ffviirse.domain.functional.Labeled")
        offsetNames.forEach { appendLine("import ffviirse.domain.model.mapper.$it") }
        ItemType.entries.forEach { appendLine("import ffviirse.domain.model.value.ItemType.$it") }
        appendLine()
        appendLine("enum class InventoryItem(")
        appendLine("    val displayOrder: Int,")
        appendLine("    val fileValue: Int,")
        appendLine("    val itemType: ItemType,")
        appendLine("    val typeName: () -> String,")
        appendLine(") : Labeled {")
        appendLine()
        this@writeEnum.entries.sortedBy { it.key }.forEach {
            appendLine("    ${it.value}")
        }
        appendLine()
        appendLine("}")
    }

    private fun Map<ItemType, MutableList<String>>.writeClasses(): String = buildString {
        this@writeClasses.forEach { entry ->
            appendLine(entry.writeItemTypeLabels())
            appendLine()
        }
    }

    private fun Map.Entry<ItemType, MutableList<String>>.writeItemTypeLabels(): String = buildString {
        val klassName = this@writeItemTypeLabels.key.name.lowercase().snakeToCamelCase().replaceFirstChar { it.uppercase() }
        appendLine("package ffviirse.domain.i18n")
        appendLine()
        appendLine("import ffviirse.domain.extension.nullString")
        appendLine()
        appendLine("data class I18nBundle${klassName}Item(")
        this@writeItemTypeLabels.value.forEach { item ->
            appendLine("    $item")
        }
        appendLine(")")
    }

}
