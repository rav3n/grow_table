
interface EntryListView<T> {
    fun showItems(items: List<T>)
    fun onItemClicked(item: T)
}