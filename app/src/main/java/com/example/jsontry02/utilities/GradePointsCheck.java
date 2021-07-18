package com.example.jsontry02.utilities;

public class GradePointsCheck {
    public int checkingPoints(int marks) {
        int grade=0;
        if (marks>=90){
            grade=10;
        } else if (marks>=80){
            grade=9;
        } else if (marks>=70){
            grade=8;
        } else if (marks>=60){
            grade=7;
        } else if (marks>=45){
            grade=6;
        } else if (marks>=40){
            grade=4;
        } else {
            grade=0;
        }
        return grade;
    }

}
