package br.com.jeancarlos.calc.calculadora;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@SuppressWarnings("SpellCheckingInspection")
@RunWith(AndroidJUnit4.class)
public class CalculadoraTest {

    ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        activityActivityTestRule.launchActivity(new Intent());
    }

    // Testa adição 1 + 2  = 3
    @Test
    public void calculateSum() throws Exception {
        onView(withId(R.id.button_one))
                .perform(click());

        onView(withId(R.id.button_sum))
                .perform(click());

        onView(withId(R.id.button_two))
                .perform(click());

        onView(withId(R.id.button_result))
                .perform(click());

        onView(withId(R.id.text_view_result))
                .check(matches(withText("3")));
    }


    // Testa subtração 4 - 2 = 2
    @Test
    public void calculateSub() throws Exception {
        onView(withId(R.id.button_four))
                .perform(click());

        onView(withId(R.id.button_sub))
                .perform(click());

        onView(withId(R.id.button_two))
                .perform(click());

        onView(withId(R.id.button_result))
                .perform(click());

        onView(withId(R.id.text_view_result))
                .check(matches(withText("2")));
    }


    // Testa multiplicação 3 * 2 = 6
    @Test
    public void calculateMult() throws Exception {
        onView(withId(R.id.button_three))
                .perform(click());

        onView(withId(R.id.button_mult))
                .perform(click());

        onView(withId(R.id.button_two))
                .perform(click());

        onView(withId(R.id.button_result))
                .perform(click());

        onView(withId(R.id.text_view_result))
                .check(matches(withText("6")));
    }
}
