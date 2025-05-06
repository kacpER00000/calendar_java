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
    public Calendar(String day, String numOfMonth,int year,boolean mode){
        if(mode){
            this.year=year;
            if(Integer.parseInt(day) > Months.months[Integer.parseInt(numOfMonth)-1].getMaxDayNum()){
                if(Integer.parseInt(numOfMonth)==12){
                    handleYearChange(false);
                } else {
                    this.month=Months.months[Integer.parseInt(numOfMonth)];
                }
                this.day=String.valueOf(Integer.parseInt(day)-Months.months[Integer.parseInt(numOfMonth)-1].getMaxDayNum());
            }
            if(Integer.parseInt(day)<1){
                if(Integer.parseInt(numOfMonth)==1){
                    handleYearChange(true);
                } else {
                    this.month=Months.months[Integer.parseInt(numOfMonth)-2];
                }
                this.day=String.valueOf(month.getMaxDayNum()+Integer.parseInt(day));
            }
        }
    }
    // W konstruktorze zamienić String numOfMonth na int
    public String getData(){
        return day+" "+month.getMonthName()+" "+this.year+"\n";
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
    public int getDayWeek(){
        int h=(Integer.parseInt(day) + (13*((month.getNumOfMonth())==1 || month.getNumOfMonth()==2 ? 12+ month.getNumOfMonth() : month.getNumOfMonth())+1)/5 + year%100 + (year%100)/4 + (year/100)/4 - 2*(year/100))%7;
        return h;
    }
}
