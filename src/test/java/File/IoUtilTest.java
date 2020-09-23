package File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.file.Tailer;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;


public class IoUtilTest {

    // 拷贝
    @Test
    public void test01() {
        BufferedInputStream in = FileUtil.getInputStream("/Users/lixinyu/lxy/test/a.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("/Users/lixinyu/lxy/test/b.txt");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
    }

    // Stream转Reader、Writer
    @Test
    public void test02() {
//        IoUtil.getReader：将InputStream转为BufferedReader用于读取字符流，它是部分readXXX方法的基础。
//        IoUtil.getWriter：将OutputStream转为OutputStreamWriter用于写入字符流，它是部分writeXXX的基础。
//        IoUtil.close(流对象);
    }

    // 读文件
    // readBytes()
    // readString()
    // readLines()
    @Test
    public void test03() {
        // 默认UTF-8编码，可以在构造中传入第二个参数做为编码
        // 注意：FileReader是cn.hutool.core.io.file.FileReader不是java.io中的
        FileReader fileReader = new FileReader("/Users/lixinyu/lxy/test/a.txt");
        String result = fileReader.readString();
        System.out.println(result);
    }

    // 写文件
    @Test
    public void test04() {
        // 全覆盖write()
        // 注意：FileWriter是cn.hutool.core.io.file.FileReader不是java.io中的
        FileWriter writer = new FileWriter("/Users/lixinyu/lxy/test/a.txt");
        writer.write("test");
        // 追加append()
        writer.append("0234");
    }

    // 文件追加
    @Test
    public void test05() {
        // 在内存中积累一定量的数据后统一追加到文件
        // 积累长度为FileAppender第二个参数capacity
        File file = FileUtil.file("/Users/lixinyu/lxy/test/a.txt");
        FileAppender appender = new FileAppender(file, 16, true);
        appender.append("123");
        appender.append("abc");
        appender.append("xyz");
        FileReader fileReader = new FileReader("/Users/lixinyu/lxy/test/a.txt");
        String result = fileReader.readString();
        // 此时还没有写入因为写入的长度没有达到capacity
        System.out.println(result);
        // 调用flush()直接写入
        appender.flush();
    }

    // 将文件修改的内容进行处理(打印或者其他)
    // public static class ConsoleLineHandler implements LineHandler {
    //    @Override
    //    public void handle(String line) {
    //        Console.log(line);
    //    }
    //}
    @Test
    public void test06() {
        Tailer tailer = new Tailer(FileUtil.file("/Users/lixinyu/lxy/test/a.txt"), Tailer.CONSOLE_HANDLER, 2);
        tailer.start();
    }
}
