package Http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestTest {
    @Test
    public void test01() {
        // 链式构建请求
        String url = "";
        Map paramMap = new HashMap();
        String result1 = HttpRequest.post(url)
                .header(Header.USER_AGENT, "Hutool http")// 头信息，多个头信息多次调用此方法即可
                .form(paramMap)// 表单内容
                .timeout(20000)// 超时，毫秒
                .execute().body();
        Console.log(result1);

        // Restful请求
        String json = "...";
        String result2 = HttpRequest.post(url)
                .body(json)
                .execute().body();

        // 指定请求头
        // 自定义Cookie（cookie方法）
        // 指定是否keepAlive（keepAlive方法）
        // 指定表单内容（form方法）
        // 指定请求内容，比如rest请求指定JSON请求体（body方法）
        // 超时设置（timeout方法）
        // 指定代理（setProxy方法）
        // 指定SSL协议（setSSLProtocol）
        // 简单验证（basicAuth方法）
    }
}
