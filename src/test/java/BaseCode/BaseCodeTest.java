package BaseCode;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base62;
import cn.hutool.core.codec.Base64;
import org.junit.Test;

public class BaseCodeTest {
    // Base62编码
    @Test
    public void test01() {
        String a = "伦家是一个非常长的字符串66";
        // 17vKU8W4JMG8dQF8lk9VNnkdMOeWn4rJMva6F0XsLrrT53iKBnqo
        String encode = Base62.encode(a);
        System.out.println(encode);
        // 还原为a
        String decodeStr = Base62.decodeStr(encode);
        System.out.println(decodeStr);
    }

    // Base64编码
    @Test
    public void test02() {
        String a = "伦家是一个非常长的字符串";
        // 5Lym5a625piv5LiA5Liq6Z2e5bi46ZW/55qE5a2X56ym5Liy
        String encode = Base64.encode(a);
        System.out.println(encode);
        // 还原为a
        String decodeStr = Base64.decodeStr(encode);
        System.out.println(decodeStr);
    }

    // Base32编码
    @Test
    public void test03() {
        String a = "伦家是一个非常长的字符串";
        // 4S6KNZNOW3TJRL7EXCAOJOFK5GOZ5ZNYXDUZLP7HTKCOLLMX46WKNZFYWI
        String encode = Base32.encode(a);
        System.out.println(encode);
        // 还原为a
        String decodeStr = Base32.decodeStr(encode);
        System.out.println(decodeStr);
    }
}
