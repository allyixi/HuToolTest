package Util;

import cn.hutool.core.util.RuntimeUtil;
import org.junit.Test;

import java.util.List;

public class RuntimeUtilTest {
    @Test
    public void test01(){
        // 执行命令行语句
        RuntimeUtil.exec("ls");
        // 执行系统命令，返回字符串
        String str = RuntimeUtil.execForStr("ipconfig");
        // 执行系统命令，返回行列表
        List str2 = RuntimeUtil.execForLines("ipconfig");
    }
}
