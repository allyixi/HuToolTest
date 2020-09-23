package Util;

import cn.hutool.core.text.UnicodeUtil;
import org.junit.Test;

public class UnicodeUtilTest {
    // Unicode编码转换工具
    @Test
    public void test01() {
        // 字符串转Unicode符
        //第二个参数true表示跳过ASCII字符（只跳过可见字符）
        String s = UnicodeUtil.toUnicode("aaa123中文", true);
        // aaa123\u4e2d\u6587
        System.out.println(s);

        // Unicode转字符串
        String str = "aaa\\U4e2d\\u6587\\u111\\urtyu\\u0026";
        String res = UnicodeUtil.toString(str);
        // 非Unicode字符串，原样输出
        System.out.println(res);
    }
}
