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
}
