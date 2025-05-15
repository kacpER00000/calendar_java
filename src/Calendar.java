public class Calendar{
    private String day;
    private Month month;
    private int year;
    public Calendar(String day, int numOfMonth,int year) throws IndexOutOfBoundsException,DayOutOfRangeException{
        this.year=year;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            Months.months[1].setMaxDayNum(29);
        }
        month=Months.months[numOfMonth-1];
        if(Integer.parseInt(day)<1 || Integer.parseInt(day)>month.getMaxDayNum()){
            throw new DayOutOfRangeException("Day out of range. Your input: " + day);
        }
        this.day=day;
    }
    public Calendar(String day, int numOfMonth,int year,boolean mode){
        if(mode){
            this.year=year;
            if(Integer.parseInt(day) > Months.months[numOfMonth-1].getMaxDayNum()){
                if(numOfMonth==12){
                    handleYearChange(false);
                } else {
                    this.month=Months.months[numOfMonth];
                }
                this.day=String.valueOf(Integer.parseInt(day)-Months.months[numOfMonth-1].getMaxDayNum());
            }
            if(Integer.parseInt(day)<1){
                if(numOfMonth==1){
                    handleYearChange(true);
                } else {
                    this.month=Months.months[numOfMonth-2];
                }
                this.day=String.valueOf(month.getMaxDayNum()+Integer.parseInt(day));
            }
        }
    }
    public String getData(){
        return this.getDayWeekDateReference()+", "+day+" "+month.getMonthName()+" "+this.year+"\n";
    }
    private void handleYearChange(boolean moveBackward){
        if(moveBackward){
            month=Months.months[11];
            year--;
        } else {
            month = Months.months[0];
            year++;
        }
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            Months.months[1].setMaxDayNum(29);
        } else{
            Months.months[1].setMaxDayNum(28);
        }
    }
    public void moveByAWeek(boolean moveBackward) {
        int interval = moveBackward ? -7 : 7;
        int newDay = Integer.parseInt(day) + interval;
        if (newDay > month.getMaxDayNum()) {
            if (month.getNumOfMonth() == 12) {
                handleYearChange(false);
            } else {
                month = Months.months[month.getNumOfMonth()];
            }
            newDay = newDay - Months.months[month.getNumOfMonth()-2].getMaxDayNum();
        } else if (newDay < 1) {
            if (month.getNumOfMonth() == 1) {
                handleYearChange(true);
            } else {
                month = Months.months[month.getNumOfMonth() - 2];
            }
            newDay = month.getMaxDayNum() + newDay;
        }
        day = String.valueOf(newDay);
    }
    public String getDayWeekDateReference() {
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

    public String getDayWeekZeller(){
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
}
