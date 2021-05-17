package uaslp.objetos.exams;

import java.util.ArrayList;

public class Student {
    private String name;
    private int code;
    ArrayList<Double> Score = new ArrayList<Double>();


    public Student(String name, int code){
        this.name=name;
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public void setScore(int partial, double score) throws InvalidPartialException {
        partial = partial -1;
        if(partial >= 0 && partial < 4){
            Score.set(partial, score);
        }
        else{
            throw new InvalidPartialException();
        }
    }

    public double getAverage(){
        double Average=0;
        for(int i = 0; i<3; i++){
            Average= Average + Score.get(i);
        }
        return Average / 3;
    }
}
