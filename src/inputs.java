import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Random;
public class inputs {
    public int groupCount;
    public String name;
    public int weekDay;
    String discount = "MEMBER";
    boolean correctCode;
    double height;
    double weight;
    long age;
    boolean driveThru;
    Date birthday;
    Date date;
    boolean alcohol;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private int cost;

    public void init(){
        setName();
        setBirthday();
        setWeight();
        setHeight();
        setGroupCount();
        checkDiscount();
        checkBirthday();
        setDate();
        if(dayOfWeek()==1||dayOfWeek()==7) {
            if (age >= 2 && age <= 14) {
                cost = 12;
            } else if (age >= 15 && age < 18) {
                cost = 18;
            } else if (age >= 18) {
                cost = 25;
            } else {
                cost = 0;
            }
        } else  {
            if(age>=2&&age<=14) {
                cost = 8;
            } else if(age>=15&&age<18) {
                cost = 12;
            } else if(age>=18) {
                cost = 16;
            } else {
                cost = 0;
            }
        }
    }

    private void setName(){
        System.out.println("Enter your name: ");
        name = in.nextLine().toUpperCase();
    }
    private void setWeight(){
        System.out.println("Enter your weight: ");
        weight = in.nextDouble();
    }
    private void setHeight(){
        System.out.println("Enter your height: ");
        height = in.nextDouble();
    }
    private void setBirthday(){
        System.out.println("Enter your birthday: ");
        String rawBirthday = in.nextLine();
        // not gonna lie the next part is straight off stack exchange but uhhhh
            String dateString = in.nextLine();
        try {

            birthday = sdf.parse(dateString);

            System.out.println("Parsed date: " + date);

        } catch (Exception e) {

            System.out.println("Invalid date format.");

        }
    }
    private void setGroupCount(){
        System.out.println("Enter your group count: ");
        groupCount = in.nextInt();
        in.nextLine();
    }
    private void checkDiscount(){
        System.out.println("Enter your discount: ");
        String checkCode = in.nextLine();
        if(checkCode.equals("MEMBER")){
            correctCode = true;
        }
    }
    private void setDate(){
        System.out.println("Enter your date: ");
        String rawDate = in.nextLine();
        LocalDate localDate = LocalDate.parse(rawDate);
    }
    private void checkBirthday(){
        LocalDate today = LocalDate.now();
        LocalDate localBirthday = convertToLocalDate(birthday);
        age = ChronoUnit.YEARS.between(localBirthday,today);
        if(age >= 21){
            alcohol = true;
        }
    }
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    public long getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public int dayOfWeek() {
        Calendar week = Calendar.getInstance();
        week.setTime(date);
        weekDay = week.get(Calendar.DAY_OF_WEEK);
        return weekDay;
    }
    public int getCost(){
        return cost;
    }
    public boolean getAlcohol(){
        return alcohol;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public String idConstructor(){
        String id = "";
        for(int i = 0; i < 5; i++){
            id += rand.nextInt(0,10);
        }
        return id;
    }
}
