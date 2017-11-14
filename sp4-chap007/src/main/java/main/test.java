package main;

import chap007.Calculator;
import chap007.RecCalculator;
import chap007.ImpeCalculator;

public class test {

    public static void main(String[] args) {
        Calculator imCalculator = new ImpeCalculator();
        Calculator recCalculator = new RecCalculator();

        System.out.println(imCalculator.factorial(30));



    }
}
