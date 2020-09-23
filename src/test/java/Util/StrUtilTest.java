package Util;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

public class StrUtilTest {
    // 判断是否为空
    @Test
    public void test01() {
        // StrUtil.isEmpty(str)
        // StrUtil.isNotEmpty(str)
        // StrUtil.isBlank(str)
        // StrUtil.isNotBlank(str)
        String s = " ";
        // 字符串是否为空
        // 返回true
        System.out.println(StrUtil.isEmpty(s));
        // 字符串是否都为空格、制表符、tab
        // 返回false
        System.out.println(StrUtil.isBlank(s));

        // StrUtil.hasBlank(str)
        // StrUtil.hasEmpty(str)
        System.out.println(StrUtil.hasBlank(s));
    }

    // 去掉前缀、后缀
    @Test
    public void test02() {
        // 字符串去掉后面匹配的部分
        // removeSuffixIgnoreCase 忽略大小写
        System.out.println(StrUtil.removeSuffix("aaa.jpg", ".jpg"));
        // 字符串去掉前面匹配的部分
        // removePrefixIgnoreCase 忽略大小写
        System.out.println(StrUtil.removePrefix("aaa.jpg", "aaa"));
    }

    // 截取字符串
    // 支持前后位置颠倒、负值、越界处理
    @Test
    public void test03() {
        String str = "abcdefgh";
        // strSub1 -> c
        String strSub1 = StrUtil.sub(str, 2, 3);
        // 负值 strSub2 -> cde
        String strSub2 = StrUtil.sub(str, 2, -3);
        // 前后位置颠倒 strSub2 -> c
        String strSub3 = StrUtil.sub(str, 3, 2);
        // 自动处理越界 strSub4 -> defgh
        String strSub4 =StrUtil.sub(str, 3, str.length()+1);
    }

    // format
    @Test
    public void test04(){
        String template = "{}爱{}，就像老鼠爱大米";
        //str -> 我爱你，就像老鼠爱大米
        String str = StrUtil.format(template, "我", "你");
    }
}
