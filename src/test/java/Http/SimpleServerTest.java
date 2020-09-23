package Http;

import cn.hutool.core.net.multipart.UploadFile;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

public class SimpleServerTest {
    @Test
    public void test01() {
        // 启动一个Http服务非常简单
        HttpUtil.createServer(8888).start();

        // 处理简单请求
        HttpUtil.createServer(8888)
                .addAction("/", (req, res) -> {
                    res.write("Hello Hutool Server");
                })
                .start();

        // 访问简单的文件服务器
        HttpUtil.createServer(8888)
                // 设置默认根目录
                .setRoot("D:\\workspace\\site\\hutool-site")
                .start();

        // 读取请求和返回内容
        // 返回JSON数据
        HttpUtil.createServer(8888)
                // 返回JSON数据测试
                .addAction("/restTest", (request, response) ->
                        response.write("{\"id\": 1, \"msg\": \"OK\"}", ContentType.JSON.toString())
                ).start();
        // 获取表单数据并返回
        HttpUtil.createServer(8888)
                // http://localhost:8888/formTest?a=1&a=2&b=3
                .addAction("/formTest", (request, response) ->
                        response.write(request.getParams().toString(), ContentType.TEXT_PLAIN.toString())
                ).start();

        // 文件上传
        HttpUtil.createServer(8888)
                .addAction("/file", (request, response) -> {
                            final UploadFile file = request.getMultipart().getFile("file");
                            // 传入目录，默认读取HTTP头中的文件名然后创建文件
                            file.write("d:/test/");
                            response.write("OK!", ContentType.TEXT_PLAIN.toString());
                        }
                )
                .start();
    }
}
