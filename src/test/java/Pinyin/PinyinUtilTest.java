package Pinyin;

import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.extra.pinyin.engine.pinyin4j.Pinyin4jEngine;
import org.junit.Test;

public class PinyinUtilTest {
    // TinyPinyin 拼音库
    // <dependency>
    //    <groupId>io.github.biezhi</groupId>
    //    <artifactId>TinyPinyin</artifactId>
    //    <version>2.0.3.RELEASE</version>
    // </dependency>

    // JPinyin 拼音库
    // <dependency>
    //    <groupId>com.github.stuxuhai</groupId>
    //    <artifactId>jpinyin</artifactId>
    //    <version>1.1.8</version>
    // </dependency>

    // Pinyin4j 拼音库
    // <dependency>
    //    <groupId>com.belerweb</groupId>
    //    <artifactId>pinyin4j</artifactId>
    //    <version>2.5.1</version>
    // </dependency>

    @Test
    public void test01() {
        // 获取拼音
        String pinyin = PinyinUtil.getPinyin("你好", " ");
        // "ni hao"
        System.out.println(pinyin);

        // 获取拼音首字母
        String result = PinyinUtil.getFirstLetter("H是第一个", ", ");
        // "h, s, d, y, g"
        System.out.println(result);

        // 自定义拼音库（拼音引擎）
        Pinyin4jEngine engine = new Pinyin4jEngine();
        // "ni hao h"
        String pinyin2 = engine.getPinyin("你好h", " ");
    }
}
