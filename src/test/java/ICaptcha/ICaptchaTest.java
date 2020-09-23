package ICaptcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Console;
import org.apache.tools.ant.taskdefs.Copy;
import org.junit.Test;

public class ICaptchaTest {

    // 线段干扰的验证码
    @Test
    public void test01(){
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");//输出code
        Console.log(lineCaptcha.getCode());
        // 验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
        // 重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
        // 新的验证码
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
    }

    // 圆圈干扰验证码
    @Test
    public void test02(){
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        // CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/circle.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    // 圆圈干扰验证码
    @Test
    public void test03(){
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        // CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/circle.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    //  扭曲干扰验证码
    @Test
    public void test04(){
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        // ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/shear.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");
    }

    // 写出到浏览器（Servlet输出）
    @Test
    public void test05(){
        // ICaptcha captcha = ...;
        // captcha.write(response.getOutputStream());
        // Servlet的OutputStream记得自行关闭哦！
    }

    // 自定义验证码
    @Test
    public void test06(){
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        // captcha.setGenerator(randomGenerator);
        // 重新生成code
        // captcha.createCode();

        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
        // 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());
        // 重新生成code
        captcha.createCode();
    }
}
