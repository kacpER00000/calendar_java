/**
 * Klasa narzędziowa udostępniająca stałą tablicę miesięcy oraz metodę dostępu do nich.
 * Pozwala na pobieranie obiektu Month na podstawie indeksu (0-11).
 * W przypadku nieprawidłowego indeksu zgłaszany jest MonthOutOfRangeException.
 */
public class Months {
    private static Month[] months = new Month[]{
            /**
             * Stała tablica obiektów Month reprezentujących wszystkie miesiące roku.
            */
            new Month("01", "January", 31, "Jan", "I"),
            new Month("02", "February", 28, "Feb", "II"),
            new Month("03", "March", 31, "Mar", "III"),
            new Month("04", "April", 30, "Apr", "IV"),
            new Month("05", "May", 31, "May", "V"),
            new Month("06", "June", 30, "Jun", "VI"),
            new Month("07", "July", 31, "Jul", "VII"),
            new Month("08", "August", 31, "Aug", "VIII"),
            new Month("09", "September", 30, "Sep", "IX"),
            new Month("10", "October", 31, "Oct", "X"),
            new Month("11", "November", 30, "Nov", "XI"),
            new Month("12", "December", 31, "Dec", "XII"),

    };
    /**
     * Zwraca obiekt Month odpowiadający podanemu indeksowi (0-11).
     *
     * @param numOfMonth indeks miesiąca (0 dla stycznia, 11 dla grudnia)
     * @return obiekt Month dla danego indeksu
     * @throws MonthOutOfRangeException jeśli indeks jest poza zakresem 0-11
     */
    public static Month getMonth(int numOfMonth){
        try{
            return months[numOfMonth];
        } catch (IndexOutOfBoundsException e){
            throw new MonthOutOfRangeException("Month out of range. Your input: " + numOfMonth);
        }
    }
}
