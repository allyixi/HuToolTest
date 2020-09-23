package Util;

import bean.testBean;
import bean.testBean2;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.bean.copier.CopyOptions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanUtilTest {


    @Test
    public void test01() {
        // BeanUtil.fillBeanWithMap 使用Map填充bean
        Map<String, Object> map = new HashMap<String, Object>();
        // BeanUtil.fillBeanWithMap 首字母大小写匹配 其他位置需要大小写一致
        map.put("name", "xm");
        map.put("age", 18);
        map.put("gender", "male");
        testBean bean = BeanUtil.fillBeanWithMap(map, new testBean(), false);
        System.out.println(bean.toString());
        // BeanUtil.fillBeanWithMapIgnoreCase 使用Map填充bean，忽略大小写
    }

    @Test
    public void test02() {
        // BeanUtil.beanToMap方法则是将一个Bean对象转为Map对象。
        testBean bean = new testBean();
        bean.setName("xm");
        bean.setAge(18);
        bean.setGender("male");
        Map<String, Object> map = BeanUtil.beanToMap(bean);
        System.out.println(map);
    }

    @Test
    public void test03() {
        // Bean转Bean
        testBean bean = new testBean();
        bean.setName("xm");
        bean.setAge(18);
        bean.setGender("male");
        testBean2 testBean2 = new testBean2();
        // 若两个Bean属性名相同直接使用BeanUtil.copyProperties(源bean,目标bean)
        // 若两个Bean属性名有差异，通过将映射关系Map设置到CopyOptions.setFieldMapping(map) 调用BeanUtil.copyProperties(源bean,目标bean,映射关系)
        CopyOptions copyOptions = new CopyOptions();
        Map<String, String> map = new HashMap<String, String>();
        map.put("Name", "newName");
        map.put("age", "newAge");
        copyOptions.setFieldMapping(map);
        BeanUtil.copyProperties(bean, testBean2, copyOptions);
        System.out.println(testBean2.toString());
    }

    @Test
    public void test04(){
        // 通过自定义注解Alias给bean的属性起别名
        // @Alias("aliasSubName")
        // private String subName;
    }

    @Test
    public void test05(){
        // DynaBean是使用反射机制动态操作bean
        DynaBean bean = DynaBean.create(new testBean());
        bean.set("Name","lx");
        bean.set("age",23);
        System.out.println(bean.invoke("toString"));
    }



}
