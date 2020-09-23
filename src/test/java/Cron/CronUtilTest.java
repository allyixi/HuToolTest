package Cron;

import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.junit.Test;

public class CronUtilTest {
    // CronUtil通过一个全局的定时任务配置文件，实现统一的定时任务调度。

    @Test
    public void test01() {
        // 配置文件
        // 对于Maven项目，首先在src/main/resources/config下放入cron.setting文件（默认是这个路径的这个文件），然后在文件中放入定时规则，规则如下：
        //
        // # 我是注释
        // [com.company.aaa.job]
        // TestJob.run = */10 * * * *
        // TestJob2.run = */10 * * * *
        // Copy to clipboardErrorCopied
        // 中括号表示分组，也表示需要执行的类或对象方法所在包的名字，这种写法有利于区分不同业务的定时任务。
        //
        // TestJob.run表示需要执行的类名和方法名（通过反射调用，不支持Spring和任何框架的依赖注入），*/10 * * * *表示定时任务表达式，此处表示每10分钟执行一次，以上配置等同于：
        //
        // com.company.aaa.job.TestJob.run = */10 * * * *
        // com.company.aaa.job.TestJob2.run = */10 * * * *

        // 启动
        CronUtil.start();
        // 使用deamon模式，
        CronUtil.start(true);
        // 关闭
        CronUtil.stop();
        // 秒匹配和年匹配
        CronUtil.setMatchSecond(true);
        // 动态添加定时任务
        CronUtil.schedule("*/2 * * * * *", new Task() {
            @Override
            public void execute() {
                Console.log("Task excuted.");
            }
        });

        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }
}
