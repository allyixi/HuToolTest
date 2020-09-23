package Date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.Month;
import org.junit.Test;

import java.util.Date;

public class DateTimeTest {
    // 可由Date、Calendar、String、long声明
    // DateTime对象声明
    @Test
    public void test01() {
        Date date = new Date();
        // new方式创建
        DateTime time = new DateTime(date);
        // of方式创建
        DateTime now = DateTime.now();
        DateTime dt = DateTime.of(date);
    }

    // 使用DateTime对象
    @Test
    public void test02() {
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        // 年，结果：2017
        int year = dateTime.year();
        // 月份，结果：Month.JANUARY
        Month month = dateTime.monthEnum();
        // 日，结果：5
        int day = dateTime.dayOfMonth();
    }

    // 是否改变原值
    @Test
    public void test03() {
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        // 默认情况下DateTime为可变对象，此时offset == dateTime
        DateTime offset = dateTime.offset(DateField.YEAR, 0);
        // 设置为不可变对象后变动将返回新对象，此时offset != dateTime 克隆了
        dateTime.setMutable(false);
        offset = dateTime.offset(DateField.YEAR, 0);
    }

    // 格式化为字符串
    @Test
    public  void test04(){
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        // 结果：2017-01-05 12:34:23
        String dateStr = dateTime.toString();
        System.out.println(dateStr);
    }
}
