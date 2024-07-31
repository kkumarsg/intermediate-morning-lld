package defaultconstructor;

public class Client {

    public static void main(String[] args) {

//        Student student = new Student();

        Student student1 = new Student(23);

        Student student = new Student("Keerthi", "NIT");
        System.out.println("Just stop here ");


        // Will I be able to create an Employee obj ?
//        Employee employee = new Employee();
    }
}
