public class Months {
    private static Month[] months = new Month[]{
            new Month("01", "January", 31, "Jan", "I"),
            new Month("02", "February", 28, "Feb", "II"),
            new Month("03", "March", 31, "Mar", "III"),
            new Month("04", "April", 30, "Apr", "IV"),
            new Month("05", "May", 31, "May", "V"),
            new Month("06", "June", 30, "Jun", "VI"),
            new Month("07", "July", 31, "Jul", "VII"),
            new Month("08", "August", 31, "Aug", "VIII"),
            new Month("09", "September", 30, "Sep", "IX"),
            new Month("10", "October", 31, "Oct", "X"),
            new Month("11", "November", 30, "Nov", "XI"),
            new Month("12", "December", 31, "Dec", "XII"),

    };
    public static Month getMonth(int numOfMonth){
        try{
            return months[numOfMonth];
        } catch (IndexOutOfBoundsException e){
            throw new MonthOutOfRangeException("Month out of range. Your input: " + numOfMonth);
        }
    }
}
