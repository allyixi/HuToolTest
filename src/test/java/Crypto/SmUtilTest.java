package Crypto;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

import java.security.KeyPair;

public class SmUtilTest {
    // 国产加密算法

    // 非对称加密SM2
    @Test
    public void test01() {
        // 使用随机生成的密钥对加密或解密
        String text = "我是一段测试aaaa";
        SM2 sm2 = SmUtil.sm2();
        // 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(text, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));

        // 使用自定义密钥对加密或解密
        String text2 = "我是一段测试aaaa";
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();
        SM2 sm21 = SmUtil.sm2(privateKey, publicKey);
        // 公钥加密，私钥解密
        String encryptStr2 = sm21.encryptBcd(text2, KeyType.PublicKey);
        String decryptStr2 = StrUtil.utf8Str(sm21.decryptFromBcd(encryptStr, KeyType.PrivateKey));
    }

    // 摘要加密算法SM3
    @Test
    public void test02() {
        String digestHex = SmUtil.sm3("aaaaa");
    }

    // 对称加密SM4
    @Test
    public void test03() {
        String content = "test中文";
        SymmetricCrypto sm4 = SmUtil.sm4();
        String encryptHex = sm4.encryptHex(content);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    }
}
