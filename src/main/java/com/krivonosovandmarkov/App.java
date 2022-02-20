package com.krivonosovandmarkov;

import com.krivonosovandmarkov.task1.Sin;
import com.krivonosovandmarkov.task3.Engine;


public class App 
{
    public static void main( String[] args )
    {
        Engine engine = new Engine();
        System.out.println(engine.getSound());
        engine.increaseSound();
        System.out.println(engine.getSound());
        System.out.println(Sin.calc(50, 100));
    }
}
