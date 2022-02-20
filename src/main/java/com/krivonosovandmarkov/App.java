package com.krivonosovandmarkov;

import com.krivonosovandmarkov.task3.Engine;
import com.krivonosovandmarkov.task3.Human;
import com.krivonosovandmarkov.task3.Rocket;

import java.util.Arrays;
import java.util.HashSet;


public class App 
{
    public static void main( String[] args )
    {
        Engine engine = new Engine();
        System.out.println(engine.getSound());
        engine.increaseSound();
        System.out.println(engine.getSound());

        Rocket rocket = new Rocket(new HashSet<>(Arrays.asList(new Human("Форд"), new Human("Артур"))));
        System.out.println(rocket.getTeam());
        //rocket.throwHumanIntoTheVoid("Форд");
        //System.out.println(rocket.getCrew());
    }
}
