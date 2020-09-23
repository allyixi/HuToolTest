package Util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.text.StrBuilder;
import org.junit.Test;

public class StrBuilderTest {

    // StrBuilder和StringBuilder使用方法基本一致，只是多了reset方法可以重新构建一个新的字符串而不必开辟新内存。
    // 生成新的字符串需要重新构建StringBuilder对象，造成性能损耗和内存浪费，因此Hutool提供了可复用的StrBuilder。
    // 性能几乎翻倍
    @Test
    public void test01() {
        StrBuilder builder = StrBuilder.create();
        // 结果：aaa你好r
        builder.append("aaa").append("你好").append('r');
    }

    // 性能测试
    @Test
    public void test02() {
        //StrBuilder
        TimeInterval timer2 = DateUtil.timer();
        StrBuilder builder = StrBuilder.create();
        for (int i = 0; i < 1000000; i++) {
            builder.append("test");
            builder.reset();
        }
        System.out.println("StrBuilder完成时间:" + timer2.interval());
        //StringBuilder
        TimeInterval timer = DateUtil.timer();
        StringBuilder b2 = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            b2.append("test");
            b2 = new StringBuilder();
        }
        System.out.println("StringBuilder完成时间:" + timer.interval());
    }
}
