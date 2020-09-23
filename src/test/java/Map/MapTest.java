package Map;

import cn.hutool.core.map.CaseInsensitiveLinkedMap;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.map.MapUtil;
import org.junit.Test;

import java.util.Map;

public class MapTest {
    @Test
    public void test01(){
        // CaseInsensitiveMap 忽略大小写的Map,对KEY忽略大小写，get("Value")和get("value")获得的值相同
        Map<String,String> map=new CaseInsensitiveMap();
        // CaseInsensitiveLinkedMap 忽略大小写的LinkedHashMap,对KEY忽略大小写，get("Value")和get("value")获得的值相同
        Map<String,String> map2=new CaseInsensitiveLinkedMap();

        MapUtil.getInt(map,"");
        // Map的键和值互换
        MapUtil.reverse(map);
        // 排序Map
        MapUtil.sort(map);
    }
}
