package com.krivonosovandmarkov.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    @Nested
    class RocketTest {

        private Space space;
        private Set<Human> humans;
        private Rocket rocket;

        @BeforeEach
        void init() {
            space = new Space();
            humans = new HashSet<>(Arrays.asList(new Human("Форд"), new Human("Артур")));
            rocket = new Rocket(humans);
        }

        @Test
        @DisplayName("Check a really long flight")
        void checkTooBigValueToFly() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(101));
            assertEquals("Топлива не хватит на осуществление полета!", exception.getMessage());
        }

        @Test
        @DisplayName("Check negative value of flight")
        void checkNegativeValueOfFlight() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(-1));
            assertEquals("Нельзя пролететь отрицательное расстояние!", exception.getMessage());
        }

        @Test
        @DisplayName("Check zero value of flight")
        void checkZeroValueOfFlight() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(0));
            assertEquals("Нельзя пролететь отрицательное расстояние!", exception.getMessage());
        }

        @Test
        @DisplayName("Check normal values of flight")
        void checkNormalFlight() {
            assertAll(
                    () -> {
                        rocket.fly(7);
                        assertEquals(93, rocket.getFuel());
                    },
                    () -> {
                        rocket.fly(23);
                        assertEquals(70, rocket.getFuel());
                    },
                    () -> {
                        rocket.fly(70);
                        assertEquals(0, rocket.getFuel());
                    }
            );

            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(0));
            assertEquals("Нельзя пролететь отрицательное расстояние!", exception.getMessage());
        }

        @Test
        @DisplayName("Check max value of speed")
        void checkMaxSpeed() {
            for (int i = 0; i <= 3; i++) rocket.increaseSpeed();
            Throwable exception = assertThrows(Exception.class, () -> rocket.increaseSpeed());
            assertEquals("Громче двигатель не работает!", exception.getMessage());
        }

        @Test
        @DisplayName("Check min value of speed")
        void checkMinSpeed() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.decreaseSpeed());
            assertEquals("Тише двигатель не работает!", exception.getMessage());
        }

        @Test
        @DisplayName("Check different speed")
        void checkDifferentSpeed() {
            rocket.increaseSpeed();
            rocket.increaseSpeed();
            rocket.increaseSpeed();
            rocket.decreaseSpeed();
            rocket.decreaseSpeed();
            assertEquals(100, rocket.getSpeed());
        }

        @Test
        @DisplayName("Check throw human into space")
        void checkThrowingHumanIntoTheSpace() {
            rocket.throwHumanIntoTheSpace("Форд", space);
            assertFalse(rocket.getTeam().contains(new Human("Форд")));
        }

        @Test
        @DisplayName("Check empty team")
        void checkEmptyTeam() {
            humans = new HashSet<>();
            rocket = new Rocket(humans);
            Throwable exception = assertThrows(Exception.class, () -> rocket.throwHumanIntoTheSpace("Елизавета", space));
            assertEquals("На корабле нет экипажа!", exception.getMessage());
        }

        @Test
        @DisplayName("Check no team member")
        void checkNoTeamMember() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.throwHumanIntoTheSpace("Елизавета", space));
            assertEquals("Такого человека нет на борту!", exception.getMessage());
        }
    }

    @Nested
    class SpaceTest {

        private Set<Human> humans;
        private Space space;

        @BeforeEach
        void init() {
            space = new Space();
            humans = new HashSet<>(Arrays.asList(new Human("Форд"), new Human("Артур")));
        }

        @Test
        @DisplayName("Check adding existing astronaut")
        void checkAddExistAstronaut() {
            space.addNewAstronaut(new Human("Лена"));
            Throwable exception = assertThrows(Exception.class, () -> space.addNewAstronaut(new Human("Лена")));
            assertEquals("Этот человек уже летает в космосе!", exception.getMessage());
        }

        @Test
        @DisplayName("Check adding star")
        void checkAddStar() {
            space.addNewStar(new Star(Color.BLUE));
            space.addNewStar(new Star(Color.GREEN));
            space.addNewStar(new Star(Color.RED));
            assertEquals(3, space.getStars().size());
        }

        @Test
        @DisplayName("Check adding existing star")
        void checkAddExistStar() {
            space.addNewStar(new Star(Color.BLUE));
            Throwable exception = assertThrows(Exception.class, () -> space.addNewStar(new Star(Color.BLUE)));
            assertEquals("Такая звезда уже существует!", exception.getMessage());
        }
    }


}
