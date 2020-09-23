package Extension;

import cn.hutool.core.codec.BCD;
import org.junit.Test;

public class BCDTest {
    // BCD码这种编码形式利用了四个位元来储存一个十进制的数码，使二进制和十进制之间的转换得以快捷的进行
    @Test
    public void test01(){
        String strForTest = "123456ABCDEF";
        // 转BCD
        byte[] bcd = BCD.strToBcd(strForTest);
        // 解码BCD
        String str = BCD.bcdToStr(bcd);
    }
}
