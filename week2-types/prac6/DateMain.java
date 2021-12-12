import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateMain {
    public static void main(String [] args){
        final Date date = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA);
        System.out.println(date_format.format(date));
        date_format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA);
        System.out.println(date_format.format(date));
        date_format = new SimpleDateFormat("오늘은 이 달의 F번째 E요일 입니다.", Locale.KOREA);
        System.out.println(date_format.format(date));
    }
}
