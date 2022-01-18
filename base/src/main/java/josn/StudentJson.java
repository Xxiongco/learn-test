package josn;

import learn.domian.Person;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentJson extends PersonJson {
    private Integer id;
    private String name;
    private String num;

    private List<String> girlsName;

    public StudentJson() {
        girlsName = new ArrayList<>();
    }
}
