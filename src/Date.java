public class Date implements Comparable<Date> {
    private String day;
    private Month month;
    private int year;
    private DateOutputMode outputMode;

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
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
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
        return WeekNames.weekNames[(-1 + diff % 7 + 7) % 7];
    }
    public WeekName getDayWeekZeller() {
        int d = Integer.parseInt(day);
        int m = month.getNumOfMonth();
        int y = year;
        if (m == 1 || m == 2) {
            m += 12;
            y -= 1;
        }
        int h = (d + (13 * (m + 1)) / 5 + y % 100 + (y % 100) / 4 + (y / 100) / 4 + 5 * (y / 100)) % 7;
        return WeekNames.weekNames[h];
    }
    public void setOutputMode(DateOutputMode outputMode) {
        this.outputMode = outputMode;
    }

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

    public String getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
}
