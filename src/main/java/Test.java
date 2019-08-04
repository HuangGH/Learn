/**
 * @author hgh 2019-06-17 15:21
 */
public class Test {

	public static String test() {
		try {
			System.out.println("return 1");
			return "1";
		} catch (Exception e) {
			return "2";
		} finally {
			System.out.println("return 3");
			return "3";
		}
	}

	public static void main(String[] args) {
		System.out.println(test());
	}
}
