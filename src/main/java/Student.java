public class Student {

    String name;
    String batchName;
    double psp;
    int age;

    void changeBatch(String newBatch){
        batchName = newBatch;
    }

    void giveMock(){
        System.out.println(name + " is giving mock ");
    }
}

class App {

    public static void main(String[] args) {

        // above 90
        // Recap notes
        // Install intellij
        // Re-do everything we're doing in class

        Student student1 = new Student();
        student1.name = "Vishal";
        student1.psp = 60;

        Student student2 = new Student();
        student2.name = "Shreyasi";
        student2.psp = 90;

        System.out.println("Does nothing ..");

    }
}
