import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calendar data=null;
        Scanner sc;
        System.out.println("Please, input data in DD-MM-YYYY format.");
        sc=new Scanner(System.in);
        String day=sc.nextLine();
        sc=new Scanner(System.in);
        String numOfMonth=sc.nextLine();
        sc=new Scanner(System.in);
        int year=sc.nextInt();
        try{
            data=new Calendar(day,numOfMonth,year);
            System.out.println(data.getData());
            System.out.println("Data moved by a 1 week");
            data.moveByAWeek();
            System.out.println(data.getData());
        } catch (DayOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new MonthOutOfRangeException("Month out of range. Your input "+ numOfMonth);
        }
    }
}