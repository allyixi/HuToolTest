package Collection;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CollUtilTest {
    @Test
    public void test01() {
        // 将数组转成字符串，中间填充字符
        String[] col= new String[]{"a","b","c","d","e"};
        List<String> colList = Arrays.asList(col);
        // a#b#c#d#e
        String str = CollUtil.join(colList, "#");
        // abcde
        String str2 = CollUtil.join(colList,"");
        System.out.println(str2);
    }

    @Test
    public void test02(){
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        // 新建三个列表，CollUtil.newArrayList方法表示新建ArrayList并填充元素
        List<Integer> list1 = CollUtil.newArrayList(1, 2, 3);
        List<Integer> list2 = CollUtil.newArrayList(4, 5, 6);
        List<Integer> list3 = CollUtil.newArrayList(7, 8, 9);
        // 参数表示把list1,list2,list3合并并按照从小到大排序后，取0~2个（包括第0个，不包括第2个），结果是[1,2]
        @SuppressWarnings("unchecked")
        List<Integer> result = CollUtil.sortPageAll(0, 5, comparator, list1, list2, list3);
        System.out.println(result);     //输出 [1,2]
    }

    @Test
    public void test03(){
        // 将多个数据合并成一个数组
        // CollUtil.addAll()

        // zip
        String a = "a,b,c";
        String b = "1,2,3";
        Map<String, String> map2 = CollUtil.zip(a,b, ",");
        System.out.println(map2);   // {b=2, c=3, a=1}
    }
}
