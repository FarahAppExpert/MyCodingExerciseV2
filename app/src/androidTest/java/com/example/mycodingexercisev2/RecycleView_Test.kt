package com.example.mycodingexercisev2


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mycodingexercisev2.adapter.ViewHolder
import com.example.mycodingexercisev2.api.ApiRetrofit
import com.example.mycodingexercisev2.model.CodingModel
import com.example.mycodingexercisev2.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith (AndroidJUnit4 :: class)
class RecycleView_Test
{
    @get:Rule
    val activityRule : ActivityScenarioRule <MainActivity> =  ActivityScenarioRule(MainActivity :: class.java)

    val List_of_item : Int = 5
    val getList = ApiRetrofit.getRequest()
    val GetList = CodingModel(0,0,"")

    @Test
    fun recycleView_luncher ()
    {
        onView(withId(R.id.List_recyclerview)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectItem_setOnFragment ()
    {
        onView(withId(R.id.List_recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                    List_of_item,
                    ViewActions.click()
                )
            )

        onView(withId(R.id.title)).check(matches(withText(GetList.title)))

    }

    @Test
    fun test_toMovieListFragment() {

        onView(withId(R.id.List_recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                    List_of_item,
                    ViewActions.click()
                )
            )

        onView(withId(R.id.title)).check(matches(withText(GetList.title)))

        Espresso.pressBack()

        onView(withId(R.id.List_recyclerview)).check(matches(isDisplayed()))
    }
}