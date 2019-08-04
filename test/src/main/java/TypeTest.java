import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hgh 2019-06-30 22:31 获取List泛型
 */
public class TypeTest {


	public static void main(String[] args) throws NoSuchMethodException {
		TypeTest typeTest = new TypeTest();
		Method method = typeTest.getClass().getMethod("getList");

		// 返回字段类型
		Class<?> returnType = method.getReturnType();
		//返回一个 Type 对象，它表示此 Field 对象所表示字段的声明类型。
		//如果 Type 是一个参数化类型，则返回的 Type 对象必须准确地反映源代码中使用的实际类型参数。
		//如果底层字段的类型是一个类型变量或者是一个参数化类型，则创建它。否则将解析它。
		Class<?>[] classes = returnType.getInterfaces();
		boolean b = Stream.of(classes).anyMatch(List.class::isAssignableFrom);
		//isAssignableFrom 判断是否为某个类的子类
		if (returnType.isAssignableFrom(List.class) || returnType.isAssignableFrom(ArrayList.class)) {
			Type type = method.getGenericReturnType();
			Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
			System.out.println(trueType);
		}
	}

	public List<User> getList() {
		LinkedList<User> users = new LinkedList<>();
		return users;
	}

	class User {

		String name;
	}
}
