package Alin;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {

    @Factory
    public static <T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t) {
        return new LessThanOrEqual(t);
    }

    private final Comparable<T> expectedValue;

    public LessThanOrEqual(T expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" less than or equal(<=) " + expectedValue);
    }

    @Override
    public boolean matches(Object t) {
        int compareTo = expectedValue.compareTo((T) t);
        return compareTo > -1;
    }

}