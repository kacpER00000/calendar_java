public class WeekName {
    private final String weekDayName;
    private final String shortWeekDayName;
    public WeekName(String weekDayName, String shortWeekDayName){
        this.weekDayName=weekDayName;
        this.shortWeekDayName=shortWeekDayName;
    }
    public String getWeekDayName() {
        return weekDayName;
    }
    public String getShortWeekDayName() {
        return shortWeekDayName;
    }
}
