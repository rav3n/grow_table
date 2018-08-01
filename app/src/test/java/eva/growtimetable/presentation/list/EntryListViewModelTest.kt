package eva.growtimetable.presentation.list

import eva.growtimetable.Entry
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import kotlin.properties.ReadWriteProperty

class EntryListViewModelTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun load() {
        val viewModel = EntryListViewModel()
        println("${viewModel.items.size}")
        viewModel.items = arrayListOf(mockEntry(), mockEntry())
        println("${viewModel.items.size}")
    }

    private fun mockEntry(): Entry {
        return Entry(0, "", "")
    }

    @Test
    @Throws(Exception::class)
    fun update() {
    }
}