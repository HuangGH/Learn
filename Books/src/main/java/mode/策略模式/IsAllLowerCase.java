package mode.策略模式;

/**
 * @author hgh 2019-09-26 19:44
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
