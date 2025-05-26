public class Month {
    private String numOfMonth;
    private String monthName;
    private String shortMonthName;
    private String romanMonth;
    private int maxDayNum;
    public Month(String numOfMonth, String monthName, int maxDayNum, String shortMonthName, String romanMonth){
        this.numOfMonth=numOfMonth;
        this.monthName=monthName;
        this.maxDayNum=maxDayNum;
        this.shortMonthName=shortMonthName;
        this.romanMonth=romanMonth;
    }
    public int getMaxDayNum(){
        return maxDayNum;
    }
    public void setMaxDayNum(int num){
        maxDayNum=num;
    }
    public String getMonthName(){
        return monthName;
    }
    public String getShortMonthName() {
        return shortMonthName;
    }
    public String getRomanMonth() {
        return romanMonth;
    }
    public int getNumOfMonth(){
        return Integer.parseInt(numOfMonth);
    }
}
