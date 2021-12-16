package learn.config;

import learn.domian.Person;
import learn.domian.Student;
import learn.domian.Teacher;
import lombok.Data;

import java.util.HashMap;

/**
 * @author xiong
 */

@Data
public class PersonFactory {

    private static final HashMap<String, Class<? extends Person>> PERSONMAP = new HashMap<String, Class<? extends Person>>();

    static {
        PERSONMAP.put("student", Student.class);
        PERSONMAP.put("teacher", Teacher.class);
    }

    public Person getPerson(String personName){
        Class<? extends Person> personClass = PERSONMAP.get(personName);
        Person person = null;
        try {
            person =  personClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}
