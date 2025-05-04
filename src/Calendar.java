public class Calendar{
    private String day;
    private static Month[] months = new Month[]{
            new Month("01","Styczen",31),
            new Month("02","Luty",28),
            new Month("03","Marzec",31),
            new Month("04","Kwiecien",30),
            new Month("05","Maj",31),
            new Month("06","Czerwiec",30),
            new Month("07","Lipiec",31),
            new Month("08","Sierpien",31),
            new Month("09","Wrzesien",30),
            new Month("10","Pazdziernik",31),
            new Month("11","Listopad",30),
            new Month("12","Grudzien",31),
    };
    private Month month;
    private int year;
    public Calendar(String day, String numOfMonth,int year) throws IndexOutOfBoundsException,DayOutOfRangeException{
        this.year=year;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            months[1].setMaxDayNum(29);
        }
        month=months[Integer.parseInt(numOfMonth)-1];
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
            month = months[11];
            year=year-1;
        } else {
            month = months[0];
            year=year+1;
        }
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            months[1].setMaxDayNum(29);
        } else{
            months[1].setMaxDayNum(28);
        }
    }
    public void moveByAWeek(boolean moveBackward){
        int interval= moveBackward ? -7:7;
        if(Integer.parseInt(day)+interval > month.getMaxDayNum()) {
            if (month.getNumOfMonth() + 1 > 12) {
                handleNewYear(false);
            }
            else {
                month = months[month.getNumOfMonth()];
            }
            day=String.valueOf(Integer.parseInt(day)+interval - months[month.getNumOfMonth()-2].getMaxDayNum());
            return;
        }
        if(Integer.parseInt(day)+interval < 1){
            if (month.getNumOfMonth() - 1 < 1){
                handleNewYear(true);
            } else{
                month = months[month.getNumOfMonth()-2];
            }
            day=String.valueOf(month.getMaxDayNum()+Integer.parseInt(day)+interval);
            return;
        }
        day=String.valueOf(Integer.parseInt(day)+interval);
    }
}
