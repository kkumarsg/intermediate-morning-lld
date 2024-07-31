package second;

import first.Student;

public class StudentChild extends Student {

    public void doSomething(){


        /*

        private String name; -> NO
        String batchName; // default -> NO
        protected double psp; YES
        public int age; YES

        I'm inside different package and a child class.

         */

        psp = 85;
        System.out.println("Age is "+age);
//      ERROR : System.out.println("Name is "+name);
//      ERROR : System.out.println("Batchname is "+batchName);
    }

    public static void main(String[] args) {

        /*
        Inside a child class, there wouldn't be a situation where you
        would create a instance of parent class.
        * Rather since it's child, we should inherit all the properties of parent and we should be
         able to access them
         */

    }

}
