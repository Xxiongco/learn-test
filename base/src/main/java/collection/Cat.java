package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cat {
    private Integer id;
    private String num;
    private Integer age;
    private String name;
}
