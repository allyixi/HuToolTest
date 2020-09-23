package Office;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtilTest {

    // 需要导入Office操作的依赖
    // <dependency>
    //    <groupId>org.apache.poi</groupId>
    //    <artifactId>poi-ooxml</artifactId>
    //    <version>4.1.2</version>
    // </dependency>

    @Test
    public void test01(){
        // 从文件中读取Excel为ExcelReader
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("/Users/lixinyu/Downloads/资料/代码量统计.xlsx"));
        List list=new ArrayList();
        list=reader.readRow(0);
        System.out.println(list.get(0));

        // 流中读取Excel为ExcelReader（比如从ClassPath中读取Excel文件）
        ExcelReader reader2 = ExcelUtil.getReader(ResourceUtil.getStream("aaa.xlsx"));

        // 读取指定的sheet
        ExcelReader reader3;
        //通过sheet编号获取
        reader3 = ExcelUtil.getReader(FileUtil.file("test.xlsx"), 0);
        //通过sheet名获取
        reader3 = ExcelUtil.getReader(FileUtil.file("test.xlsx"), "sheet1");

        // 读取大数据量的Excel
        ExcelUtil.readBySax("aaa.xlsx", 0, createRowHandler());
    }

    private RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int i, long l, List<Object> list) {
                Console.log("[{}] [{}] {}", i, l, list);
            }
        };
    }
}
