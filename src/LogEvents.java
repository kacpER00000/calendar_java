/**
 * Klasa służąca do obsługi komunikatów związanych ze zdarzeniami w aplikacji.
 * Udostępnia predefiniowane komunikaty dla różnych operacji na datach i kalendarzu.
 */
public class LogEvents {
    /**
     * Tablica komunikatów opisujących zdarzenia w aplikacji.
     */
    private static String[] eventMsg = new String[]{
            "Stworzono nową date\n", "Wczytano date z pliku\n", "Wybrano tryb wyswietlania\n", "Wybrano tryb kalendarza\n", "Przesunięto date o tydzien do przodu\n", "Przesunieto o tydzien do tylu\n","Wyswietlono daty\n", "Posortowano daty\n", "Zapisano date do pliku\n","Zakonczono program\n"
    };
    /**
     * Zwraca komunikat odpowiadający podanemu indeksowi.
     *
     * @param idx indeks komunikatu w tablicy
     * @return komunikat zdarzenia jako tekst
     * @throws ArrayIndexOutOfBoundsException jeśli indeks jest poza zakresem tablicy
     */
    public static String getEventMsg(int idx){
        return eventMsg[idx];
    }
}
