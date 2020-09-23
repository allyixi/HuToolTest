package JSON;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

public class JSONArrayTest {
    // JSONArray: ["value1","value2","value3"]

    @Test
    public void test01() {
        // 方法1
        JSONArray array1 = JSONUtil.createArray();
        // 方法2
        JSONArray array2 = new JSONArray();
        array1.add("value1");
        array1.add("value2");
        array1.add("value3");
        // 转为JSONArray字符串
        array1.toString();
    }

    @Test
    public void test02() {
        // String转JSONArray
        String jsonStr = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array = JSONUtil.parseArray(jsonStr);
    }
}
