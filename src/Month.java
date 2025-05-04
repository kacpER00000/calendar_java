public class Month {
    private String numOfMonth;
    private String monthName;
    private int maxDayNum;
    public Month(String numOfMonth, String monthName, int maxDayNum){
        this.numOfMonth=numOfMonth;
        this.monthName=monthName;
        this.maxDayNum=maxDayNum;
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
}
