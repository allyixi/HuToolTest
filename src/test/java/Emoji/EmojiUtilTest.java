package Emoji;

import cn.hutool.extra.emoji.EmojiUtil;
import org.junit.Test;

public class EmojiUtilTest {
    // <dependency>
    //    <groupId>com.vdurmont</groupId>
    //    <artifactId>emoji-java</artifactId>
    //    <version>4.0.0</version>
    // </dependency>
    @Test
    public void test01(){
        // 转义Emoji字符
        // :smile:
        String alias = EmojiUtil.toAlias("😄");

        // 将转义的别名转为Emoji字符
        // 😄
        String emoji = EmojiUtil.toUnicode(":smile:");

        // 将字符串中的Unicode Emoji字符转换为HTML表现形式
        //&#128102;
        String alias2 = EmojiUtil.toHtml("😄");
    }
}
