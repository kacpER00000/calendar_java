public class LogEvents {
    private static String[] eventMsg = new String[]{
            "Stworzono nową date\n", "Wczytano date z pliku\n", "Wybrano tryb wyswietlania\n", "Wybrano tryb kalendarza\n", "Przesunięto date o tydzien do przodu\n", "Przesunieto o tydzien do tylu\n","Wyswietlono daty\n", "Posortowano daty\n", "Zapisano date do pliku\n","Zakonczono program\n"
    };
    public static String getEventMsg(int idx){
        return eventMsg[idx];
    }
}
