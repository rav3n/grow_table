package eva.growtimetable.presentation

import androidx.appcompat.app.AppCompatActivity
import eva.growtametable.navigation.Router
import eva.growtimetable.core.AppRouter
import eve.growtimetable.editor.EntryEditorFragment
import eve.growtimetable.list.EntryListFragment

class RouterImpl(activity: AppCompatActivity): Router(activity), AppRouter {

    override fun initList() {
        replace(EntryListFragment.newInstance())
    }

    override fun openEditor(id: Long) {
        replaceWithAddBackStack(EntryEditorFragment.newInstance())
    }

}