package learn;

import learn.config.PersonFactory;
import learn.domian.Person;
import learn.domian.Teacher;

import java.util.HashMap;

public class LearnBaseMain {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Person student = personFactory.getPerson("student");
        student.say();
        Person teacher = personFactory.getPerson("teacher");
        teacher.say();

        Teacher.class.newInstance()

    }
}
