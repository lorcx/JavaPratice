package guava;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TypeTokenTest {
    public static void main(String[] args) {
        TypeToken<String> stringToken = TypeToken.of(String.class);

        TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {};

        TypeToken<Map<?, ?>> wildMapTok = new TypeToken<Map<?, ?>>() {
        };

        mapToken(TypeToken.of(String.class), TypeToken.of(BigInteger.class));

        TypeToken<Map<Integer, Queue<String>>> token = mapToken(TypeToken.of(Integer.class), new TypeToken<Queue<String>>(){});
        System.out.println(token.getType());
        System.out.println(token.getRawType());

    }

    static<K,V> TypeToken<Map<K,V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return new TypeToken<Map<K, V>>() {}
        .where(new TypeParameter<K>(){}, keyToken)
        .where(new TypeParameter<V>(){}, valueToken);
    }
}
