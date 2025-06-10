/**
 * Klasa udostępniająca stałą tablicę nazw dni tygodnia oraz metodę dostępu do nich.
 * Pozwala na pobieranie obiektu WeekName na podstawie indeksu (0-6), zgodnie z kolejnością:
 * 0 - Saturday, 1 - Sunday, 2 - Monday, ..., 6 - Friday.
 */
public class WeekNames {
    /**
     * Stała tablica obiektów {@link WeekName} reprezentujących wszystkie dni tygodnia.
     */
    private static WeekName[] weekNames = new WeekName[]{
            new WeekName("Saturday", "Sat"),
            new WeekName("Sunday", "Sun"),
            new WeekName("Monday", "Mon"),
            new WeekName("Tuesday", "Tue"),
            new WeekName("Wednesday", "Wed"),
            new WeekName("Thursday", "Thu"),
            new WeekName("Friday", "Fri"),

    };
    /**
     * Zwraca obiekt WeekName odpowiadający podanemu indeksowi (0-6).
     *
     * @param idx indeks dnia tygodnia (0 dla soboty, 1 dla niedzieli, ..., 6 dla piątku)
     * @throws ArrayIndexOutOfBoundsException jeśli indeks jest poza zakresem 0-6
     * @return obiekt WeekName dla danego indeksu
     */
    public static WeekName getWeekName(int idx){
        return weekNames[idx];
    }
}

