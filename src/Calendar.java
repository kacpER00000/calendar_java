public class Calendar{
    private String day;
    private Month month;
    private int year;
    private DateOutputMode outputMode;
    public Calendar(String day, int numOfMonth,int year, DateOutputMode outputMode) throws IndexOutOfBoundsException,DayOutOfRangeException{
        this.outputMode=outputMode;
        this.year=year;
        month=Months.getMonth(numOfMonth-1);
        if (month.getNumOfMonth()==2 && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            month.setMaxDayNum(29);
        }
        if(Integer.parseInt(day)<1 || Integer.parseInt(day)>month.getMaxDayNum()){
            throw new DayOutOfRangeException("Day out of range. Your input: " + day);
        }
        this.day=day;
    }

    //Drugi konstruktor wymaga poprawy
    public Calendar(String day, int numOfMonth,int year,boolean mode){
        if(mode){
            this.year=year;
            if(Integer.parseInt(day) > Months.getMonth(numOfMonth-1).getMaxDayNum()){
                if(numOfMonth==12){
                    month = Months.getMonth(0);
                    this.year++;
                } else {
                    this.month=Months.getMonth(numOfMonth);
                }
                this.day=String.valueOf(Integer.parseInt(day)-Months.getMonth(numOfMonth-1).getMaxDayNum());
            }
            if(Integer.parseInt(day)<1){
                if(numOfMonth==1){
                    month = Months.getMonth(11);
                    this.year--;
                } else {
                    this.month=Months.getMonth(numOfMonth-2);
                }
                this.day=String.valueOf(month.getMaxDayNum()+Integer.parseInt(day));
            }
        }
    }
    public String getData(){
        String output="";
        String day=this.day;
        String month=this.month.getMonthName();
        String year = String.valueOf(this.year);
        switch(outputMode){
            case FULL_DATE:
                output += getDayWeekZeller().getWeekDayName() + ", ";
                day += " ";
                month += " ";
                break;
            case DATE_WITHOUT_WEEKDAY:
                day += " ";
                month += " ";
                break;
            case DATE_WITH_ROMAN_NUM:
                day += ".";
                month=this.month.getRomanMonth() + ".";
                break;
            case SHORT_DATE:
                output += getDayWeekZeller().getShortWeekDayName() + ",.";
                day += "-";
                month=this.month.getShortMonthName()+"-";
                break;
        }
        output += day + month + year;
        return output;
    }
    public void moveByAWeek(boolean moveBackward) {
        int interval = moveBackward ? -7 : 7;
        int newDay = Integer.parseInt(day) + interval;
        if (newDay > month.getMaxDayNum()) {
            if (month.getNumOfMonth() == 12) {
                month = Months.getMonth(0);
                year++;
            } else {
                month = Months.getMonth(month.getNumOfMonth());
            }
            if (month.getNumOfMonth() == 2 && (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0))) {
                month.setMaxDayNum(29);
            }
            newDay = newDay - month.getMaxDayNum();
        } else if (newDay < 1) {
            if (month.getNumOfMonth() == 1) {
                month = Months.getMonth(11);
                year--;
            } else {
                month = Months.getMonth(month.getNumOfMonth() - 2);
            }
            if (month.getNumOfMonth() == 2 && (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0))) {
                month.setMaxDayNum(29);
            }
            newDay = month.getMaxDayNum() + newDay;
        }
        day = String.valueOf(newDay);
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
    public WeekName getDayWeekZeller(){
        int d = Integer.parseInt(day);
        int m = month.getNumOfMonth();
        int y = year;
        if (m == 1 || m == 2) {
            m += 12;
            y -= 1;
        }
        int h = (d + (13*(m + 1))/5 + y%100 + (y%100)/4 + (y/100)/4 + 5*(y/100)) % 7;
        return WeekNames.weekNames[h];
    }
    public void setOutputMode(DateOutputMode outputMode){
        this.outputMode=outputMode;
    }
}
