package Util;

import cn.hutool.core.util.URLUtil;
import org.junit.Test;

public class URLUtilTest {
    @Test
    public void test01(){
        // 自动补齐http:// 加上标准化
        String url = "www.hutool.cn//aaa/\\bbb?a=1&b=2";
        String normalize = URLUtil.normalize(url);
        // 输出 http://www.hutool.cn/aaa/bbb?a=1&b=2
        System.out.println(normalize);
    }
}
