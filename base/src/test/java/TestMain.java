import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import learn.domian.Student;
import learn.domian.Two;
import org.junit.Test;

public class TestMain {

    @Test
    public void test(){
        Student student = new Student();
        student.setId(1);
        student.setName(null);

        String s = JSONObject.toJSONString(student);
        System.out.println(s);


    }

    @Test
    public void testAssert(){
        Student student = new Student();

        assert student == null : "student not null";

    }

    /**
     * 测试重载是否可以发生在子父类中
     */
    @Test
    public void test2(){
        Two two = new Two();
        
    }

}
