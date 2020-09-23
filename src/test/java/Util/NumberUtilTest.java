package Util;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;
import org.junit.Test;


public class NumberUtilTest {
    @Test
    public void test01() {
        // 以上四种运算都会将double转为BigDecimal后计算，解决float和double类型无法进行精确计算的问题。这些方法常用于商业计算
        // NumberUtil.add 针对double类型做加法
        // NumberUtil.sub 针对double类型做减法
        // NumberUtil.mul 针对double类型做乘法
        // NumberUtil.div 针对double类型做除法，并提供重载方法用于规定除不尽的情况下保留小数位数和舍弃方式。

        // NumberUtil.round(数，保留几位)
        double te1=123456.123456;
        double te2=123456.128456;
        System.out.println(NumberUtil.round(te1,3));
        System.out.println(NumberUtil.round(te2,2));
        // NumberUtil.roundStr 方法主要封装String.format方法,舍弃方式采用四舍五入。

        // 整形
        long c=299792458;
        // 0 -> 取一位整数
        // 0.00 -> 取一位整数和两位小数
        // 00.000 -> 取两位整数和三位小数
        // # -> 取所有整数部分
        // #.##% -> 以百分比方式计数，并取两位小数
        // #.#####E0 -> 显示为科学计数法，并取五位小数
        // ,### -> 每三位以逗号进行分隔，例如：299,792,458
        // 光速大小为每秒,###米 -> 将格式嵌入文本
        String format = NumberUtil.decimalFormat(",###", c);//299,792,458

        // NumberUtil.isNumber 是否为数字
        // NumberUtil.isInteger 是否为整数
        // NumberUtil.isDouble 是否为浮点数
        // NumberUtil.isPrimes 是否为质数

        // 随机数
        // NumberUtil.generateRandomNumber 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组。
        // NumberUtil.generateBySet 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组。

        // 内置函数
        // NumberUtil.factorial 阶乘
        // NumberUtil.sqrt 平方根
        // NumberUtil.divisor 最大公约数
        // NumberUtil.multiple 最小公倍数
        // NumberUtil.getBinaryStr 获得数字对应的二进制字符串
        // NumberUtil.binaryToInt 二进制转int
        // NumberUtil.binaryToLong 二进制转long
        // NumberUtil.compare 比较两个值的大小
        // NumberUtil.toStr 数字转字符串，自动并去除尾小数点儿后多余的0
    }

}
