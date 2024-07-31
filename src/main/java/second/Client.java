package second;

import first.Student;

public class Client {

    public static void main(String[] args) {

        Student student = new Student();
//      ERROR :  student.name = "keerthi";
//      ERROR :  student.batchName = ""
//      ERROR :  student.psp = 34.2
        student.age = 31;
    }
}
