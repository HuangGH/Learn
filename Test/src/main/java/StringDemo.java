import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hgh
 * @since 2020-02-19 17:54
 */
public class StringDemo {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = StringDemo.class.getClassLoader().getResourceAsStream("text");
        List<String> lists = IOUtils.readLines(inputStream, "utf-8");
        if (lists.get(0).contains("VALUES_IF")) {
            for (String str : lists) {
                // VALUES_IF("customer_id", "#{customerId}", !StringUtils.isEmpty(aadharLiteV2VerCallback.getCustomerId()));
                str = str.trim().replaceAll("VALUES_IF", "VALUES");
                String condition = str.substring(str.indexOf(", !"), str.indexOf(");"));
                String text = str.replace(condition, "");
                condition = condition.replace(", ", "");
                String result = String.format("if(%s){%s}", condition, text);
                System.out.println(result);
            }
        } else {
            for (String str : lists) {
                // VALUES_IF("customer_id", "#{customerId}", !StringUtils.isEmpty(aadharLiteV2VerCallback.getCustomerId()));
                str = str.trim().replaceAll("SET_IF", "SET");
                String condition = str.substring(str.indexOf(", "), str.indexOf(");"));
                String text = str.replace(condition, "");
                condition = condition.replace(", ", "");
                String result = String.format("if(%s){%s}", condition, text);
                System.out.println(result);
            }

        }


    }
}
