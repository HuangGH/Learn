package lambda;

/**
 * @author hgh 2019-09-05 17:51
 */
public interface ApplePredicate {

    boolean test(Apple apple);

    default ApplePredicate negate() {
        return (t) -> !test(t);
    }
}
