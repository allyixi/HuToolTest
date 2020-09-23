package Cglib;

import cn.hutool.extra.cglib.CglibUtil;
import lombok.Data;
import org.junit.Test;

public class CglibUtilTest {
    // <dependency>
    //    <groupId>cglib</groupId>
    //    <artifactId>cglib</artifactId>
    //    <version>3.2.5</version>
    // </dependency>
    @Test
    public void test01(){
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        OtherSampleBean otherBean = new OtherSampleBean();
        CglibUtil.copy(bean, otherBean);
        // 值为"Hello world"
        System.out.println(otherBean.getValue());

        OtherSampleBean otherBean2 = CglibUtil.copy(bean, OtherSampleBean.class);
        // 值为"Hello world"
        System.out.println(otherBean2.getValue());
    }
}

@Data
class SampleBean {
    private String value;
}

@Data
class OtherSampleBean {
    private String value;
}
