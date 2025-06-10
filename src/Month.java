/**
 * Klasa reprezentująca miesiąc w roku wraz z jego właściwościami.
 * Przechowuje numer miesiąca, pełną i skróconą nazwę, nazwę rzymską oraz maksymalną liczbę dni.
 */
public class Month {
    /**
     * Numer miesiąca jako tekst.
     */
    private String numOfMonth;
    /**
     * Pełna nazwa miesiąca.
     */
    private String monthName;
    /**
     * Skrócona nazwa miesiąca.
     */
    private String shortMonthName;
    /**
     * Nazwa miesiąca w zapisie rzymskim (np. "I").
     */
    private String romanMonth;
    /**
     * Maksymalna liczba dni w miesiącu.
     */
    private int maxDayNum;
    /**
     * Tworzy nowy obiekt Month na podstawie podanych parametrów.
     *
     * @param numOfMonth numer miesiąca jako tekst
     * @param monthName pełna nazwa miesiąca
     * @param maxDayNum maksymalna liczba dni w miesiącu
     * @param shortMonthName skrócona nazwa miesiąca
     * @param romanMonth nazwa miesiąca w zapisie rzymskim
     */
    public Month(String numOfMonth, String monthName, int maxDayNum, String shortMonthName, String romanMonth){
        this.numOfMonth=numOfMonth;
        this.monthName=monthName;
        this.maxDayNum=maxDayNum;
        this.shortMonthName=shortMonthName;
        this.romanMonth=romanMonth;
    }
    /**
     * Zwraca maksymalną liczbę dni w miesiącu.
     *
     * @return maksymalna liczba dni
     */
    public int getMaxDayNum() {
        return maxDayNum;
    }
    /**
     * Ustawia maksymalną liczbę dni w miesiącu.
     *
     * @param num nowa maksymalna liczba dni
     */
    public void setMaxDayNum(int num) {
        maxDayNum = num;
    }
    /**
     * Zwraca pełną nazwę miesiąca.
     *
     * @return pełna nazwa miesiąca
     */
    public String getMonthName() {
        return monthName;
    }
    /**
     * Zwraca skróconą nazwę miesiąca.
     *
     * @return skrócona nazwa miesiąca
     */
    public String getShortMonthName() {
        return shortMonthName;
    }
    /**
     * Zwraca nazwę miesiąca w zapisie rzymskim.
     *
     * @return nazwa rzymska miesiąca
     */
    public String getRomanMonth() {
        return romanMonth;
    }
    /**
     * Zwraca numer miesiąca jako liczbę całkowitą.
     *
     * @return numer miesiąca
     */
    public int getNumOfMonth() {
        return Integer.parseInt(numOfMonth);
    }
}

