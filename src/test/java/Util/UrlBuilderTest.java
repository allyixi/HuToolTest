package Util;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilderTest {
    @Test
    public void test01() throws MalformedURLException {
        // URL url = new URL("www.hutool.cn");

        // 输出 http://www.hutool.cn/
        String buildUrl = UrlBuilder.create().setHost("www.hutool.cn").build();

        // https://www.hutool.cn/aaa/bbb?ie=UTF-8&wd=test
        String buildUrl2 = UrlBuilder.create()
                .setScheme("https")
                .setHost("www.hutool.cn")
                .addPath("/aaa").addPath("bbb")
                .addQuery("ie", "UTF-8")
                .addQuery("wd", "test")
                .build();

        // 当参数中有中文时，自动编码中文，默认UTF-8编码，也可以调用setCharset方法自定义编码。
        // https://www.hutool.cn/s?ie=UTF-8&ie=GBK&wd=%E6%B5%8B%E8%AF%95
        String buildUrl3 = UrlBuilder.create()
                .setScheme("https")
                .setHost("www.hutool.cn")
                .addPath("/s")
                .addQuery("ie", "UTF-8")
                .addQuery("ie", "GBK")
                .addQuery("wd", "测试")
                .build();

        // 当有一个URL字符串时，可以使用of方法解析：
        UrlBuilder builder = UrlBuilder.ofHttp("www.hutool.cn/aaa/bbb/?a=张三&b=%e6%9d%8e%e5%9b%9b#frag1", CharsetUtil.CHARSET_UTF_8);
        // 输出张三
        System.out.println(builder.getQuery().get("a"));
        // 输出李四
        System.out.println(builder.getQuery().get("b"));

        // 特殊URL解析
        String urlStr = "https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&amp;mid=100000465&amp;idx=1";
        UrlBuilder builder2 = UrlBuilder.ofHttp(urlStr, CharsetUtil.CHARSET_UTF_8);
        // https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&mid=100000465&idx=1
        System.out.println(builder.build());
    }
}
