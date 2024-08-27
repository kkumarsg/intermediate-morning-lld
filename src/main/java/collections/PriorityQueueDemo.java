package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        // by default minHeap
//        PriorityQueue<Integer> numbers = new PriorityQueue<>();
//
//
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(10);
        numbers.add(30);
        numbers.add(12);



        Collections.sort(numbers);

//        System.out.println("numbers = " + numbers);


        List<Student> students = new ArrayList<>();

        Student prem = new Student("Prem", 101, 98);
        Student akash = new Student("Akash", 103, 95);
        Student ashish = new Student("Ashish", 102, 99);

        prem.setPaymentStatus(PaymentStatus.SUCCESS);
        akash.setPaymentStatus(PaymentStatus.PENDING);
        ashish.setPaymentStatus(PaymentStatus.SUCCESS);


        akash.setPaymentStatus(PaymentStatus.SUCCESS);



        students.add(prem);
        students.add(ashish);
        students.add(akash);

        for(Student student: students){
            if(PaymentStatus.SUCCESS.equals(student.getPaymentStatus())){
                System.out.println("student.getName() = " + student.getName());
            }
        }

        isPaymentStatusValid();


        Collections.sort(students, new StudentComparatorPsp());


        Collections.sort(students, new StudentComparatorId());

        PriorityQueue<Student> studentPriorityQueue =
                new PriorityQueue<>(new StudentComparatorPsp());

        for(Student student: students){
//            System.out.println("student.getName() = " + student.getName());
        }

    }

    private static void isPaymentStatusValid() {
        String paymentStatusFromOtherService = "SUCCESS";
        boolean isPaymentStatusValid = false;
        for(PaymentStatus paymentStatus: PaymentStatus.values()){
            if(paymentStatus.name().equals(paymentStatusFromOtherService)){
               isPaymentStatusValid = true;
            }
        }

        System.out.println("isPaymentStatusValid = " + isPaymentStatusValid);
    }
}
