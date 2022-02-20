package com.krivonosovandmarkov.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorldTest {

    private class TestRocket {

        private Space space;
        private Set<Human> humans;
        private Engine engine;

        @BeforeEach
        void init(){
            space = new Space();
            humans = new HashSet<>(Arrays.asList(new Human("Форд"), new Human("Артур")));
            engine = new Engine();
        }

        @Test
        @DisplayName("Check")
        void checkNegativeFlight(){

        }

    }


}
