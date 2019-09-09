package eve.growtimetable.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.findDependencies
import kotlinx.android.synthetic.main.entiry_list_fragment.*
import javax.inject.Inject

class EntryListFragment : Fragment() {

    @Inject lateinit var
    router: AppRouter

    @Inject lateinit var
    viewModel: EntryListViewModel

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
                .host(this)
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

    override fun onResume() {
        super.onResume()
        viewModel.fetch()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnClickListener {
            router.openEditor(1)
        }

        viewModel.observe(this, Observer {
            text.text = "$it"
        })
    }

    override fun onDestroyView() {
        viewModel.removeOwner(this)
        super.onDestroyView()
    }

}