package Extra;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

import java.util.ArrayList;

public class MailUtilTest {
    // 引入依赖
    // <dependency>
    //    <groupId>javax.mail</groupId>
    //    <artifactId>mail</artifactId>
    //    <version>1.4.7</version>
    // </dependency>

    // 邮件服务器配置
    @Test
    public void test01() {
        // classpath（在标准Maven项目中为src/main/resources）的config目录下新建mail.setting文件，最小配置内容如下，在此配置下，smtp服务器和用户名都将通过from参数识别：
        // # 发件人（必须正确，否则发送失败）
        // from = hutool@yeah.net
        // # 密码（注意，某些邮箱需要为SMTP服务单独设置密码，详情查看相关帮助）
        // pass = q1w2e3
        // 完整配置
        // # 邮件服务器的SMTP地址，可选，默认为smtp.<发件人邮箱后缀>
        // host = smtp.yeah.net
        // # 邮件服务器的SMTP端口，可选，默认25
        // port = 25
        // # 发件人（必须正确，否则发送失败）
        // from = hutool@yeah.net
        // # 用户名，默认为发件人邮箱前缀
        // user = hutool
        // # 密码（注意，某些邮箱需要为SMTP服务单独设置授权码，详情查看相关帮助）
        // pass = q1w2e3
    }

    // 发送邮件
    @Test
    public void test02() {
        // 发送普通文本邮件，最后一个参数可选是否添加多个附件
        MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Hutool测试", false);

        // 发送HTML格式的邮件并附带附件，最后一个参数可选是否添加多个附件
        MailUtil.send("hutool@foxmail.com", "测试", "<h1>邮件来自Hutool测试</h1>", true, FileUtil.file("d:/aaa.xml"));

        // 群发邮件，可选HTML或普通文本，可选多个附件
        ArrayList<String> tos = CollUtil.newArrayList(
                "person1@bbb.com",
                "person2@bbb.com",
                "person3@bbb.com",
                "person4@bbb.com");
        MailUtil.send(tos, "测试", "邮件来自Hutool群发测试", false);

        // 参数
        // tos: 对方的邮箱地址，可以是单个，也可以是多个（Collection表示）
        // subject：标题
        // content：邮件正文，可以是文本，也可以是HTML内容
        // isHtml： 是否为HTML，如果是，那参数3识别为HTML内容
        // files： 可选：附件，可以为多个或没有，将File对象加在最后一个可变参数中即可
    }

    // 其他
    @Test
    public void test03() {
        // 自定义邮件服务器
        // 除了使用配置文件定义全局账号以外，MailUtil.send方法同时提供重载方法可以传入一个MailAccount对象，这个对象为一个普通Bean，记录了邮件服务器信息。
        MailAccount account = new MailAccount();
        account.setHost("smtp.yeah.net");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("hutool@yeah.net");
        account.setUser("hutool");
        account.setPass("q1w2e3");
        MailUtil.send(account, CollUtil.newArrayList("hutool@foxmail.com"), "测试", "邮件来自Hutool测试", false);

        // 使用SSL加密方式发送邮件 在使用QQ或Gmail邮箱时，需要强制开启SSL支持,只需修改配置文件即可
        // # 发件人（必须正确，否则发送失败），“小磊”可以任意变更，<>内的地址必须唯一，以下方式也对
        // # from = hutool@yeah.net
        // from = 小磊<hutool@yeah.net>
        // # 密码（注意，某些邮箱需要为SMTP服务单独设置密码，详情查看相关帮助）
        // pass = q1w2e3
        // # 使用SSL安全连接
        // sslEnable = true

        // 完整的配置文件如下：
        // # 邮件服务器的SMTP地址
        // host = smtp.yeah.net
        // # 邮件服务器的SMTP端口
        // port = 465
        // # 发件人（必须正确，否则发送失败）
        // from = hutool@yeah.net
        // # 用户名（注意：如果使用foxmail邮箱，此处user为qq号）
        // user = hutool
        // # 密码（注意，某些邮箱需要为SMTP服务单独设置密码，详情查看相关帮助）
        // pass = q1w2e3
        // #使用 STARTTLS安全连接，STARTTLS是对纯文本通信协议的扩展。
        // starttlsEnable = true
        //
        // # 使用SSL安全连接
        // sslEnable = true
        // # 指定实现javax.net.SocketFactory接口的类的名称,这个类将被用于创建SMTP的套接字
        // socketFactoryClass = javax.net.ssl.SSLSocketFactory
        // # 如果设置为true,未能创建一个套接字使用指定的套接字工厂类将导致使用java.net.Socket创建的套接字类, 默认值为true
        // socketFactoryFallback = true
        // # 指定的端口连接到在使用指定的套接字工厂。如果没有设置,将使用默认端口456
        // socketFactoryPort = 465
        //
        // # SMTP超时时长，单位毫秒，缺省值不超时
        // timeout = 0
        // # Socket连接超时值，单位毫秒，缺省值不超时
        // connectionTimeout = 0

        // 针对QQ邮箱和Foxmail邮箱的说明
        // QQ邮箱
        // pass = 你生成的授权码
        // Foxmail邮箱
        // host = smtp.qq.com
        // from = XXXX@foxmail.com
        // user = foxmail邮箱对应的QQ号码或者qq邮箱@前面部分
    }
}
