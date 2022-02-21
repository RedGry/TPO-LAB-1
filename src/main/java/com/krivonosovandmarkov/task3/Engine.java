package com.krivonosovandmarkov.task3;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Engine {

    private TypeOfVolume sound = TypeOfVolume.WHISTLE;

    // Увеличение уровня шума
    @SneakyThrows
    public void increaseSound() {
        if (sound.ordinal() + 1 >= TypeOfVolume.values().length) throw new Exception("Громче двигатель не работает!");
        this.sound = TypeOfVolume.values()[sound.ordinal() + 1];
    }

    // Уменьшение уровня шума
    @SneakyThrows
    public void decreaseSound() {
        if (sound.ordinal() - 1 < 0) throw new Exception("Тише двигатель не работает!");
        this.sound = TypeOfVolume.values()[sound.ordinal() - 1];
    }

}
