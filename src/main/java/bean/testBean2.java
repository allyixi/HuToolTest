package bean;

import lombok.Data;

@Data
public class testBean2 {
    private String newName;
    private int newAge;

    @Override
    public String toString() {
        return "testBean2{" +
                "newName='" + newName + '\'' +
                ", newAge=" + newAge +
                '}';
    }
}
