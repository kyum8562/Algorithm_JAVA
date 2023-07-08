import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double subjectSum = 0;
        double subjectCalSum = 0;
        for(int i = 0 ; i < 20 ; i ++){
            String[] str = br.readLine().split(" ");
            String point = str[2];
            double subjectScore = Double.parseDouble(str[1]);
            double ppoint = 0;
            if(point.equals("A+")) ppoint = 4.5;
            else if(point.equals("A0")) ppoint = 4.0;
            else if(point.equals("B+")) ppoint = 3.5;
            else if(point.equals("B0")) ppoint = 3;
            else if(point.equals("C+")) ppoint = 2.5;
            else if(point.equals("C0")) ppoint = 2;
            else if(point.equals("D+")) ppoint = 1.5;
            else if(point.equals("D0")) ppoint = 1;
            else if(point.equals("F")) ppoint = 0;
            else continue;

            subjectCalSum += ppoint * subjectScore;
            subjectSum += subjectScore;
        }

        System.out.println(subjectSum == 0.0 ? 0.0 : String.format("%.6f",subjectCalSum/subjectSum));
    }
}