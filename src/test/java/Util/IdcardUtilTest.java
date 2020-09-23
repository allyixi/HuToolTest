package Util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import org.junit.Test;

public class IdcardUtilTest {
    // 该工具类来验证身份证信息 现在支持大陆15位、18位身份证，港澳台10位身份证。
    // isValidCard 验证身份证是否合法
    // convert15To18 身份证15位转18位
    // getBirthByIdCard 获取生日
    // getAgeByIdCard 获取年龄
    // getYearByIdCard 获取生日年
    // getMonthByIdCard 获取生日月
    // getDayByIdCard 获取生日天
    // getGenderByIdCard 获取性别
    // getProvinceByIdCard 获取省份
    @Test
    public void test01(){
        String ID_18 = "321083197812162119";
        String ID_15 = "150102880730303";

        // 是否有效
        boolean valid = IdcardUtil.isValidCard(ID_18);
        boolean valid15 = IdcardUtil.isValidCard(ID_15);

        // 转换
        String convert15To18 = IdcardUtil.convert15To18(ID_15);

        // 年龄
        DateTime date = DateUtil.parse("2017-04-10");
        int age = IdcardUtil.getAgeByIdCard(ID_18, date);
        int age2 = IdcardUtil.getAgeByIdCard(ID_15, date);

        // 生日
        String birth = IdcardUtil.getBirthByIdCard(ID_18);
        String birth2 = IdcardUtil.getBirthByIdCard(ID_15);

        // 省份
        String province = IdcardUtil.getProvinceByIdCard(ID_18);
        String province2 = IdcardUtil.getProvinceByIdCard(ID_15);
    }
}
