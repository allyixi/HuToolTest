package Crypto;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

public class SymmetricCryptoTest {
    // 对称加密-SymmetricCrypto
    // 对称加密(也叫私钥加密)指加密和解密使用相同密钥的加密算法。

    // DESede实现
    @Test
    public void test01() {
        String content = "test中文";
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);
        // 加密
        byte[] encrypt = des.encrypt(content);
        System.out.println(new String(encrypt));
        // 解密
        byte[] decrypt = des.decrypt(encrypt);
        System.out.println(new String(decrypt));
        // 加密为16进制字符串（Hex表示）
        String encryptHex = des.encryptHex(content);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = des.decryptStr(encryptHex);
        System.out.println(decryptStr);
    }

    // AES实现
    @Test
    public void test02() {
        String content = "test中文";
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        AES aes = SecureUtil.aes(key);
        // 加密
        byte[] encrypt = aes.encrypt(content);
        System.out.println(new String(encrypt));
        // 解密
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(new String(decrypt));
        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);

        // 自定义模式和偏移
        AES aes2 = new AES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "0102030405060708".getBytes());
    }

    // DES实现
    @Test
    public void test03() {
        String content = "test中文";
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        // 构建
        DES des = SecureUtil.des(key);
        // 加密
        byte[] encrypt = des.encrypt(content);
        System.out.println(new String(encrypt));
        // 解密
        byte[] decrypt = des.decrypt(encrypt);
        System.out.println(new String(decrypt));
        // 加密为16进制表示
        String encryptHex = des.encryptHex(content);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = des.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);

        // 自定义模式和偏移
        DES des2 = new DES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "01020304".getBytes());
    }

    // 国产加密算法SM4
    //  <dependency>
    //      <groupId>org.bouncycastle</groupId>
    //      <artifactId>bcpkix-jdk15on</artifactId>
    //      <version>1.60</version>
    //  </dependency>
    @Test
    public void test04() {
        String content = "test中文";
        SymmetricCrypto sm4 = new SymmetricCrypto("SM4");
        String encryptHex = sm4.encryptHex(content);
        System.out.println(encryptHex);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }
}
