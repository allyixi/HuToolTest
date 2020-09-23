package Office;

import bean.testBean;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelWriterTest {
    // Excel有读取也便有写出，Hutool针对将数据写出到Excel做了封装。

    // 将行列对象写出到Excel
    @Test
    public void test01() {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeTest.xlsx");
        // 通过构造方法创建writer
        // ExcelWriter writer = new ExcelWriter("d:/writeTest.xls");
        // 跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(row1.size() - 1, "测试标题");
        // 一次性写出内容，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
    }

    // 写出Map数据
    @Test
    public void test02() {
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());
        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(rows.size() - 1, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
    }

    // 写出Bean数据
    @Test
    public void test03() {
        testBean bean = new testBean();
        bean.setName("xm");
        bean.setAge(18);
        bean.setGender("male");
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(4, "一班成绩单");
        // 一次性写出内容，使用默认样式，强制输出标题
        // writer.write(rows, true);
        // 关闭writer，释放内存
        writer.close();
    }

    // 写出到流
    @Test
    public void test04(){
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 创建xlsx格式的
        // ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出内容，使用默认样式，强制输出标题
        // writer.write(rows, true);
        // out为OutputStream，需要写出到的目标流
        // writer.flush(out);
        // 关闭writer，释放内存
        writer.close();
    }

    // 写出到客户端下载（写出到Servlet）
    @Test
    public void test05(){
        // 写出xls
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        // writer.write(rows, true);
        // out为OutputStream，需要写出到的目标流
        // response为HttpServletResponse对象
        // response.setContentType("application/vnd.ms-excel;charset=utf-8");
        // test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        // response.setHeader("Content-Disposition","attachment;filename=test.xls");
        // ServletOutputStream out=response.getOutputStream();
        // writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        // IoUtil.close(out);

       // 写出xlsx
        ExcelWriter writer2 = ExcelUtil.getWriter(true);
        // writer.write(rows, true);
        // response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        // response.setHeader("Content-Disposition","attachment;filename=test.xlsx");
        // writer.flush(out, true);
        writer.close();
        // IoUtil.close(out);
    }

    // 对于大量数据输出，采用ExcelWriter容易引起内存溢出，因此有了BigExcelWriter，使用方法与ExcelWriter完全一致。
    @Test
    public void test06(){
        List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd", DateUtil.date(), 3.22676575765);
        List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", DateUtil.date(), 250.7676);
        List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2", DateUtil.date(), 0.111);
        List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3", DateUtil.date(), 35);
        List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4", DateUtil.date(), 28.00);
        List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        BigExcelWriter writer= ExcelUtil.getBigWriter("e:/xxx.xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(rows);
        // 关闭writer，释放内存
        writer.close();
    }
}
