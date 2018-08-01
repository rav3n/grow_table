package eva.growtimetable.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import eva.growtimetable.R
import eva.growtimetable.presentation.list.EntryListFragment

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)
        if (hasntState(savedInstanceState)) {
            pushFragment(EntryListFragment.newInstance())
        }
    }

    private fun hasntState(savedInstanceState: Bundle?): Boolean {
        return savedInstanceState == null
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow()
    }
}