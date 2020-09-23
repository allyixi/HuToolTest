package Util;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

public class RandomUtilTest {
    @Test
    public void test01(){
        // 0-10随机
        System.out.println(RandomUtil.randomInt(10));
        // 3-10随机
        System.out.println(RandomUtil.randomInt(3,10));

        // RandomUtil.randomBytes 随机bytes
        // RandomUtil.randomEle 随机获得列表中的元素
        // RandomUtil.randomEleSet 随机获得列表中的一定量的不重复元素，返回Set
        // RandomUtil.randomString 获得一个随机的字符串（只包含数字和字符）
        // RandomUtil.randomNumbers 获得一个只包含数字的字符串
        // RandomUtil.randomUUID 随机UUID
        // RandomUtil.weightRandom 权重随机生成器，传入带权重的对象，然后根据权重随机获取对象
    }
}
