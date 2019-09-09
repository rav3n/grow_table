
package eva.growtimetable.core

import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
fun <T: CommonComponent>Fragment.findDependencies(): T {
    val provider = requireActivity() as RootComponentProvider
    return provider.get() as T
}