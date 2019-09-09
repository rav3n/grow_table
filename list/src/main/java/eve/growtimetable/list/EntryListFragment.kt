package eve.growtimetable.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.findDependencies
import javax.inject.Inject

class EntryListFragment : Fragment() {

    @Inject lateinit var
    router: AppRouter

    companion object {
        fun newInstance(): EntryListFragment {
            return EntryListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildComponent {
            it.inject(this)
        }
    }

    private fun buildComponent(block:(EntryListComponent) -> Unit) {
        block(
            DaggerEntryListComponent
                .builder()
                .dependencies(findDependencies())
                .build()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.entiry_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener { router.openEditor(0) }
    }

}