interface MutableMat<T : Any> : Mat<T> {
    fun addRow(rawRow: String)
    fun addRows(rawRows: List<String>)
}