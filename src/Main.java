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
        try{
            if(mode==1){
                data=new Calendar(day,numOfMonth,year,true);
            } else {
                data=new Calendar(day,numOfMonth,year);
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