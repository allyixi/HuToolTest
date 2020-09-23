package Util;

import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrayUtilTest {

    @Test
    public void test01() {
        // 合并数组
        String[] a = {"a"};
        String[] b = {"b"};
        a = ArrayUtil.addAll(a, b);
        // 2
        System.out.println(a.length);
    }

    @Test
    public void test02() {
        // 克隆数组
        Integer[] b = {1, 2, 3};
        Integer[] cloneB = ArrayUtil.clone(b);

        int[] a = {1, 2, 3};
        int[] clone = ArrayUtil.clone(a);

        // 过滤
        Integer[] a1 = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(a1, new Editor<Integer>() {
            public Integer edit(Integer t) {
                return (t % 2 == 0) ? t : null;
            }
        });
        Assert.assertArrayEquals(filter, new Integer[]{2, 4, 6});

        // 两个数组对应组成Map
        String[] keys = {"a", "b", "c"};
        Integer[] values = {1, 2, 3};
        Map<String, Integer> map = ArrayUtil.zip(keys, values, true);
    }
}
