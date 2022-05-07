package collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    private Integer id;
    private String num;
    private Integer age;
    private String name;

    private Boolean flag;

    private boolean testboole;

    public Cat(Integer id, String num, Integer age, String name) {
        this.id = id;
        this.num = num;
        this.age = age;
        this.name = name;
    }
}
