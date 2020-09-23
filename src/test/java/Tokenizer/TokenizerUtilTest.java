package Tokenizer;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.hanlp.HanLPEngine;
import org.junit.Test;

import java.util.Iterator;

public class TokenizerUtilTest {

    // 中文分词
    @Test
    public void test01(){
        // 需要导入依赖 例如HanLP 先导入依赖
        TokenizerEngine engine = new HanLPEngine();
        // 解析文本
        String text = "这两个方法的区别在于返回值";
        Result result = engine.parse(text);
        // 输出：这 两个 方法 的 区别 在于 返回 值
        String resultStr = CollUtil.join((Iterator<Word>)result, " ");
        System.out.println(resultStr);
    }
}
