package Util;

import cn.hutool.core.text.StrSpliter;
import org.junit.Test;

import java.util.List;

public class StrSpliterTest {
    //
    @Test
    public void test01() {
        String str1 = "a, ,efedsfs,   ddf";
        // 参数：被切分字符串，分隔符逗号，0表示无限制分片数，去除两边空格，忽略空白项
        List<String> split = StrSpliter.split(str1, ',', 0, true, true);
    }
}
