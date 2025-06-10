import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Date> dateList = new ArrayList<>();
        dateList.add(new Date("05",10,2004,DateOutputMode.FULL_DATE));
        dateList.add(new Date("30",5,1998,DateOutputMode.FULL_DATE));
        dateList.add(new Date("29",2,2000,DateOutputMode.FULL_DATE));
        dateList.add(new Date("31","12","2015",DateOutputMode.FULL_DATE));
        dateList.add(Date.parse("01-01-2001"));
        final String nameSaveFile = "date.ser";
        File saveFile = new File("date.ser");
        FileWriter logFile = new FileWriter("log.txt",true);
        logFile.append(LocalDate.now() + "\n");
        String day="";
        int numOfMonth=0;
        int year=0;
        Date data=null;
        DateToSave tDate=null;
        Scanner sc;
        int createOrImportOption;
        System.out.println("Select:\n" +
                "1. Create new date\n" +
                (saveFile.exists() ? "2. Load from save file\n" : ""));
        sc=new Scanner(System.in);
        createOrImportOption=sc.nextInt();
        if(createOrImportOption == 1) {
            logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(0));
            System.out.println("Please, input data in DD-MM-YYYY format.");
            sc = new Scanner(System.in);
            day = sc.nextLine();
            sc = new Scanner(System.in);
            numOfMonth = sc.nextInt();
            sc = new Scanner(System.in);
            year = sc.nextInt();
        } else if(createOrImportOption == 2 && saveFile.exists()) {
            logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(1));
            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nameSaveFile)));
            tDate = (DateToSave) is.readObject();
            is.close();
        } else {
            return;
        }
        System.out.println("Select calendar mode(1 = normal mode, 2 = wrap-around mode for invalid day input)");
        sc = new Scanner(System.in);
        int mode=sc.nextInt();
        logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(3));
        System.out.println("Select output mode:\n" +
                "1 -> Tuesday, 1 December 2020,\n" +
                "2 -> 1 December 2020,\n" +
                "3 -> 03.XII.2020,\n" +
                "4 -> Tue., 1-Dec-2020.");
        sc=new Scanner(System.in);
        int outputOption=sc.nextInt();
        DateOutputMode outputMode = switch (outputOption) {
            case 2 -> DateOutputMode.DATE_WITHOUT_WEEKDAY;
            case 3 -> DateOutputMode.DATE_WITH_ROMAN_NUM;
            case 4 -> DateOutputMode.SHORT_DATE;
            default -> outputMode = DateOutputMode.FULL_DATE;
        };
        logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(2));

        try{
            if(createOrImportOption==1) {
                if (mode == 2) {
                    data = new Date(day, numOfMonth, year, outputMode,true);
                } else {
                    data = new Date(day, numOfMonth, year, outputMode);
                }
            } else{
                if (mode == 2) {
                    data = new Date(tDate.day, tDate.numOfMonth, tDate.year, outputMode,true);
                } else {
                    data = new Date(tDate.day, tDate.numOfMonth, tDate.year, outputMode);
                }
            }
            dateList.add(data);
            System.out.println(data.getData());
            int option;
            do{
                System.out.println("Press 1 to move by a week, 2 to display dates, 3 to sort dates, 4 to save the current date to a file, 0 to exit");
                sc=new Scanner(System.in);
                option=sc.nextInt();
                switch (option) {
                    case 1 -> {
                        int moveOption=-1;
                        while(moveOption != 1 && moveOption != 2){
                            System.out.println("Press 1 to move forward, 2 to move backward");
                            sc = new Scanner(System.in);
                            moveOption = sc.nextInt();
                        }
                        System.out.println(data.getData());
                        System.out.println("Data moved by a 1 week");
                        if(moveOption == 1) {
                            data.moveByAWeek(false);
                            logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(4));
                        } else if(moveOption == 2){
                            data.moveByAWeek(true);
                            logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(5));
                        }
                        System.out.println(data.getData());
                    }
                    case 2 -> {
                        for (Date date : dateList) {
                            System.out.println(date.getData());
                        }
                        logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(6));
                    }
                    case 3 -> {
                        Collections.sort(dateList);
                        for (Date date : dateList) {
                            System.out.println(date.getData());
                        }
                        logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(7));
                    }
                    case 4 -> {
                        tDate = new DateToSave(data.getDay(), data.getMonth().getNumOfMonth(), data.getYear());
                        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nameSaveFile)));
                        os.writeObject(tDate);
                        os.close();
                        logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(8));
                    }
                }
            }while(option!=0);
            logFile.append(LocalTime.now() + ": " + LogEvents.getEventMsg(9));
            logFile.close();
        } catch (MonthOutOfRangeException | DayOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}