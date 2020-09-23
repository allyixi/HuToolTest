package Extension;

import cn.hutool.core.lang.Validator;
import org.junit.Test;

public class ValidatorTest {
    // 内置了一些常用校验，也可以自定义校验
    @Test
    public void test01(){
        // 内置校验，常用有邮箱、中文、ip等
        boolean isEmail = Validator.isEmail("loolly@gmail.com");
        // 自定义
        Validator.isMactchRegex("需要验证字段的正则表达式", "被验证内容");
        // 校验抛出异常 前面校验内容 后面异常返回值
        Validator.validateChinese("我是一段zhongwen", "内容中包含非中文");
    }
}
