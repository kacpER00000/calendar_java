import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calendar data=null;
        Scanner sc;
        System.out.println("Please, input data in DD-MM-YYYY format.");
        sc=new Scanner(System.in);
        String day=sc.nextLine();
        sc=new Scanner(System.in);
        int numOfMonth=sc.nextInt();
        sc=new Scanner(System.in);
        int year=sc.nextInt();
        System.out.println("Select calendar mode(0,1)");
        sc=new Scanner(System.in);
        int mode=sc.nextInt();
        System.out.println("Select output mode:\n" +
                "1 -> wtorek, 1 grudnia 2020,\n" +
                "2 -> 1 grudnia 2020,\n" +
                "3 -> 03.XII.2020,\n" +
                "4 -> wt., 1-gru-2020.");
        sc=new Scanner(System.in);
        int outputOption=sc.nextInt();
        DateOutputMode outputMode = switch (outputOption) {
            case 2 -> DateOutputMode.DATE_WITHOUT_WEEKDAY;
            case 3 -> DateOutputMode.DATE_WITH_ROMAN_NUM;
            case 4 -> DateOutputMode.SHORT_DATE;
            default -> DateOutputMode.FULL_DATE;
        };
        try{
            if(mode==1){
                data=new Calendar(day,numOfMonth,year,true);
            } else {
                data=new Calendar(day,numOfMonth,year,outputMode);
            }
            System.out.println(data.getData());
            int option;
            do{
                System.out.println("Wycisnij 1 aby przesunac o tydzien, 0 aby zakonczyc");
                sc=new Scanner(System.in);
                option=sc.nextInt();
                System.out.println(data.getData());
                System.out.println("Data moved by a 1 week");
                data.moveByAWeek(true);
                System.out.println(data.getData());
            }while(option!=0);
        } catch (MonthOutOfRangeException | DayOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}