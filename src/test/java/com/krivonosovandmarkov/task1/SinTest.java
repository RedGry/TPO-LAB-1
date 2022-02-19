package com.krivonosovandmarkov.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5 * Math.PI, 0, 0.5 * Math.PI, Math.PI, 1.5 * Math.PI, 2 * Math.PI})
    void checkPiDots(double param) {
        assertAll(
                () -> assertEquals(Math.round(Math.sin(param) * 10e3) / 10e3, Sin.calc(param, 100))
        );
    }

    @ParameterizedTest(name = "sin({0}) = {1}")
    @DisplayName("Check between dots [-PI; PI]")
    @CsvFileSource(resources = "/table_values.csv", numLinesToSkip = 1, delimiter = ';')
    void checkBetweenDotsMinusPiAndPi(double x, double y) {
        assertAll(
                () -> assertEquals(y, Sin.calc(x, 100))
        );
    }
}
