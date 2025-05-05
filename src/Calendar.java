public class Calendar{
    private String day;
    private Month month;
    private int year;
    public Calendar(String day, String numOfMonth,int year) throws IndexOutOfBoundsException,DayOutOfRangeException{
        this.year=year;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            Month.months[1].setMaxDayNum(29);
        }
        month=Month.months[Integer.parseInt(numOfMonth)-1];
        if(Integer.parseInt(day)<1 || Integer.parseInt(day)>month.getMaxDayNum()){
            throw new DayOutOfRangeException("Day out of range. Your input: " + day);
        }
        this.day=day;
    }
    public String getData(){
        return day+"-"+month.getMonthName()+"-"+this.year+"\n";
    }
    private void handleNewYear(boolean moveBackward){
        if(moveBackward){
            month = Month.months[11];
            year=year-1;
        } else {
            month = Month.months[0];
            year=year+1;
        }
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            Month.months[1].setMaxDayNum(29);
        } else{
            Month.months[1].setMaxDayNum(28);
        }
    }
    public void moveByAWeek(boolean moveBackward){
        int interval= moveBackward ? -7:7;
        if(Integer.parseInt(day)+interval > month.getMaxDayNum()) {
            if (month.getNumOfMonth() + 1 > 12) {
                handleNewYear(false);
            }
            else {
                month = Month.months[month.getNumOfMonth()];
            }
            day=String.valueOf(Integer.parseInt(day)+interval - Month.months[month.getNumOfMonth()-2].getMaxDayNum());
            return;
        }
        if(Integer.parseInt(day)+interval < 1){
            if (month.getNumOfMonth() - 1 < 1){
                handleNewYear(true);
            } else{
                month = Month.months[month.getNumOfMonth()-2];
            }
            day=String.valueOf(month.getMaxDayNum()+Integer.parseInt(day)+interval);
            return;
        }
        day=String.valueOf(Integer.parseInt(day)+interval);
    }
}
