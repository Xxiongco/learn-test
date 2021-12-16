package learn.domian;

import lombok.Data;

@Data
public class Student implements Person{
    private Integer id;
    private String name;
    private String num;

    @Override
    public void say() {
        System.out.println("i am student my id:" +id + " my name:" + name + " my num :" + num);
    }
}
