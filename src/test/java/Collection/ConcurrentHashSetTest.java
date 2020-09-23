package Collection;

import cn.hutool.core.collection.ConcurrentHashSet;
import org.junit.Test;

import java.util.Set;

public class ConcurrentHashSetTest {

    // DK提供了线程安全的HashMap：ConcurrentHashMap，但是没有提供对应的ConcurrentHashSet，Hutool借助ConcurrentHashMap封装了线程安全的ConcurrentHashSet。
    @Test
    public void test01(){
        Set<String> set = new ConcurrentHashSet<>();
        set.add("a");
        set.add("b");
    }
}
