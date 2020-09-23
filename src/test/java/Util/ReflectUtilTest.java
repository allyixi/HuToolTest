package Util;

import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtilTest {

    @Test
    public void test01(){
        // 获取某个类的所有方法
        Method[] methods = ReflectUtil.getMethods(StrUtilTest.class);
        for(Method method:methods){
//            System.out.println(method.getName());
        }
        // 获取某个类的所有方法
        // Method method = ReflectUtil.getMethod(StrUtilTest.class, "test01");
        try {
            methods[0].invoke(new StrUtilTest());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        // 构造对象
        StrUtilTest object= ReflectUtil.newInstance(StrUtilTest.class);
    }

    @Test
    public void testt03(){
        StrUtilTest strUtilTest=new StrUtilTest();
        ReflectUtil.invoke(strUtilTest,"test01");
    }

    public List<String> intTest(int a){
        return new ArrayList<String>();
    }
}
