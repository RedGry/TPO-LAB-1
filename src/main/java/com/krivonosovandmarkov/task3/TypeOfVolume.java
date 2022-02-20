package com.krivonosovandmarkov.task3;

public enum TypeOfVolume {
    WHISTLE(1), // Свист
    RUSTLE(2), // Шорох
    CLANG(3), // Лязг
    NOISE(4), // Шум
    ROAR(5); //РЕВ

    private final int volume;

    TypeOfVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
