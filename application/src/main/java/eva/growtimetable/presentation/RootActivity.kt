package eva.growtimetable.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eva.growtimetable.R
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.RootComponentProvider
import javax.inject.Inject

class RootActivity : AppCompatActivity(), RootComponentProvider {

    @Inject lateinit var
    router: AppRouter

    private val component by lazy {
        DaggerRootComponent
            .builder()
            .root(this)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)

        component.inject(this)

        if (savedInstanceState == null) {
            router.initList()
        }
    }

    override fun get() = component

}