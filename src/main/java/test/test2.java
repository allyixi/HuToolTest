package test;

import cn.hutool.http.HttpUtil;

public class test2 {
    public static void main(String[] args) {
        HttpUtil.createServer(8888)
                .addAction("/", (req, res)->{
                    res.write("Hello Hutool Server");
                })
                .start();
    }
}
