package Script;

import cn.hutool.script.ScriptRuntimeException;
import cn.hutool.script.ScriptUtil;
import org.junit.Test;

import javax.script.CompiledScript;
import javax.script.ScriptException;

public class ScriptUtilTest {

    @Test
    public void test01() {
        // ScriptUtil.eval 执行Javascript脚本，参数为脚本字符串。
        ScriptUtil.eval("print('Script test!');");

        // ScriptUtil.compile 编译脚本，返回一个CompiledScript对象
        CompiledScript script = ScriptUtil.compile("print('Script test!');");
        try {
            script.eval();
        } catch (ScriptException e) {
            throw new ScriptRuntimeException(e);
        }
    }
}
