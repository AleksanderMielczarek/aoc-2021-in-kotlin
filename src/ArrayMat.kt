class ArrayMat<T : Any>(private val elementConverter: (Char) -> T) : MutableMat<T> {

    override val rows = mutableListOf<List<T>>()
    override val columns = mutableListOf<MutableList<T>>()

    override fun addRow(rawRow: String) {
        val newRow = rawRow.map(elementConverter)
        rows.add(newRow)
        addColumn(newRow)
    }

    override fun addRows(rawRows: List<String>) {
        val newRows = rawRows.map { it.map(elementConverter) }
        rows.addAll(newRows)
        newRows.forEach { addColumn(it) }
    }

    private fun addColumn(newRow: List<T>) {
        val missingColumns = newRow.size - columns.size
        repeat(missingColumns) {
            columns.add(mutableListOf())
        }
        columns.zip(newRow).forEach { (column, element) -> column.add(element) }
    }
}