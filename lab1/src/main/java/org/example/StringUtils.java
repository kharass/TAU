package org.example;

public class StringUtils {
    public static int sumNumbers(String number){
        int sum=0;
        for(int i=0; i<number.length(); i++){
            sum+=Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return sum;
    }
    public static boolean palindrome(String text){
        text=text.toLowerCase();
        text=text.replaceAll(" ", "");
        String reversedText=reverseString(text);
        return text.equals(reversedText);
    }
    private static String reverseString(String a){
        char b;
        String c = "";
        for(int i=0; i<a.length(); i++){
            b=a.charAt(i);
            c=b+c;
        }
        return c;
    }
}