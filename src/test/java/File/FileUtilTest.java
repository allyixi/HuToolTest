package File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilTest {

    // 文件中追加写入 校验
    @Test
    public void test01() {
        // 可指定文件对象或文件路径
        // 字符串追加写入
        FileUtil.appendString("aaaa", "/Users/lixinyu/lxy/test/b.txt", CharsetUtil.UTF_8);
        List strlist = new ArrayList();
        strlist.add("1111");
        strlist.add("2222");
        // 列表追加写入
        FileUtil.appendLines(strlist, "/Users/lixinyu/lxy/test/b.txt", CharsetUtil.UTF_8);
    }

    // 文件操作
    @Test
    public void test02() {
        // 清空文件夹
        // 清空文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹，某个文件删除失败会终止删除操作
        FileUtil.clean("/Users/lixinyu/lxy/test");
        // 删除空的文件夹，不空的不删
        FileUtil.cleanEmpty(new File("/Users/lixinyu/lxy/test"));
        // 复制文件或目录 第三个参数为是否覆盖
        // 1、src和dest都为目录，则将src目录及其目录下所有文件目录拷贝到dest下
        // 2、src和dest都为文件，直接复制，名字为dest
        // 3、src为文件，dest为目录，将src拷贝到dest目录下
        FileUtil.copy("src", "dest", true);
        // 删除文件或文件夹
        // 删除文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹
        FileUtil.del(new File("aaa"));
        // 指定文件改动时间
        FileUtil.lastModifiedTime("aaaa");
        // 递归遍历目录以及子目录中的所有文件 返回文件列表
        FileUtil.loopFiles("aaa");
        // 列出目录文件 返回文件数组
        FileUtil.ls("aaaa");
        // 创建文件夹，会递归自动创建其不存在的父文件夹，如果存在直接返回此文件夹
        FileUtil.mkdir("aaaa");
        // 创建所给文件或目录的父目录
        FileUtil.mkParentDirs("aaaa");
        // 移动文件或者目录 源文件 目的文件 是否复写
        FileUtil.move(new File("src"),new File("dest"),true);
        // 创建File对象，相当于调用new File()，不做任何处理
        FileUtil.newFile("aaa");
        // 修改文件或目录的文件名，不变更路径，只是简单修改文件名
        FileUtil.rename(new File("aaa"),"bbbb",true);
    }

    // 文件校验、比较
    @Test
    public void test03() {
        // crc32校验
        System.out.println(FileUtil.checksumCRC32((new File("/Users/lixinyu/lxy/test/b.txt"))));
        // 文件名中是否包含非法字符 \ / : * ? " < > |
        FileUtil.containsInvalid("abc.txt");
        // 清除文件名非法字符 \ / : * ? " < > |
        FileUtil.cleanInvalid("abc.txt");
        // 比较文件内容是否相同
        // 先比较长度再比较内容
        FileUtil.contentEquals(new File("1"), new File("2"));
        // 检查两个文件对象是否指向同一个文件或文件夹
        FileUtil.equals(new File("1"), new File("2"));
        // 校验文件是否存在
        FileUtil.exist("aaa");
        // 是否为目录
        FileUtil.isDirectory("aaaa");
        // 目录是否为空
        FileUtil.isDirEmpty(new File("aaa"));
        // 文件是否为空 目录：里面没有文件时为空 文件：文件大小为0时为空
        FileUtil.isEmpty(new File("aaa"));
        FileUtil.isNotEmpty(new File("aaaa"));
        // 判断是否为文件
        FileUtil.isFile("aaa");
        // 判断文件是否被改动 第二个参数为上次改动时间
        FileUtil.isModifed(new File("aaaa"), System.currentTimeMillis());
        // 给定文件或目录的最后修改时间是否晚于给定时间
        FileUtil.newerThan(new File("aaa"),System.currentTimeMillis());
        // 判断文件路径是否有指定后缀，忽略大小写
        FileUtil.pathEndsWith(new File("aaa"),"txt");
        // 计算目录或文件的总大小
        FileUtil.size(new File("aaa"));
        // 创建文件及其父目录，如果这个文件存在，直接返回这个文件
        FileUtil.touch(new File("aaaa"));

    }

    // 文件名操作
    @Test
    public void test04() {
        // 获取文件扩展名（后缀名），扩展名不带“.”
        FileUtil.extName("aaa.txt");
        FileUtil.getSuffix("aaa.txt");
        // 获取当前系统的换行分隔符
        FileUtil.getLineSeparator();
        // 根据文件扩展名获得MimeType
        FileUtil.getMimeType("aaa.txt");
        // 返回文件名
        FileUtil.getName("aaa.txt");
        // 获取指定层级的父路径
        // 0->aaaaa/bbbbb/c.txt 1->aaaaa/bbbbb
        FileUtil.getParent("aaaaa/bbbbb/c.txt", 0);
        // 返回文件名（去掉后缀）
        FileUtil.getPrefix("/Users/lixinyu/lxy/vue.js");
        // 获取用户目录
        FileUtil.getUserHomeDir();
        // 获取用户路径（绝对路径）
        FileUtil.getUserHomePath();
        // 是否为window系统
        FileUtil.isWindows();
        // 获得最后一个文件路径分隔符的位置
        FileUtil.lastIndexOfSeparator("aaa");
    }

    // 文件流
    @Test
    public void test05() throws FileNotFoundException {
        // 输入流
        FileUtil.getInputStream(new File("aaa"));
        // 输出流
        FileUtil.getOutputStream("aaa.txt");
        // 文件读取器
        FileUtil.getReader("aaa.txt", "utf-8");
        FileUtil.getUtf8Reader("aaa.txt");
        // Writer
        FileUtil.getWriter("aaa.txt", "utf-8", true);
        // byte[]
        FileUtil.readBytes("aaa");
        // 读取文件内容
        FileUtil.readString(new File("aaaa"),"utf-8");
        // 返回列表
        FileUtil.readUtf8Lines(new File("aaa"));
        // 写数据 byte[]
        FileUtil.writeBytes(new byte[]{}, new File("aaa"));
        // 流写入
        FileUtil.writeFromStream(new FileInputStream(new File("a")),new File("bbb"));
        // 将列表写入文件 第四个是否覆盖
        FileUtil.writeLines(new ArrayList<String >(),"aaaa","utf-8",true);
        // 将文件写入流
        FileUtil.writeToStream(new File("src"),new FileOutputStream(new File("b")));
    }

    @Test
    public void test06() {
        System.out.println(FileUtil.getUserHomePath());
    }

}
