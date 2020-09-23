package Util;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

public class ObjectUtillTest {
    //  判断对象相等
    @Test
    public void test01() {
        // obj1 == null && obj2 == null 或者 obj1.equals(obj2) 返回true
        //  ObjectUtil.equal(o1,o2);
    }

    // 判断长度 支持类型：
    @Test
    public void test02() {
        // CharSequence
        // Collection
        // Map
        // Iterator
        // Enumeration
        // Array
        // ObjectUtil.length(o);
    }

    // 判断包含
    @Test
    public void test03() {
        // String
        // Collection
        // Map
        // Iterator
        // Enumeration
        // Array
        // ObjectUtil.contains(o1,o2);
    }

    // 对象克隆
    @Test
    public void test04() {
        // ObjectUtil.clone 克隆对象，如果对象实现Cloneable接口，调用其clone方法，如果实现Serializable接口，执行深度克隆，否则返回null。
        // ObjectUtil.cloneIfPossible 返回克隆后的对象，如果克隆失败，返回原对象
        // ObjectUtil.cloneByStream 序列化后拷贝流的方式克隆，对象必须实现Serializable接口
    }

    // 序列化、反序列化
    @Test
    public void test05() {
        // ObjectUtil.serialize(o);
        // ObjectUtil.unserialize(byte[]);
    }

    // 判断基本类型
    @Test
    public void test06() {
        // ObjectUtil.isBasicType(o);
    }
}
