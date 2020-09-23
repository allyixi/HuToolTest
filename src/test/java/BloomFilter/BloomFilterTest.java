package BloomFilter;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import org.junit.Test;

public class BloomFilterTest {

    @Test
    public void test01() {
        // 初始化
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");
        // 查找
        filter.contains("abc");
    }
}
