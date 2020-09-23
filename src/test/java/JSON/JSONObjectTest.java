package JSON;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

public class JSONObjectTest {

    @Test
    public void test01() {
        // 创建JSONObject
        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");
    }
}
