package org.example;

public class ArraysStatistics {
    public static int max(int[] numbers){
        int max=numbers[0];
        for(int i=1; i<numbers.length; i++){
            if(max<numbers[i]){
                max=numbers[i];
            }
        }
        return max;
    }
    public static int min(int[] numbers){
        int min=numbers[0];
        for(int i=1; i<numbers.length; i++){
            if(min>numbers[i]){
                min=numbers[i];
            }
        }
        return min;
    }
    public static double avg(int[] numbers){
        double avg=0;
        for(int i=0; i< numbers.length; i++){
            avg+=numbers[i];
        }
        return avg/ numbers.length;
    }
    public static int sum(int[] numbers){
        int sum=0;
        for(int i=0; i< numbers.length; i++){
            sum+=numbers[i];
        }
        return sum;
    }
}
