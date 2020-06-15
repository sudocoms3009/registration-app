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
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DropDownGenRulesTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dropDownGenRulesTestScience() {
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("General Rules For Faculties"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.dropdown_science),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        appCompatImageView2.perform(scrollTo(), click());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.up_science),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        appCompatImageView3.perform(scrollTo(), click());


    }

    @Test
    public void dropDownGenRulesTestCommerce() {

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("General Rules For Faculties"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.dropdown_commerce),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        appCompatImageView10.perform(scrollTo(), click());

        ViewInteraction appCompatImageView11 = onView(
                allOf(withId(R.id.up_commerce),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        appCompatImageView11.perform(scrollTo(), click());

    }

    @Test
    public void dropDownGenRulesTestEngineer() {

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("General Rules For Faculties"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.perform(click());
        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.dropdown_engineering),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        appCompatImageView10.perform(scrollTo(), click());

        ViewInteraction appCompatImageView11 = onView(
                allOf(withId(R.id.up_engineering),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        appCompatImageView11.perform(scrollTo(), click());

    }

    @Test
    public void dropDownGenRulesTestHealth() {

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("General Rules For Faculties"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.dropdown_health),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        appCompatImageView10.perform(scrollTo(), click());

        ViewInteraction appCompatImageView11 = onView(
                allOf(withId(R.id.up_health),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        appCompatImageView11.perform(scrollTo(), click());

    }
    @Test
    public void dropDownGenRulesTestHumanities() {

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.dropdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.taskbar),
                                        0),
                                0)));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("General Rules For Faculties"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        textView.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.dropdown_humanities),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1)));
        appCompatImageView10.perform(scrollTo(), click());

        ViewInteraction appCompatImageView11 = onView(
                allOf(withId(R.id.up_humanities),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2)));
        appCompatImageView11.perform(scrollTo(), click());
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
