public class WeekNames {
    private static WeekName[] weekNames = new WeekName[]{
            new WeekName("Saturday", "Sat"),
            new WeekName("Sunday", "Sun"),
            new WeekName("Monday", "Mon"),
            new WeekName("Tuesday", "Tue"),
            new WeekName("Wednesday", "Wed"),
            new WeekName("Thursday", "Thu"),
            new WeekName("Friday", "Fri"),

    };
    public static WeekName getWeekName(int idx){
        return weekNames[idx];
    }
}

