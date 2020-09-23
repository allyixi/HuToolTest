package QrCode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Test;

import java.awt.*;

public class QrCodeUtilTest {
    // zxing依赖
    // <dependency>
    //    <groupId>com.google.zxing</groupId>
    //    <artifactId>core</artifactId>
    //    <version>3.3.3</version>
    // </dependency>
    @Test
    public void test01() {
        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("今天吃什么", 300, 300, FileUtil.file("/Users/lixinyu/Desktop/a.jpg"));
    }

    // 自定义参数
    @Test
    public void test02() {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
        QrCodeUtil.generate("http://hutool.cn/", config, FileUtil.file("/Users/lixinyu/Desktop/a.jpg"));
    }

    // 附带logo小图标
    @Test
    public void test03() {
        QrCodeUtil.generate(//
                "http://hutool.cn/", //二维码内容
                QrConfig.create().setImg("e:/logo_small.jpg"), //附带logo
                FileUtil.file("e:/qrcodeWithLogo.jpg")//写出到的文件
        );
    }

    // 调整纠错级别
    // 很多时候，二维码无法识别，这时就要调整纠错级别。
    // 纠错级别使用zxing的ErrorCorrectionLevel枚举封装，包括：L、M、Q、H几个参数，由低到高。
    // 低级别的像素块更大，可以远距离识别，但是遮挡就会造成无法识别。高级别则相反，像素块小，允许遮挡一定范围，但是像素块更密集。
    @Test
    public void test04() {
        QrConfig config = new QrConfig();
        // 高纠错级别
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        QrCodeUtil.generate("https://hutool.cn/", config, FileUtil.file("e:/qrcodeCustom.jpg"));
    }

    // 识别二维码
    @Test
    public void test05() {
        String decode = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
    }
}
