package eva.growtimetable.presentation.list

interface EntryListView<T> {
    fun showItems(items: List<T>)
    fun onItemClicked(item: T)
}