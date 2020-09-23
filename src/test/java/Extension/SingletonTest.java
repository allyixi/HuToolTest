package Extension;

        import cn.hutool.core.lang.Singleton;
        import org.junit.Test;

public class SingletonTest {

    @Test
    public void test01() {
        //单例对象每次取出为同一个对象，除非调用Singleton.destroy()或者remove方法
        DictTest dictTest = Singleton.get(DictTest.class);
    }
}
