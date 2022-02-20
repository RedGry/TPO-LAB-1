package com.krivonosovandmarkov.task3;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Set;

@Data
public class Space {

    Set<Human> astronauts;
    Set<Rocket> rockets;
    Set<Star> stars;

    // Добавляет нового "космонавта"
    @SneakyThrows
    public void addNewAstronaut(Human human){
        if (this.astronauts.contains(human)) throw new Exception("Этот человек уже летает в космосе!");
        this.astronauts.add(human);
    }

    // Добавляет новую звезду
    @SneakyThrows
    public void addNewStar(Star star){
        if (this.stars.contains(star)) throw new Exception("Такая звезда уже существует!");
        this.stars.add(star);
    }

}
