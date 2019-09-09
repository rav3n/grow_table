package eve.growtimetable.list

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class EntryListViewModel: ViewModel() {

    private val data = MutableLiveData<List<EntryListModel>>()

    fun fetch() {
        val preValue = data.value ?: listOf(EntryListModel(-1))
        data.postValue(listOf(EntryListModel(preValue[0].id + 1)))
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<EntryListModel>>) {
        data.observe(owner, observer)
    }

    fun removeOwner(owner: LifecycleOwner) {
        data.removeObservers(owner)
    }
}