public class Calendar{
    private String day;
    private Month month;
    private int year;
    public Calendar(String day, String numOfMonth,int year) throws IndexOutOfBoundsException,DayOutOfRangeException{
        this.year=year;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            Months.months[1].setMaxDayNum(29);
        }
        month=Months.months[Integer.parseInt(numOfMonth)-1];
        if(Integer.parseInt(day)<1 || Integer.parseInt(day)>month.getMaxDayNum()){
            throw new DayOutOfRangeException("Day out of range. Your input: " + day);
        }
        this.day=day;
    }
    public String getData(){
        return day+"-"+month.getMonthName()+"-"+this.year+"\n";
    }
    private void handleYearChange(boolean moveBackward){
        if(moveBackward){
            month = Months.months[11];
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
            newDay = newDay - month.getMaxDayNum();
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
}
