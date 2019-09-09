package eva.growtametable.navigation

import androidx.appcompat.app.AppCompatActivity

abstract class Router(private val activity: AppCompatActivity) {

    protected fun replaceWithAddBackStack(fragment: androidx.fragment.app.Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment::class.java.simpleName)
            .commit()
    }

    protected fun replace(fragment: androidx.fragment.app.Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}