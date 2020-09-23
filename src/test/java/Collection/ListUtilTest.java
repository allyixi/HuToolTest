package Collection;

import cn.hutool.core.collection.ListUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListUtilTest {

    @Test
    public void test01() {
        // 过滤or批处理or条件处理
        List<String > list= Arrays.asList(new String[]{"1", "2", "3"});
        List<String> filter = ListUtil.filter(list, str -> "edit" + str);
        System.out.println(filter);
    }
}
