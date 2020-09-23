package Crypto;

import cn.hutool.crypto.digest.*;
import org.junit.Test;

public class SummaryCryptoTest {
    // 摘要加密-Digester和HMac
    // 这种算法的特点是：无论用户输入什么长度的原始数据，经过计算后输出的密文都是固定长度的
    // 但是，由于输出的密文是提取原数据经过处理的定长值，所以它已经不能还原为原数据，即消息摘要算法是不可逆的，理论上无法通过反向运算取得原数据内容，因此它通常只能被用来做数据完整性验证。

    // Digester
    @Test
    public void test01() {
        String testStr = "123";
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String digestHex = md5.digestHex(testStr);
    }

    // HMac
    @Test
    public void test02() {
        String testStr = "test中文";
        byte[] key = "password".getBytes();
        HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);
        String macHex1 = mac.digestHex(testStr);
    }

    // SM3
    // <dependency>
    //      <groupId>org.bouncycastle</groupId>
    //      <artifactId>bcpkix-jdk15on</artifactId>
    //      <version>1.60</version>
    // </dependency>
    @Test
    public void test03() {
        Digester digester = DigestUtil.digester("sm3");
        String digestHex = digester.digestHex("aaaaa");
    }
}
