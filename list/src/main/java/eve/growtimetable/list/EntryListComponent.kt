package eve.growtimetable.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import eva.growtimetable.core.AppRouter
import eva.growtimetable.core.CommonComponent
import javax.inject.Scope

@MustBeDocumented
@Retention
@Scope
private annotation class List

@List
@Component(
    dependencies = [EntryListDependencies::class],
    modules = [EntryListModule::class]
)
interface EntryListComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun host(host: EntryListFragment): Builder

        fun dependencies(dependencies: EntryListDependencies): Builder
        fun build(): EntryListComponent
    }

    fun inject(host: EntryListFragment)
}

interface EntryListDependencies: CommonComponent {
    fun router(): AppRouter
}

@Module
class EntryListModule {
    @Provides
    @List
    fun viewModel(host: EntryListFragment): EntryListViewModel {
        return ViewModelProviders.of(host, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return EntryListViewModel() as T
            }
        }).get(EntryListViewModel::class.java)
    }
}