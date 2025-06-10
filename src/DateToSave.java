import java.io.Serializable;
/**
 * Klasa pomocnicza służąca do serializacji uproszczonej daty.
 * Przechowuje dzień, numer miesiąca oraz rok w formacie umożliwiającym łatwe zapisanie do pliku.
 * Implementuje interfejs Serializable
 */
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
