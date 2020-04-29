import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    private String nickname;
    private int bornDay;
    private int bornMonth;
    private int bornYear;

    public Player() {
    }

    public String getNickname() {
        return nickname;
    }

    public int getBornDay() {
        return bornDay;
    }

    public int getBornMonth() {
        return bornMonth;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBornDate(int day, int month, int year) throws ParseException, InvalidDateException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format( new Date());
        Date today = simpleDateFormat.parse(currentDate);
        Date bornDate = simpleDateFormat.parse(day + "/" + month + "/" + year);

        if(today.compareTo(bornDate) >= 0){
            this.bornDay = day;
            this.bornMonth = month;
            this.bornYear = year;
        }
        else{
            throw new InvalidDateException();
        }
    }

}
