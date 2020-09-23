package Util;

import cn.hutool.core.net.NetUtil;
import org.junit.Test;

public class NetUtilTest {
    // 在日常开发中，网络连接这块儿必不可少。日常用到的一些功能,隐藏掉部分IP地址、绝对相对路径的转换等等。
    // NetUtil 工具中主要的方法包括：
    // longToIpv4 根据long值获取ip v4地址
    // ipv4ToLong 根据ip地址计算出long型的数据
    // isUsableLocalPort 检测本地端口可用性
    // isValidPort 是否为有效的端口
    // isInnerIP 判定是否为内网IP
    // localIpv4s 获得本机的IP地址列表
    // toAbsoluteUrl 相对URL转换为绝对URL
    // hideIpPart 隐藏掉IP地址的最后一部分为 * 代替
    // buildInetSocketAddress 构建InetSocketAddress
    // getIpByHost 通过域名得到IP
    // isInner 指定IP的long是否在指定范围内

    @Test
    public void test01() {
        String ip = "127.0.0.1";
        long iplong = 2130706433L;
        // 根据long值获取ip v4地址
        String ip2 = NetUtil.longToIpv4(iplong);
        // 根据ip地址计算出long型的数据
        long ip3 = NetUtil.ipv4ToLong(ip);
        // 检测本地端口可用性
        boolean result = NetUtil.isUsableLocalPort(6379);
        // 是否为有效的端口
        boolean result2 = NetUtil.isValidPort(6379);
        // 隐藏掉IP地址
        String result3 = NetUtil.hideIpPart(ip);
    }
}
