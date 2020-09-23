package Util;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TypeUtilTest {

    @Test
    public void test01(){
        Method method = ReflectUtil.getMethod(ReflectUtilTest.class, "intTest", Integer.class);
        // 获取方法参数的泛型类型
        Type type = TypeUtil.getParamType(method, 0);
        // int
        System.out.println(type);
        // 获取方法的返回值类型
        Type type1=TypeUtil.getReturnType(method);
        // java.util.List<java.lang.String>
        System.out.println(type1);
        // 获取泛型类子类中泛型的填充类型
        Type type2 = TypeUtil.getTypeArgument(type1);
        // lass java.lang.String
        System.out.println(type2);
    }
}
