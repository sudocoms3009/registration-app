package com.example.facultyhandbook;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CardViewTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void cardViewTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.commerce),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                1)));
        cardView.perform(scrollTo(), click());

        pressBack();

        ViewInteraction cardView2 = onView(
                allOf(withId(R.id.engineering),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                2)));
        cardView2.perform(scrollTo(), click());

        pressBack();

        ViewInteraction cardView3 = onView(
                allOf(withId(R.id.health),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                3)));
        cardView3.perform(scrollTo(), click());

        pressBack();

        ViewInteraction cardView4 = onView(
                allOf(withId(R.id.humanity),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scroll),
                                        0),
                                4)));
        cardView4.perform(scrollTo(), click());

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
