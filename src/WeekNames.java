public class WeekNames {
    private static String[] weekNames=new String[]{
        "Sobota", "Niedziela","Poniedzialek","Wtorek","Sroda","Czwartek","Piatek"
    };
    public static String getWeekName(int numOfWeekDay){
        return weekNames[numOfWeekDay];
    }
}
