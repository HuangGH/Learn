import bean.person.Address;
import bean.person.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author by hgh
 * @description java.util.optional
 * @date 2019-05-30 18:23
 */
public class Cmain {

    @Test
    public void testGuavaOptional() {
        Person person = new Person();
        person.setAddress(Address.builder().city("quanzhou").build());
        Optional<Person> personOptional = Optional.ofNullable(person);
        String city = personOptional.map(Person::getAddress)
                .map(Address::getCity)
                .filter("quan"::equals).orElse(null);
        System.out.println(city);
    }

    @Test
    public void convertTest() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);
    }

    @Test
    public void convertTest2() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toList());//注意发生的变化
        System.out.println(collected);
    }
}
