package bean;

import lombok.Data;

@Data
public class testBean {
    private String Name;
    private int age;
    private String gender;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "testBean{" +
                "name='" + Name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
