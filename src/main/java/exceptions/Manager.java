package exceptions;

public class Manager {



    public static void main(String[] args) {

        Employee sabari = new Employee("Sabari", 10);
        try {
            sabari.callEmployeeForWork(12);
            return ;
        } catch (NonWorkingHoursException e) {
            sabari.appraisalNumber--;
            System.out.println("employee unavailable for work");
        } catch (LunchTimeException l){
            System.out.println("Hey, Lunch time");
        } catch (Exception e){ // not a good practice to catch all exceptions.
            System.out.println("Soemthing went wrong "+e.getMessage());
            throw e;
        }
        finally {
            System.out.println("Final block executed");
        }
    }
}
