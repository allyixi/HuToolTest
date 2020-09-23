package Extension;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Dict;
import org.junit.Test;

public class DictTest {
    // 类似HashMap的数据结构，以及存储多个泛型的value
    @Test
    public void test01() {
        Dict dict = Dict.create()
                .set("key1", 1)//int
                .set("key2", 1000L)//long
                .set("key3", DateTime.now());
        long value2=dict.getLong("key2");
        System.out.println(value2);
    }
}
