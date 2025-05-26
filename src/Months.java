public class Months {
    private static Month[] months = new Month[]{
            new Month("01","styczen",31,"sty","I"),
            new Month("02","luty",28,"lut","II"),
            new Month("03","marzec",31,"mar","III"),
            new Month("04","kwiecien",30,"kwi","IV"),
            new Month("05","maj",31,"maj","V"),
            new Month("06","czerwiec",30,"cze","VI"),
            new Month("07","lipiec",31,"lip","VII"),
            new Month("08","sierpien",31,"sie","VIII"),
            new Month("09","wrzesien",30,"wrz","IX"),
            new Month("10","pazdziernik",31,"paz","X"),
            new Month("11","listopad",30,"lis","XI"),
            new Month("12","grudzien",31,"gru","XII"),
    };
    public static Month getMonth(int numOfMonth){
        try{
            return months[numOfMonth];
        } catch (IndexOutOfBoundsException e){
            throw new MonthOutOfRangeException("Month out of range. Your input: " + numOfMonth);
        }
    }
}
