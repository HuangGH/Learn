package jackson;

//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonNode;
//import org.apache.commons.lang3.EnumUtils;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;

/**
 * 反序列化
 *
 * @author hgh 2019-12-03 09:52
 */
public class EnumDeserializer {

}


//public class EnumDeserializer extends JsonDeserializer<Enum> {
//
//    @Override
//    public Enum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
//        String result = null;
//        JsonNode node = jp.getCodec().readTree(jp);
//        if (node != null && node.size() > 0) {
//            result = node.get("key").asText();
//        }
//        Field field = findField(jp.getCurrentName(), jp.getCurrentValue().getClass());
//        Class javaType = field.getType();
//        // 跳过当前object fixme 需要修改
//        jp.nextFieldName();
//        return EnumUtils.getEnum(javaType,result);
//    }
//
//    private Field findField(String name, Class<?> c) {
//        for (; c != null; c = c.getSuperclass()) {
//            for (Field field : c.getDeclaredFields()) {
//                if (Modifier.isStatic(field.getModifiers())) {
//                    continue;
//                }
//                if (field.getName().equals(name)) {
//                    return field;
//                }
//            }
//        }
//        return null;
//    }
//}
