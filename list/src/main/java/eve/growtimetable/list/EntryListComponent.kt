package eve.growtimetable.list

import dagger.Component
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.CommonComponent

@Component(dependencies = [EntryListDependencies::class])
interface EntryListComponent {

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: EntryListDependencies): Builder
        fun build(): EntryListComponent
    }

    fun inject(host: EntryListFragment)
}

interface EntryListDependencies: CommonComponent {
    fun router(): AppRouter
}