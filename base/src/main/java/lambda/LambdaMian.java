package lambda;

public class LambdaMian {
    public static void main(String[] args) {
        String vakavak = invoke("vakavak", () -> {
            return "demo";
        });
        System.out.println(vakavak);
    }
    public static String invoke(String song,Sing sing){
        String singsong = sing.singsong();
        System.out.println(singsong);
        return singsong;
    }
}
