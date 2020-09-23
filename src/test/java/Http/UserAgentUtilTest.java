package Http;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import org.junit.Test;

public class UserAgentUtilTest {
    // User Agent中文名为用户代理，简称 UA，它是一个特殊字符串头，使得服务器能够识别客户使用的操作系统及版本、浏览器及版本、浏览器渲染引擎等。
    @Test
    public void test01() {
        String uaStr = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1";
        UserAgent ua = UserAgentUtil.parse(uaStr);
        ua.getBrowser().toString();// Chrome
        ua.getVersion();// 14.0.835.163
        ua.getEngine().toString();// Webkit
        ua.getEngineVersion();// 535.1
        ua.getOs().toString();// Windows 7
        ua.getPlatform().toString();// Windows
        // 判断终端是否为移动终端
        ua.isMobile();
    }
}
