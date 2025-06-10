/**
 * Klasa reprezentująca datę z obsługą różnych trybów wyświetlania oraz operacjami na datach.
 * Pozwala na przesuwanie daty o tydzień, porównywanie, parsowanie i prezentację w różnych formatach.
 *
 * Implementuje interfejs Comparable.
 */
public class Date implements Comparable<Date> {
    /**
     * Numer dnia jako tekst
     */
    private String day;
    /**
     * Obiekt klasy Month reprezentujący miesiąc
     */
    private Month month;
    /**
     * Rok
     */
    private int year;
    private DateOutputMode outputMode;
    /**
     * Tworzy nową datę na podstawie dnia, numeru miesiąca, roku i trybu wyświetlania.
     *
     * @param day dzień miesiąca
     * @param numOfMonth numer miesiąca
     * @param year rok
     * @param outputMode tryb wyświetlania daty
     * @throws DayOutOfRangeException jeśli dzień jest poza zakresem dla danego miesiąca
     */
    public Date(String day, int numOfMonth, int year, DateOutputMode outputMode)
            throws DayOutOfRangeException {
        this.outputMode = outputMode;
        this.year = year;
        month = Months.getMonth(numOfMonth - 1);
        int maxDay = month.getMaxDayNum();
        if (month.getNumOfMonth() == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        int d = Integer.parseInt(day);
        if (d < 1 || d > maxDay) {
            throw new DayOutOfRangeException("Day out of range. Your input: " + day);
        }
        this.day = String.valueOf(d);
    }
    /**
     * Tworzy nową datę, automatycznie korygując dzień i miesiąc, jeśli dzień wykracza poza zakres miesiąca.
     *
     * @param day dzień miesiąca
     * @param numOfMonth numer miesiąca
     * @param year rok
     * @param outputMode tryb wyświetlania daty
     * @param mode parametr sterujący korektą
     */
    public Date(String day, int numOfMonth, int year, DateOutputMode outputMode, boolean mode) {
        int d = Integer.parseInt(day);
        int monthIndex = numOfMonth - 1;
        while (true) {
            int maxDay = Months.getMonth(monthIndex).getMaxDayNum();
            if (Months.getMonth(monthIndex).getNumOfMonth() == 2 && isLeapYear(year)) {
                maxDay = 29;
            }
            if (d <= maxDay && d >= 1) {
                break;
            }
            if (d > maxDay) {
                d -= maxDay;
                monthIndex++;
                if (monthIndex >= 12) {
                    monthIndex = 0;
                    year++;
                }
            } else {
                monthIndex--;
                if (monthIndex < 0) {
                    monthIndex = 11;
                    year--;
                }
                int prevMax = Months.getMonth(monthIndex).getMaxDayNum();
                if (Months.getMonth(monthIndex).getNumOfMonth() == 2 && isLeapYear(year)) {
                    prevMax = 29;
                }
                d += prevMax;
            }
        }
        this.day = String.valueOf(d);
        this.month = Months.getMonth(monthIndex);
        this.year = year;
        this.outputMode = outputMode;
    }
    /**
     * Tworzy nową datę na podstawie tekstowych reprezentacji dnia, miesiąca i roku.
     *
     * @param day dzień miesiąca
     * @param numOfMonth numer miesiąca
     * @param year rok
     * @param outputMode tryb wyświetlania daty
     */
    public Date(String day, String numOfMonth, String year, DateOutputMode outputMode){
        this(day, Integer.parseInt(numOfMonth), Integer.parseInt(year),outputMode);
    }
    /**
     * Przesuwa datę o tydzień do przodu lub do tyłu.
     *
     * @param moveBackward jeśli {@code true} - przesuwa o tydzień wstecz, w przeciwnym razie do przodu
     */
    public void moveByAWeek(boolean moveBackward) {
        int delta = moveBackward ? -7 : 7;
        int d = Integer.parseInt(day) + delta;
        int monthIndex = month.getNumOfMonth() - 1;
        while (true) {
            int maxDay = Months.getMonth(monthIndex).getMaxDayNum();
            if (Months.getMonth(monthIndex).getNumOfMonth() == 2 && isLeapYear(year)) {
                maxDay = 29;
            }
            if (d > maxDay) {
                d -= maxDay;
                monthIndex++;
                if (monthIndex >= 12) {
                    monthIndex = 0;
                    year++;
                }
            } else if (d < 1) {
                monthIndex--;
                if (monthIndex < 0) {
                    monthIndex = 11;
                    year--;
                }
                int prevMax = Months.getMonth(monthIndex).getMaxDayNum();
                if (Months.getMonth(monthIndex).getNumOfMonth() == 2 && isLeapYear(year)) {
                    prevMax = 29;
                }
                d += prevMax;
            } else {
                break;
            }
        }

        this.day = String.valueOf(d);
        this.month = Months.getMonth(monthIndex);
    }

    /**
     * Sprawdza, czy dany rok jest przystępny
     * @param year
     * @return True jeśli rok jest przystępny, w przeciwnym wypadku false
     */
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    /**
     * Zwraca datę w formacie zgodnym z ustawionym trybem wyświetlania, przechowywanym w atrybucie outputMode
     *
     * @return sformatowana data jako tekst
     */
    public String getData() {
        String output = "";
        String d = this.day;
        String m = this.month.getMonthName();
        String y = String.valueOf(this.year);
        switch (outputMode) {
            case FULL_DATE:
                output += getDayWeekZeller().getWeekDayName() + ", ";
                d += " ";
                m += " ";
                break;
            case DATE_WITHOUT_WEEKDAY:
                d += " ";
                m += " ";
                break;
            case DATE_WITH_ROMAN_NUM:
                d += ".";
                m = this.month.getRomanMonth() + ".";
                break;
            case SHORT_DATE:
                output += getDayWeekZeller().getShortWeekDayName() + ", ";
                d += "-";
                m = this.month.getShortMonthName() + "-";
                break;
        }
        return output + d + m + y;
    }

    /**
     * Zwraca dzień tygodnia na podstawie daty referencyjnej 30.11.2020
     * @return Obiekt WeekName reprezentujący dzień tygodnia.
     */
    public WeekName getDayWeekDateReference() {
        int dayCountRef = 365*2020 + 2020/4 - 2020/100 + 2020/400 + (153*10+8)/5 + 30;
        int d = Integer.parseInt(day);
        int m = month.getNumOfMonth();
        int y = year;
        if (m<3) {
            m += 12;
            y -= 1;
        }
        int dayCountMyDay = 365*y + y/4 - y/100 + y/400 + (153*m+8)/5 + d;
        int diff = dayCountMyDay - dayCountRef;
        return WeekNames.getWeekName((-1 + diff % 7 + 7) % 7);
    }
    /**
     * Zwraca dzień tygodnia na podstawie algortymu Zellera
     * @return Obiekt WeekName reprezentujący dzień tygodnia.
     */
    public WeekName getDayWeekZeller() {
        int d = Integer.parseInt(day);
        int m = month.getNumOfMonth();
        int y = year;
        if (m == 1 || m == 2) {
            m += 12;
            y -= 1;
        }
        int h = (d + (13 * (m + 1)) / 5 + y % 100 + (y % 100) / 4 + (y / 100) / 4 + 5 * (y / 100)) % 7;
        return WeekNames.getWeekName(h);
    }

    /**
     * Ustawia tryb wyświetlania daty.
     * @param outputMode Obiekt klasy DateOutputMode
     */
    public void setOutputMode(DateOutputMode outputMode) {
        this.outputMode = outputMode;
    }
    /**
     * Porównuje tę datę z inną datą.
     *
     * @param c inna data do porównania
     * @return wartość ujemna, zero lub dodatnia w zależności od relacji względem siebie.
     */
    @Override
    public int compareTo(Date c) {
        if (year == c.year) {
            if (month == c.month) {
                return day.compareTo(c.day);
            }
            return Integer.compare(month.getNumOfMonth(), c.month.getNumOfMonth());
        }
        return Integer.compare(year, c.year);
    }
    /**
     * Zwraca dzień miesiąca.
     *
     * @return dzień miesiąca jako tekst
     */
    public String getDay() {
        return day;
    }
    /**
     * Zwraca miesiąc.
     *
     * @return obiekt {@code Month} reprezentujący miesiąc
     */
    public Month getMonth() {
        return month;
    }
    /**
     * Zwraca rok.
     *
     * @return rok
     */
    public int getYear() {
        return year;
    }
    /**
     * Tworzy nową datę na podstawie tekstu w formacie "dzień-miesiąc-rok".
     *
     * @param date tekstowa reprezentacja daty
     * @return nowy obiekt Date
     */
    public static Date parse(String date){
        String[] args = date.split("-");
        return new Date(args[0],args[1],args[2],DateOutputMode.FULL_DATE);
    }
}
