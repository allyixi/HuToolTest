package Http;

import cn.hutool.http.HtmlUtil;
import org.junit.Test;

public class HtmlUtilTest {
    @Test
    public void test01() {
        // HtmlUtil.escape
        // 转义HTML特殊字符，包括：
        // ' 替换为 &#039;
        // " 替换为 &quot;
        // & 替换为 &amp;
        // < 替换为 &lt;
        // > 替换为 &gt;
        String html = "<html><body>123'123'</body></html>";
        // 结果为：&lt;html&gt;&lt;body&gt;123&#039;123&#039;&lt;/body&gt;&lt;/html&gt;
        String escape = HtmlUtil.escape(html);

        // HtmlUtil.unescape
        // 还原被转义的HTML特殊字符
        String escape2 = "&lt;html&gt;&lt;body&gt;123&#039;123&#039;&lt;/body&gt;&lt;/html&gt;";
        // 结果为：<html><body>123'123'</body></html>
        String unescape = HtmlUtil.unescape(escape2);

        // HtmlUtil.removeHtmlTag
        // 清除指定HTML标签和被标签包围的内容
        String str = "pre<img src=\"xxx/dfdsfds/test.jpg\">";
        // 结果为：pre
        String result = HtmlUtil.removeHtmlTag(str, "img");

        // HtmlUtil.cleanHtmlTag
        // 清除所有HTML标签，但是保留标签内的内容
        String str2 = "pre<div class=\"test_div\">\r\n\t\tdfdsfdsfdsf\r\n</div><div class=\"test_div\">BBBB</div>";
        // 结果为：pre\r\n\t\tdfdsfdsfdsf\r\nBBBB
        String result2 = HtmlUtil.cleanHtmlTag(str2);

        // HtmlUtil.unwrapHtmlTag
        // 清除指定HTML标签，不包括内容
        String str3 = "pre<div class=\"test_div\">abc</div>";
        // 结果为：preabc
        String result3 = HtmlUtil.unwrapHtmlTag(str3, "div");

        // HtmlUtil.removeHtmlAttr
        // 去除HTML标签中的指定属性，如果多个标签有相同属性，都去除
        String html2 = "<div class=\"test_div\"></div><span class=\"test_div\"></span>";
        // 结果为：<div></div><span></span>
        String result4 = HtmlUtil.removeHtmlAttr(html2, "class");

        // HtmlUtil.removeAllHtmlAttr
        // 去除指定标签的所有属性
        String html3 = "<div class=\"test_div\" width=\"120\"></div>";
        // 结果为：<div></div>
        String result5 = HtmlUtil.removeAllHtmlAttr(html3, "div");

        // HtmlUtil.filter
        // 过滤HTML文本，防止XSS攻击
        String html4 = "<alert></alert>";
        // 结果为：""
        String filter = HtmlUtil.filter(html4);
    }
}
