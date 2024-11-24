package delaadrian.lambda.exercises.ex13;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }
}
