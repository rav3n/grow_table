package eve.growtimetable.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class EntryEditorFragment: Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return EntryEditorFragment()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.entiry_editor_fragment, container, false)
    }
}