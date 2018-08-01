package eva.growtimetable.presentation.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eva.growtimetable.R

class EntryListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): EntryListFragment {
            return EntryListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return makeLayout(inflater,  container)
    }

    private fun makeLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.entiry_list_fragment, container, false)
    }

}