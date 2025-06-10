/**
 * Klasa reprezentująca nazwę dnia tygodnia w formie pełnej oraz skróconej.
 * Umożliwia pobieranie obu wersji nazwy dnia tygodnia.
 */
public class WeekName {
    /**
     * Pełna nazwa dnia tygodnia.
     */
    private final String weekDayName;
    /**
     * Skrócona nazwa dnia tygodnia.
     */
    private final String shortWeekDayName;
    /**
     * Tworzy nowy obiekt WeekName na podstawie podanych nazw.
     *
     * @param weekDayName pełna nazwa dnia tygodnia
     * @param shortWeekDayName skrócona nazwa dnia tygodnia
     */
    public WeekName(String weekDayName, String shortWeekDayName){
        this.weekDayName=weekDayName;
        this.shortWeekDayName=shortWeekDayName;
    }
    /**
     * Zwraca pełną nazwę dnia tygodnia.
     *
     * @return pełna nazwa dnia tygodnia
     */
    public String getWeekDayName() {
        return weekDayName;
    }
    /**
     * Zwraca skróconą nazwę dnia tygodnia.
     *
     * @return skrócona nazwa dnia tygodnia
     */
    public String getShortWeekDayName() {
        return shortWeekDayName;
    }
}
