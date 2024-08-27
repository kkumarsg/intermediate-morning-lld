package exceptions;

public class Employee {

    String name;
    int salary;

    int appraisalNumber = 0;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String UNAVAILABLE_MESSAGE = "Hey Manager, you shouldn't be doing this.. ";

    // hour is from 0-24
    // working hours are 9-18
    public void callEmployeeForWork(int hour) throws NonWorkingHoursException, LunchTimeException {
        if(hour<9 || hour >18){
            throw new NonWorkingHoursException(UNAVAILABLE_MESSAGE);
        }
        if(hour==1){
            throw new LunchTimeException(UNAVAILABLE_MESSAGE);
        }
        // acutally making a db call.
        throw new NullPointerException();
//        System.out.println("On the way to work ");
    }

    // throw [pass anything that's an instance of Throwable]
}
