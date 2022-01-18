package josn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class LearnJsonMain {
    public static void main(String[] args) {

    }

    public static void testJson(){
        StudentJson student = new StudentJson();
        //student.setId(1);
        student.setName("panda");
        student.setSkill("walk");

        String s = JSON.toJSONString(student);
        // {"id":1,"name":"panda"}
        System.out.println(s);

        String s1 = JSONObject.toJSONString(student);

        System.out.println(s1);
    }
}
