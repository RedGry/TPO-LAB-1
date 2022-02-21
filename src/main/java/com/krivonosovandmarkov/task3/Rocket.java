package com.krivonosovandmarkov.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Set;

@Getter
public class Rocket {

    private Set<Human> team;
    private Engine engine = new Engine();
    private Integer fuel = 100;
    private Integer speed = 0;

    public Rocket(Set<Human> team){
        this.team = team;
    }

    // Совершить полет
    @SneakyThrows
    public void fly(int value) {
        if (value <= 0) throw new Exception("Нельзя пролететь отрицательное расстояние!");
        if (this.fuel - value < 0) throw new Exception("Топлива не хватит на осуществление полета!");
        this.increaseSpeed();
        this.fuel -= value;
        this.decreaseSpeed();
    }

    //Увеличить скорость
    public void increaseSpeed() {
        this.engine.increaseSound();
        this.speed += 100;
    }

    //Увеличить скорость
    public void decreaseSpeed() {
        this.engine.decreaseSound();
        this.speed -= 100;
    }

    // Выбросить человека в космос
    @SneakyThrows
    public void throwHumanIntoTheSpace(String name, Space space){
        if (this.team.isEmpty()) throw new Exception("На корабле нет экипажа!");
        Human teammate = this.team.stream().filter(new Human(name)::equals).findAny()
                .orElseThrow(() -> new Exception("Такого человека нет на борту!"));
        space.addNewAstronaut(teammate);
        this.team.remove(teammate);
    }

}
