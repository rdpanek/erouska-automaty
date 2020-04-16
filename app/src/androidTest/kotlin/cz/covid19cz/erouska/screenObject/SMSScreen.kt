package cz.covid19cz.erouska.screenObject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSubstring
import cz.covid19cz.erouska.R
import cz.covid19cz.erouska.screenObject.PhoneNumberScreen.PHONE_NUMBER

object SMSScreen {
    private const val SMS_CODE = "000000"

    fun typeSMSCode() {
        onView(withId(R.id.phone_number_code)).check(matches(withSubstring(PHONE_NUMBER)))
        onView(withId(R.id.login_verif_code_input)).perform(typeText(SMS_CODE), closeSoftKeyboard())
    }

    fun verifySMSCode() {
        onView(withId(R.id.login_verif_code_send_btn)).perform(click())
    }
}