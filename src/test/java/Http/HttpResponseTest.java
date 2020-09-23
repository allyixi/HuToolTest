package Http;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.Test;

public class HttpResponseTest {
    @Test
    public void test01() {
        // Http状态码（getStatus方法）
        // 返回内容编码（contentEncoding方法）
        // 是否Gzip内容（isGzip方法）
        // 返回内容（body、bodyBytes、bodyStream方法）
        // 响应头信息（header方法）

        String url = "";
        // 获取响应状态码
        HttpResponse res = HttpRequest.post(url).execute();
        Console.log(res.getStatus());
        // 获取响应头信息
        HttpResponse res2 = HttpRequest.post(url).execute();
        // 预定义的头信息
        Console.log(res2.header(Header.CONTENT_ENCODING));
        // 自定义头信息
        Console.log(res2.header("Content-Disposition"));
    }
}
