package Util;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.comparator.VersionComparator;
import org.junit.Test;

public class ComparatorTest {
    @Test
    public void test01() {
        // 版本比较器
        // 左边<右边 返回-1
        // 左边=右边 返回0
        // 左边>右边 返回1
        // 1.2.1 < 1.12.1
        VersionComparator.INSTANCE.compare("1.2.1", "1.12.1");
        // 1.12.1 < 1.12.1c
        VersionComparator.INSTANCE.compare("1.12.1", "1.12.1c");
        // V0.0.20170102 > V0.0.20170101
        VersionComparator.INSTANCE.compare("V0.0.20170102", "V0.0.20170101");

        // ReverseComparator 反转比较器，排序时提供反序
        // VersionComparator 版本比较器，支持如：1.3.20.8，6.82.20160101，8.5a/8.5c等版本形式
        // PropertyComparator Bean属性比较器，通过Bean的某个属性来对Bean对象进行排序
        // IndexedComparator 按照数组的顺序正序排列，数组的元素位置决定了对象的排序先后
        // ComparatorChain 比较器链。此链包装了多个比较器，最终比较结果按照比较器顺序综合多个比较器结果。
        // PinyinComparator 按照GBK拼音顺序对给定的汉字字符串排序。
    }

    @Test
    public void test02(){
        // 当isNullGreater为true时，null始终最大，此处返回的compare > 0
        int compare = CompareUtil.compare(null, "a", true);
        // 当isNullGreater为false时，null始终最小，此处返回的compare < 0
        int compare2 = CompareUtil.compare(null, "a", false);
    }
}
