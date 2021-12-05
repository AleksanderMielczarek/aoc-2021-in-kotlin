fun <T : Any> mutableMatOf(rows: List<String>, elementConverter: (Char) -> T): MutableMat<T> {
    return ArrayMat(elementConverter).apply {
        addRows(rows)
    }
}

