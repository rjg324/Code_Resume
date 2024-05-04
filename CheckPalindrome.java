/*
Rose Genstein
Visual Studio Code
Lab 4 
02/24/21
Description: The purpose of this activity is to give you additional practice using loops and selection statements.
Assignment: A palindrome is a word or a phrase that is the same when read both forward and backward. Examples are: "bob," "sees," or "never odd or even" (ignoring spaces). Write a program whose input is either a String or an integer, and outputs whether or not the input is a palindrome.  Save the program as CheckPalindrome.java
*/

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        String s;
        System.out.println("Enter a word or digit");
        s = in.nextLine();
        int digit;
        boolean phrase = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                System.out.println("Not a Palindrome");
                break;
            }else{
                System.out.println("It Is a Palindrome");
                break;
            }

        }
    
       //while(digit >= 11 && digit <= 100000){

       }


    }


