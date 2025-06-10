import java.io.Serializable;
/**
 * Klasa pomocnicza służąca do serializacji uproszczonej daty.
 * Przechowuje dzień, numer miesiąca oraz rok w formacie umożliwiającym łatwe zapisanie do pliku.
 * Implementuje interfejs Serializable
 */
public class DateToSave implements Serializable {
    /**
     * Numer dnia jako tekst
     */
    public String day;
    /**
     * Numer miesiąca( 1-12)
     */
    public int numOfMonth;
    /**
     * Rok
     */
    public int year;
    /**
     * Tworzy nowy obiekt DateToSave na podstawie podanych wartości.
     *
     * @param day dzień miesiąca
     * @param numOfMonth numer miesiąca
     * @param year rok
     */
    public DateToSave(String day, int numOfMonth, int year){
        this.day=day;
        this.numOfMonth=numOfMonth;
        this.year=year;
    }
}
