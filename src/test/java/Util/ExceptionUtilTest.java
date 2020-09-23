package Util;

import org.junit.Test;

public class ExceptionUtilTest {
    @Test
    public void test01() {
        // wrap 包装一个异常为指定类型异常
        // wrapRuntime 使用运行时异常包装编译异常
        // getCausedBy 获取由指定异常类引起的异常
        // isCausedBy 判断是否由指定异常类引起
        // stacktraceToString 堆栈转为完整字符串
    }

    @Test
    public void test02() {
        // DependencyException 依赖异常
        // StatefulException 带有状态码的异常
        // UtilException 工具类异常
        // NotInitedException 未初始化异常
        // ValidateException 验证异常
    }
}
