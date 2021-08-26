package com.example.jsontry02.utilities;

import android.content.Context;
import android.icu.number.Precision;

import java.text.DecimalFormat;
import java.util.Formatter;

public class CalculatorSGPA {
    Context mContext;
    public CalculatorSGPA(Context context){
        this.mContext = context;
    }


    public double semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*3)+(b*4)+(c*3)+(d*3)+(e*3)+(f*3)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }

    public double semThreeAndFourSGPAForTX(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*4)+(b*4)+(c*3)+(d*3)+(e*3)+(f*2)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semThreeSGPAForEI(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*3)+(b*3)+(c*3)+(d*3)+(e*3)+(f*4)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semFourSGPAForEI(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*3)+(b*3)+(c*3)+(d*4)+(e*3)+(f*3)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semFourSGPAForEE(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*3)+(b*3)+(c*4)+(d*3)+(e*3)+(f*3)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 25.00;
        sgpa=((1.0*a*3)+(b*4)+(c*4)+(d*3)+(e*3)+(f*3)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semFiveSGPAForTX(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        double sgpa;
        double num= 25.00;
        sgpa=((1.0*a*3)+(b*4)+(c*4)+(d*4)+(e*3)+(f*2)+(g*2)+(h*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(int a, int b, int c, int d, int e, int f, int g, int h) {
        double sgpa;
        double num= 24.00;
        sgpa=((1.0*a*4)+(b*4)+(c*4)+(d*3)+(e*3)+(f*2)+(g*2)+(h*2))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semSevenSGPAFor_BT_CS_IS(int a, int b, int c, int d, int e, int f, int g) {
        double sgpa;
        double num= 20.00;
        sgpa=((1.0*a*4)+(b*4)+(c*3)+(d*3)+(e*3)+(f*2)+(g*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semSevenSGPAFor_AI(int a, int b, int c, int d, int e, int f, int g) {
        double sgpa;
        double num= 20.00;
        sgpa=((1.0*a*4)+(b*4)+(c*3)+(d*3)+(e*3)+(f*1)+(g*2))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semSevenSGPAFor_CV_EC_EE_EI_ME_TX(int a, int b, int c, int d, int e, int f, int g, int i) {
        double sgpa;
        double num= 20.00;
        sgpa=((1.0*a*3)+(b*3)+(c*3)+(d*3)+(e*3)+(f*2)+(g*2)+(i*1))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(int a, int b, int c, int d, int e) {
        double sgpa;
        double num= 18.00;
        sgpa=((1.0*a*3)+(b*3)+(c*8)+(d*1)+(e*3))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public double firstYear(int a, int b, int c, int d, int e, int f, int g, int i) {
        double sgpa;
        double num= 20.00;
        sgpa=((1.0*a*4)+(b*4)+(c*3)+(d*3)+(e*3)+(f)+(g)+(i))/num;
        //Make a new instance df that has 2 decimal places pattern.
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sgpa);
        return Double.parseDouble(formatter.toString());
    }
    public int TotalForNineSubject(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        int total=0;
        total=a+b+c+d+e+f+g+h+i;
        return total;
    }

    public double PercentageForNineSubject(int total) {
        double percentage =0;
        double num= 9.0;
        percentage =total/num;
        Formatter formatter = new Formatter();
        formatter.format("%.2f", percentage);
        return Double.parseDouble(formatter.toString());
    }
    public int TotalForEightSubject(int a, int b, int c, int d, int e, int f, int g, int h) {
        int total=0;
        total=a+b+c+d+e+f+g+h;
        return total;
    }
    public double PercentageForEightSubject(int total) {
        double percentage =0;
        double num= 8.0;
        percentage =total/num;
        Formatter formatter = new Formatter();
        formatter.format("%.2f", percentage);
        return Double.parseDouble(formatter.toString());
    }
    public int TotalForSevenSubject(int a, int b, int c, int d, int e, int f, int g) {
        int total=0;
        total=a+b+c+d+e+f+g;
        return total;
    }
    public double PercentageForSevenSubject(int total) {
        double percentage =0;
        double num= 7.0;
        percentage =total/num;
        Formatter formatter = new Formatter();
        formatter.format("%.2f", percentage);
        return Double.parseDouble(formatter.toString());
    }
    public int TotalForFiveSubject(int a, int b, int c, int d, int e) {
        int total=0;
        total=a+b+c+d+e;
        return total;
    }
    public double PercentageForFiveSubject(int total) {
        double percentage =0;
        double num= 5.0;
        percentage =total/num;
        Formatter formatter = new Formatter();
        formatter.format("%.2f", percentage);
        return Double.parseDouble(formatter.toString());
    }
}
