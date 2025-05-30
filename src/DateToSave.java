import java.io.Serializable;

public class DateToSave implements Serializable {
    public String day;
    public int numOfMonth;
    public int year;
    public DateToSave(String day, int numOfMonth, int year){
        this.day=day;
        this.numOfMonth=numOfMonth;
        this.year=year;
    }
}
