package uaslp.objetos.exams;

import java.util.ArrayList;
import java.util.List;

public class Group {

     private int capacity;
     private int availibility;
     private List<Student> students;

     public Group (int capacity){
         this.capacity = capacity;
         availibility = capacity;
         students = new ArrayList<>(capacity);
     }

     public List<Student> getStudents(){
         return students;
     }

     public int getCapacity(){
         return capacity;
     }

     public int getAvailability(){
         return availibility;
     }

     public List<Student> getStudent(){
         return students;
     }

     public void addStudent(Student student){
         if(availibility == 0)
             throw new GroupIsFullException();
         students.add(student);
         availibility--;
     }


    public double getAverage() {
        double Average=0;
        Student student;
        for(int i = 0; i<students.size(); i++)
            Average = Average + students.get(i).getAverage();
        
        Average = Average / students.size();

        return Average;
    }
}
