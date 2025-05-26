import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Date> dateList = new ArrayList<>();
        dateList.add(new Date("05",10,2004,DateOutputMode.FULL_DATE));
        dateList.add(new Date("30",5,1998,DateOutputMode.FULL_DATE));
        dateList.add(new Date("29",2,2000,DateOutputMode.FULL_DATE));
        dateList.add(new Date("31",12,2015,DateOutputMode.FULL_DATE));
        Date data=null;
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
                data=new Date(day,numOfMonth,year,true);
            } else {
                data=new Date(day,numOfMonth,year,outputMode);
            }
            dateList.add(data);
            System.out.println(data.getData());
            int option;
            do{
                System.out.println("Wycisnij 1 aby przesunac o tydzien, 2. Wyświetlić daty, 3. Posortować daty, 0 aby zakonczyc");
                sc=new Scanner(System.in);
                option=sc.nextInt();
                switch(option){
                    case 1:
                        System.out.println(data.getData());
                        System.out.println("Data moved by a 1 week");
                        data.moveByAWeek(true);
                        System.out.println(data.getData());
                        break;
                    case 2:
                        for(Date date: dateList){
                            System.out.println(date.getData());
                        }
                        break;
                    case 3:
                        Collections.sort(dateList);
                        for(Date date: dateList){
                            System.out.println(date.getData());
                        }
                        break;
                }

            }while(option!=0);
        } catch (MonthOutOfRangeException | DayOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}