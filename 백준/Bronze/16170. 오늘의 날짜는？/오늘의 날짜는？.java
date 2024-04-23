import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime n = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(n.getYear());
        System.out.println(n.getMonthValue());
        System.out.println(n.getDayOfMonth());
    }
}