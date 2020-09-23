package File;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

public class FileTypeUtilTest {

    // 预置文件的类型与前n个byte的十六进制 返回文件类型
    // 注意 xlsx、docx本质上是各种XML打包为zip的结果，因此会被识别为zip格式。
    @Test
    public void test01(){
        File file = FileUtil.file("/Users/lixinyu/lxy/images/line.jpg");
        //输出 jpg
        String type = FileTypeUtil.getType(file);
        System.out.println(type);

        // 通过添加文件n个byte的十六进制与文件类型的映射扩展识别的范围
        // 越长越精准
        FileTypeUtil.putFileType("ffd8ffe000104a464946", "新类型");
    }
}
