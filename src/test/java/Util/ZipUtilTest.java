package Util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import org.junit.Test;

import java.io.File;

public class ZipUtilTest {

    // zip
    @Test
    public void test01(){
        // 将所择目录或文件压缩成.zip
        ZipUtil.zip("d:/aaa");
        // 将aaa目录下的所有文件目录打包到d:/bbb/目录下的ccc.zip文件中
        ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip");
        // true压缩时带目录 false压缩不带目录，
        ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip", true);
        // 选择文件压缩成zip
        ZipUtil.zip(FileUtil.file("d:/bbb/ccc.zip"), false,
                FileUtil.file("d:/test1/file1.txt"),
                FileUtil.file("d:/test1/file2.txt"),
                FileUtil.file("d:/test2/file1.txt"),
                FileUtil.file("d:/test2/file2.txt")
        );
        // 解压zip
        //将test.zip解压到e:\\aaa目录下，返回解压到的目录
        File unzip = ZipUtil.unzip("E:\\aaa\\test.zip", "e:\\aaa");
    }

    // Gzip
    // 用于网页传输
    @Test
    public void test02(){
        ZipUtil.gzip(FileUtil.file("d://test"));
        // ZipUtil.unGzip();
    }

    // Zlib
    @Test
    public void test03(){
        // ZipUtil.zlib 压缩，可压缩字符串，也可压缩文件 ZipUtil.unZlib 解压zlib文件
    }
}
