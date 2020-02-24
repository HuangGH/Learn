import java.util.Map;

/**
 * @author hgh
 * @since 2020-02-19 00:09
 */
public class DozerUtilsTest {

    public static void main(String[] args) {

        Person person = new Person();

        Map result = DozerUtils.transform(Map.class, person);
        System.out.println(result);
    }

    static class Person {
        private String name = "hgh";
        private Integer id = 1;
        private Boolean isMan = true;
        private String test;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Boolean getMan() {
            return isMan;
        }

        public void setMan(Boolean man) {
            isMan = man;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

    }


}
