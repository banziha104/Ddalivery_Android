package com.iyeongjoon.nicname.ddalivery.view.actvities

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignUpActivityViewTest  {

    @get:Rule
    val intentsRule = IntentsTestRule(SignUpActivity::class.java)

    private val testId = "banziha104@gmail.com"
    private val testPassword = "password"
    private val testDetailAddress = "1313"
    private val testPhone = "01012341234"
    private val testAddress = "부천시"

    @Test
    fun checkEditTextChange(){
        onView(withId(R.id.signUpEditId)).perform(replaceText(testId))
        onView(withId(R.id.signUpEditAdressDetail)).perform(replaceText(testDetailAddress))
        onView(withId(R.id.signUpEditPs)).perform(replaceText(testPassword))
        onView(withId(R.id.signUpEditPsConfirm)).perform(replaceText(testPassword))
        onView(withId(R.id.signUpEditPhone)).perform(replaceText(testPhone))


    }

    @Test
    fun checkFindBtnClick(){
        onView(withId(R.id.signUpBtnFindAddress)).perform(click())
    }

    @Test
    fun checkSubmit(){

        onView(withId(R.id.signUpEditId)).perform(replaceText(testId))
        onView(withId(R.id.signUpEditAdressDetail)).perform(replaceText(testDetailAddress))
        onView(withId(R.id.signUpEditPs)).perform(replaceText(testPassword))
        onView(withId(R.id.signUpEditPsConfirm)).perform(replaceText(testPassword))
        onView(withId(R.id.signUpEditPhone)).perform(replaceText(testPhone))
        onView(withText(R.id.signUpTxtAddress)).perform(replaceText(testAddress))
        intentsRule.activity.viewModel.zipCode = "12312"

//        onView(withText(R.id.signUpBtnSubmit)).perform(click())
    }
}