package eve.growtimetable.editor

import dagger.Component
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.CommonComponent

@Component(dependencies = [EntryEditorDependencies::class])
interface EntryEditorComponent {

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: EntryEditorDependencies): Builder
        fun build(): EntryEditorComponent
    }

    fun inject(host: EntryEditorFragment)
}

interface EntryEditorDependencies: CommonComponent {
    fun router(): AppRouter
}