package System;

import cn.hutool.system.SystemUtil;
import org.junit.Test;

public class SystemUtilTest {
    @Test
    public void test01() {
        // Java Virtual Machine Specification信息
        SystemUtil.getJvmSpecInfo();

        // Java Virtual Machine Implementation信息
        SystemUtil.getJvmInfo();

        // Java Specification信息
        SystemUtil.getJavaSpecInfo();

        // Java Implementation信息
        SystemUtil.getJavaInfo();

        // Java运行时信息
        SystemUtil.getJavaRuntimeInfo();

        // 系统信息
        SystemUtil.getOsInfo();

        // 用户信息
        SystemUtil.getUserInfo();

        // 当前主机网络地址信息
        SystemUtil.getHostInfo();

        // 运行时信息，包括内存总大小、已用大小、可用大小等
        SystemUtil.getRuntimeInfo();
    }
}
