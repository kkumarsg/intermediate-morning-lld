package defaultconstructor;

public class Student {

    String name;
    int age = 21;
    String univName;
    double psp;
    boolean isPlaced;

    public Student(String studentName, String univName){
        this.name = studentName;
        this.univName = univName;
    }

    public Student(int age){
        this.age = age;
    }

}
