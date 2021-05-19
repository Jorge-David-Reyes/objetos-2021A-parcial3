package uaslp.objetos.exams;

import java.util.ArrayList;

public class Student {
    private String name;
    private int code;
    Integer score[];


    public Student(String name, int code){
        this.name = name;
        this.code = code;
        score = new Integer[3];
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public void setScore(int partial, int score){
        if (partial > 3 || partial < 1){
            throw new InvalidPartialException();
        }
        this.score[partial-1] = score;
    }

    public double getAverage(){
        double average = 0;

        for(int i = 0; i < 3; i++){
            if(score[i] == null){
                throw new MissingScoreException("Missing partial " + (i+1));
            }
            average = average + score[i];
        }
        return average/3;
    }
}
