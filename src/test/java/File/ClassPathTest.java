package File;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class ClassPathTest {
    @Test
    public void test01() throws IOException {
        ClassPathResource resource = new ClassPathResource("a.yml");
        byte[] data=new byte[resource.getStream().available()];
        resource.getStream().read(data);
        System.out.println(new String(data));
//        Properties properties = new Properties();
//        properties.load(resource.getStream());
//        Console.log("Properties: {}", properties);
    }
}
