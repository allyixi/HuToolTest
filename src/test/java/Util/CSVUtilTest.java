package Util;

import bean.testBean;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CSVUtilTest {

    // 读取为CsvRow
    @Test
    public void test01() {
        CsvReader reader = CsvUtil.getReader();
        // 从文件中读取CSV数据
        CsvData data = reader.read(new File("test.csv"));
        List<CsvRow> rows = data.getRows();
        // 遍历行
        for (CsvRow csvRow : rows) {
            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
            System.out.println(csvRow.getRawList());
        }
    }

    // 读取为Bean列表
    // 如果csv中标题与字段不对应，可以使用alias注解设置别名
    // @Alias("姓名")
    @Test
    public void test02() {
        final CsvReader reader = CsvUtil.getReader();
        // 假设csv文件在classpath目录下
        final List<testBean> result = reader.read(ResourceUtil.getUtf8Reader("test_bean.csv"), testBean.class);
    }

    // 生成CSV文件
    @Test
    public void test03() {
        // 指定路径和编码
        CsvWriter writer = CsvUtil.getWriter("e:/testWrite.csv", CharsetUtil.CHARSET_UTF_8);
        // 按行写出
        writer.write(
                new String[]{"a1", "b1", "c1"},
                new String[]{"a2", "b2", "c2"},
                new String[]{"a3", "b3", "c3"}
        );
    }
}
