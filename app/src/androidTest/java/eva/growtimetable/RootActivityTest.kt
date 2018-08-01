package eva.growtimetable

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import eva.growtimetable.presentation.RootActivity
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.not
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RootActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<RootActivity>(RootActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        Intents.init()
        setupSingleActivity()
    }

    private fun setupSingleActivity() {
        activity.launchActivity(Intent())
    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("eva.growtimetable", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun activityIsRunningTest() {
        intended(hasComponent(RootActivity::class.java!!.name))
    }

    @Test
    @Throws(Exception::class)
    fun fragmentShowListTest() {
        onView(withId(R.id.text)).check(matches(withText("test")))
        onView(withId(R.id.text)).check(matches(not(withText("test_test"))))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        Intents.release()
    }
}