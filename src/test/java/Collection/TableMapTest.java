package Collection;

import cn.hutool.core.map.TableMap;
import org.junit.Test;

import java.io.File;
import java.util.*;

public class TableMapTest {
    // 这类数据结构，通过键值单独建立List方式，使键值对一一对应，实现正向和反向两种查找。
    //当然，这种Map无论是正向还是反向，都是遍历列表查找过程，相比标准的HashMap要慢，数据越多越慢。

    @Test
    public void test01(){
        TableMap<String, Integer> tableMap = new TableMap<>(2);
        tableMap.put("aaa", 111);
        tableMap.put("bbb", 222);
        // 111
        tableMap.get("aaa");
        System.out.println(tableMap.get("aaa"));
        // 222
        tableMap.get("bbb");
        // aaa
        tableMap.getKey(111);
        // bbb
        tableMap.getKey(222);
        // [111]
        tableMap.getValues("aaa");
        //[aaa]
        tableMap.getKeys(111);
    }
}
