package Covert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Convert类中大部分方法为toXXX，参数为Object，可以实现将任意可能的类型转换为指定类型。同时支持第二个参数defaultValue用于在转换失败时返回一个默认值。
 */
public class ConverTest {

    // 转换为字符串
    @Test
    public void test01() {
        // 基本类型转字符串
        float a = 1;
        String aStr = Convert.toStr(a);
        // aStr 1.0

        // 数组转字符串
        long[] b = {1, 2, 3, 4, 5};
        String bStr = Convert.toStr(b);
        // bStr [1, 2, 3, 4, 5]
    }

    // 转换为数组
    @Test
    public void test02() {
        // 不同数组类型转换
        // 字符串数组转Integer数组
        String[] b = {"1", "2", "3", "4"};
        Integer[] intArray = Convert.toIntArray(b);

        long[] c = {1, 2, 3, 4, 5};
        // long类型数组转Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
    }

    // 转换日期
    @Test
    public void test03() {
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println(value);
        // long可以 String不行
        long b = 1597143123141l;
        Date value2 = Convert.toDate(b);
    }

    // 转换为集合
    @Test
    public void test04(){
        Object[] a = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(a);
    }

    // 半角和全角的转换
    @Test
    public void test05(){
        // 半角转全角
        String a = "123456789";
        // 结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);

        // 全角转半角
        String b = "１２３４５６７８９";
        // 结果为"123456789"
        String dbc = Convert.toDBC(b);
    }

    // 16进制转换
    @Test
    public void test06(){
        // 字符串转16进制 注意是字符串转，不是数值类型
        String a="1";
        // 结果是31 1的ASCII码是49 转成16进制是31
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);

        // 16进制转字符串
        String hex2="31";
        // 结果是1
        String a2=Convert.hexToStr(hex2,CharsetUtil.CHARSET_UTF_8);
    }

    // Unicode和字符串转换
    @Test
    public void test07(){
        String a = "我是一个小小的可爱的字符串";
        // 结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
        // 结果为："我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
    }

    // 编码转换
    @Test
    public void test08(){
        String a = "我不是乱码";
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        Assert.assertEquals(raw, a);
    }

    // 时间单位转换
    @Test
    public void test09(){
        // Convert.convertTime(要转换的数据,从什么时间格式(举例：毫秒)z,转成什么时间格式(举例：分钟))
        long a = 4535345;
        //结果为：75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
    }

    // 金额大小写转换
    @Test
    public void test10(){
        double a = 67556.32;
        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
    }

    // 原始类和包装类转换
    @Test
    public void test11(){
        // 去包装
        Class<?> wrapClass = Integer.class;
        // 结果为：int.class
        Class<?> unWraped = Convert.unWrap(wrapClass);
        // 包装
        Class<?> primitiveClass = long.class;
        // 结果为：Long.class
        Class<?> wraped = Convert.wrap(primitiveClass);
    }

    //
}
