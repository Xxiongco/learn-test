import lombok.Data;
import lombok.ToString;

public class TestMian {
    public static void main(String[] args) {
        // 测试boolean的默认值为？ false
//        Student student = new Student();
//        System.out.println(student);

        label1:
        for (int x = 0; x < 5; x++) {
            for (int y = 5; y > 0; y--) {
                if (y == x) {
                    continue label1;
                }
                System.out.println(x+","+y);
            }
        }
        System.out.println("Game Over!");

    }
}
class Student{
    private boolean man;

    @Override
    public String toString() {
        return "Student{" +
                "man=" + man +
                '}';
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
