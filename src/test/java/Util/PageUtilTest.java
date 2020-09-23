package Util;

import cn.hutool.core.util.PageUtil;
import org.junit.Test;

public class PageUtilTest {
    @Test
    public void test01(){
        // 当前页+size换算
        // [10, 20]
        int[] startEnd2 = PageUtil.transToStartEnd(1, 10);
        // 总数+size换算分页数
        // 7
        int totalPage = PageUtil.totalPage(20, 3);
        // 参数意义分别为：当前页、总页数、每屏展示的页数
        // 结果：[3, 4, 5, 6, 7, 8]
        int[] rainbow = PageUtil.rainbow(5, 20, 6);
    }
}
