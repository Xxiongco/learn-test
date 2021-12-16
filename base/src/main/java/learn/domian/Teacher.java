package learn.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Person{
    private String name;
    @Override
    public void say() {
        System.out.println("i am teacher my name is "+ name);
    }
}
