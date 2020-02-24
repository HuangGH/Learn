package mode.策略模式;

/**
 * @author hgh 2019-09-26 19:45
 */
public class isNumeric implements ValidationStrategy {
    public static void main(String[] args) {
        System.out.println(new isNumeric().execute("234"));
    }

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
