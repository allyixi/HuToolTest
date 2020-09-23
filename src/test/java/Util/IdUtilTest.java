package Util;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;

public class IdUtilTest {
    @Test
    public void test01(){
        // UUID
        // 生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        // 生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
    }

    @Test
    public void test02(){
        // ObjectId
        //生成类似：5b9e306a4df4f8c54a39fb0c
        String id = ObjectId.next();
        // 方法2
        String id2 = IdUtil.objectId();
    }

    @Test
    public void test03(){
        // Snowflake
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
    }
}
