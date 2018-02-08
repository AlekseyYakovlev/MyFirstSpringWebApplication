package ru.spb.yakovlev.spring_one;

/**
 * @author Aleksey Yakovlev on 06.02.2018
 * @project spring_one
 */
public class Sample {

    private static int constructorCounter = 0;
    private int counter = 0;

    public Sample() {
        constructorCounter++;
    }

    public int getConstructorCounter() {
        return constructorCounter;
    }

    public int getCounter() {
        return ++counter;
    }
}
