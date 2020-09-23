package Office;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ExcelReaderTest {
    // 读取Excel内容的封装，通过构造ExcelReader对象，指定被读取的Excel文件、流或工作簿，然后调用readXXX方法读取内容为指定格式。

    @Test
    public void test01() {
        // 读取Excel中所有行和列，都用列表表示
        ExcelReader reader = ExcelUtil.getReader("/Users/lixinyu/Downloads/资料/代码量统计.xlsx");
        List<List<Object>> readAll = reader.read();

        // 读取为Map列表，默认第一行为标题行，Map中的key为标题，value为标题对应的单元格值。
        ExcelReader reader2 = ExcelUtil.getReader("/Users/lixinyu/Downloads/资料/代码量统计.xlsx");
        List<Map<String,Object>> readAll2 = reader2.readAll();

        // 读取为Bean列表，Bean中的字段名为标题，字段值为标题对应的单元格值。
        // ExcelReader reader = ExcelUtil.getReader("d:/aaa.xlsx");
        // List<Person> all = reader.readAll(Person.class);
    }
}
