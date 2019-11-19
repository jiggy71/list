package net.ddns;

public class Tests {
    public static void main(String[] args)  {
        Level level = Level.LOW;
        System.out.println(level);
    }
}

enum Level {
    LOW,
    MEDIUM,
    HIGH
}