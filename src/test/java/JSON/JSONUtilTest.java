package JSON;

import bean.testBean;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JSONUtilTest {
    // JSONUtil是针对JSONObject和JSONArray的静态快捷方法集合

    // String转JSONObject
    @Test
    public void test01() {
        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        // 方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        // 方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);

        // JSONObject转String
        String str = jsonObject.toString();
        System.out.println(str);
        // JSONObject转String，格式化，自动换行
        String prettyStr = jsonObject.toStringPretty();
        System.out.println(prettyStr);
    }

    // Bean转JSONObject
    @Test
    public void test02() {
        testBean testBean = new testBean();
        testBean.setName("xiaoming");
        testBean.setAge(18);
        testBean.setGender("male");
        // false表示不跳过空值
        JSONObject jsonObject3 = JSONUtil.parseObj(testBean, false);
        System.out.println(jsonObject3.toStringPretty());
        // 保持有序
        JSONObject json4 = JSONUtil.parseObj(testBean, false, true);
        System.out.println(json4.toStringPretty());

        // 默认日期为毫秒，想格式化使用json.setDateFormat("yyyy-MM-dd HH:mm:ss");

        // JSONObject转Bean
        testBean = JSONUtil.toBean(json4, bean.testBean.class);
    }

    // Map对象转JSONObject
    @Test
    public void test03() {
        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        JSONObject jsonObject = JSONUtil.parseFromMap(map);
        System.out.println(jsonObject.toString());
    }

    // XML、ResourceBundle转JSONObject
    @Test
    public void test04() {
        // XML字符串
        // 使用JSONUtil.parseFromXml方法
        // JSONObject转XML
        // JSONUtil.toXmlStr
        // ResourceBundle
        // 使用JSONUtil.parseFromResourceBundle
    }
}
