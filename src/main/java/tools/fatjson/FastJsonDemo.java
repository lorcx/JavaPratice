package tools.fatjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * fastjson 学习
 *
 * @Author lx
 * @Date 2018/2/20 21:17
 */
public class FastJsonDemo {
    static User user = new User();

    static {
        user.setAge(10);
//        user.setName("double");
        user.setName("id");
        user.setCreateDate(new Date());
        user.setId(100);
    }

    public static void main(String[] args) {
        // 序列化
        String text = JSON.toJSONString(user);
        // {"age":10,"createDate":1519133232076,"id":1,"name":"double"}
        System.out.println(text);

        // 反序列化
        User user2 = JSON.parseObject("{\"age\":10,\"createDate\":1519133232076,\"id\":1,\"name\":\"double\"}", User.class);
        System.out.println(user2);

        // 转成list
        pasrseGeneric();
    }

    /**
     * 定制序列化：判断是否序列化
     */
    private void filter1() {
        // name 为对象属性的名称 value 为值
        PropertyFilter filter = (Object source, String name, Object value) -> {
            // 判断属性id的值是否为大于100，大于可以序列化
            if ("id".equals(name)) {
                int id = (Integer) value;
                return id >= 100;
            }
            return false;
        };

        // 定制序列化
        String text = JSON.toJSONString(user, filter);
        System.out.println("定制序列化" + text);
    }

    /**
     * 定制序列化：序列化时在最前添加内容
     */
    public void filter2() {
        BeforeFilter filter2 = new BeforeFilter() {
            @Override
            public void writeBefore(Object object) {
                User user = (User) object;
                user.setId(200);
            }
        };

        String text = JSON.toJSONString(user, filter2);
        System.out.println("定制序列化" + text);
    }

    /**
     * 转成list
     */
    private static void pasrseGeneric() {
        Type type = new TypeReference<List<User>>(){}.getType();
        String jsonStr = "[{\"id\":1},{\"id\":2}]";
        List<User> list = JSON.parseObject(jsonStr, type);
        System.out.println(list);
    }
}
