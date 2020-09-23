package Util;

import cn.hutool.core.util.ReUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReUtilTest {
    @Test
    public void test01(){
        // ReUtil.delFirst()删除第一个匹配到的内容
        String content = "ZZZaaabbbccc中文1234";
        String resultDelFirst = ReUtil.delFirst("(\\w)aa(\\w)", content);
        // ZZbbbccc中文1234
        System.out.println(resultDelFirst);

        // ReUtil.findAll()查找所有匹配文本
        // 结果：["ZZ", "Za", "aa", "bb", "bc", "cc", "12", "34"]
        List<String> resultFindAll = ReUtil.findAll("\\w{2}", content, 0, new ArrayList<String>());

        // ReUtil.getFirstNumber(）返回匹配的第一个数字
        // 1234
        Integer resultGetFirstNumber = ReUtil.getFirstNumber(content);
        System.out.println(resultGetFirstNumber);

        // ReUtil.isMatch() 给定字符串是否匹配给定正则
        boolean isMatch = ReUtil.isMatch("\\w+[\u4E00-\u9FFF]+\\d+", content);

        // ReUtil.replaceAll() 通过正则查找到字符串，然后把匹配到的字符串加入到replacementTemplate中，$1表示分组1的字符串
        //此处把1234替换为 ->1234<-
        String replaceAll = ReUtil.replaceAll(content, "(\\d+)", "->$1<-");

        // ReUtil.escape()转义给定字符串，为正则相关的特殊符号转义
        String escape = ReUtil.escape("我有个$符号{}");
        // 我有个\$符号\{\}
        System.out.println(escape);
    }
}
