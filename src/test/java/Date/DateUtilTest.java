package Date;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilTest {

    // Date、long、Calendar之间的相互转换
    @Test
    public void test01() {
        // 当前时间
        Date date = DateUtil.date();
        // Calendar转Date
        Date date2 = DateUtil.date(Calendar.getInstance());
        // 毫秒long转Date
        Date date3 = DateUtil.date(System.currentTimeMillis());
        // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
    }

    // 字符串转日期
    @Test
    public void test02() {
        // 自动识别一些格式的字符串时间
        // 支持格式：
        // yyyy-MM-dd HH:mm:ss
        // yyyy-MM-dd
        // HH:mm:ss
        // yyyy-MM-dd HH:mm
        // yyyy-MM-dd HH:mm:ss.SSS
        String dateStr = "2017-03-01 12:21:32";
        Date date = DateUtil.parse(dateStr);
        // 或者指定格式转时间
        String dateStr2 = "03-2017-01";
        Date date2 = DateUtil.parse(dateStr2, "MM-yyyy-dd");
        System.out.println(date2);
    }

    // 格式化日期输出
    @Test
    public void test03() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        // 结果 2017/03/01 指定格式化
        String format = DateUtil.format(date, "yyyy/MM/dd");
        // 常用格式的格式化，结果：2017-03-01 默认格式化
        String formatDate = DateUtil.formatDate(date);
        // 结果：2017-03-01 00:00:00 时间戳
        String formatDateTime = DateUtil.formatDateTime(date);
        // 结果：00:00:00 只取时间
        String formatTime = DateUtil.formatTime(date);
    }

    // 获取Date对象的某个部分
    @Test
    public void test04() {
        Date date = DateUtil.date();
        // 获得年的部分
        DateUtil.year(date);
        // 获得月份，从0开始计数 要加1
        DateUtil.month(date);
        System.out.println(DateUtil.month(date));
        // 获得月份枚举
        DateUtil.monthEnum(date);
    }

    // 开始和结束时间
    @Test
    public void test05() {
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        // 一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        // 一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
    }

    // 日期时间偏移
    @Test
    public void test06() {
        String dateStr = "2017-02-27 22:33:23";
        Date date = DateUtil.parse(dateStr);
        // 结果：2017-03-01 22:33:23 月份自动匹配和进位 指定偏移对象
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println(newDate);
        // 常用偏移，结果：2017-03-02 22:33:23
        Date newDate2 = DateUtil.offsetDay(date, 3);
        System.out.println(newDate2);
        // 常用偏移，结果：2017-02-27 19:33:23
        Date newDate3 = DateUtil.offsetHour(date, -3);
        System.out.println(newDate3);
    }

    // 整日、周、月偏移
    @Test
    public void test07() {
        // 昨天
        DateUtil.yesterday();
        // 明天
        DateUtil.tomorrow();
        // 上周
        DateUtil.lastWeek();
        // 下周
        DateUtil.nextWeek();
        // 上个月
        DateUtil.lastMonth();
        // 下个月
        DateUtil.nextMonth();
    }

    // 计算日期时间差
    @Test
    public void test08() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        // 相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        // 相差4周
        long betweenWeek = DateUtil.between(date1, date2, DateUnit.WEEK);
        System.out.println(betweenWeek);
        // 格式化时间
        // Level.MINUTE表示精确到分
        // 输出：31天1小时
        String formatBetween = DateUtil.formatBetween(betweenDay, BetweenFormater.Level.MINUTE);
    }

    // 计时器
    @Test
    public void test09() {
        TimeInterval timer = DateUtil.timer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 花费毫秒数
        System.out.println(timer.interval());
        // 返回花费时间，并重置开始时间
        System.out.println(timer.intervalRestart());
        // 花费分钟数
        System.out.println(timer.intervalMinute());
    }

    // 计算年龄
    @Test
    public void test10() {
        // 年龄
        DateUtil.ageOfNow("1992-08-06");
        // 是否闰年
        DateUtil.isLeapYear(2017);
    }
}
