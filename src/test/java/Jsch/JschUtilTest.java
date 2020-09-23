package Jsch;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import org.junit.Test;

public class JschUtilTest {
    // 引入jsch
    // <dependency>
    //    <groupId>com.jcraft</groupId>
    //    <artifactId>jsch</artifactId>
    //    <version>0.1.54</version>
    // </dependency>

    @Test
    public void test01() {
        // ssh连接到远程主机
        //新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
        Session session = JschUtil.getSession("10.1.1.1", 22, "test", "123456");

        //新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
        Session session2 = JschUtil.getSession("10.1.1.1", 22, "test", "123456");
        // 将堡垒机保护的内网8080端口映射到localhost，我们就可以通过访问http://localhost:8080/访问内网服务了
        JschUtil.bindPort(session, "172.20.12.123", 8080, 8080);

        // 其它方法
        // generateLocalPort 生成一个本地端口（从10001开始尝试，找到一个未被使用的本地端口）
        // unBindPort 解绑端口映射
        // openAndBindPortToLocal 快捷方法，将连接到跳板机和绑定远程主机端口到本地使用一个方法搞定
        // close 关闭SSH会话
    }
}
