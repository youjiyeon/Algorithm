import java.time.LocalDate;
import java.time.LocalDateTime;

public class BJ_10699_Main {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now().plusHours(9);
        System.out.println(time.toLocalDate());
    }
}
