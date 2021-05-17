package uaslp.objetos.exams;

import java.util.LinkedList;

public class Group {

     private int people;
     private int capacity;
     LinkedList<Student> students = new LinkedList<Student>();

     public Group (int capacity){
         this.capacity = capacity;
     }

     public LinkedList<Student> getStudents(){
         return students;
     }

     public int getCapacity(){
         return capacity;
     }

     public int getAvailability(){
         return capacity - students.size();
     }

     public void addStudent(Student student){
         students.add(student);
     }


    public double getAverage() {
        double Average=0;
        for (Student student: students)
            Average = Average + student.getAverage();
        
        Average = Average / students.size();

        return Average;
    }
}
