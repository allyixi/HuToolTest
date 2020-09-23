package Util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.Test;

public class HexUtilTest {

    @Test
    public void test01() {
        String str = "我是一个字符串";
        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        // e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2
        System.out.println(hex);
        // 我是一个字符串
        String decodedStr = HexUtil.decodeHexStr(hex);
    }
}
