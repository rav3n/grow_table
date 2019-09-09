package eva.growtimetable.presentation

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import eva.growtimetable.core.AppRouter
import eve.growtimetable.editor.EntryEditorDependencies
import eve.growtimetable.list.EntryListDependencies
import javax.inject.Singleton

@Singleton
@Component(modules = [Routing::class])
interface RootComponent: DependenciesProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun root(activity: AppCompatActivity): Builder

        fun build(): RootComponent
    }

    fun inject(host: RootActivity)
}

@Module
class Routing {

    @Provides
    @Singleton
    fun router(activity: AppCompatActivity): AppRouter {
        return RouterImpl(activity)
    }

}

interface DependenciesProvider: EntryListDependencies, EntryEditorDependencies