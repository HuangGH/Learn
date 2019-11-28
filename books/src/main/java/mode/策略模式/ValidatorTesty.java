package mode.策略模式;

/**
 * @author hgh 2019-09-27 11:18
 */
public class ValidatorTesty {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new isNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");


        Validator numericValidator1 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b_1 = numericValidator1.validate("aaaa");
        Validator lowerCaseValidator2 = new Validator(s -> s.matches("\\d+"));
        boolean b_2 = lowerCaseValidator2.validate("bbbb");
    }
}
