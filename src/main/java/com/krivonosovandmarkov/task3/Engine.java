package com.krivonosovandmarkov.task3;

public class Engine {

    TypeOfVolume sound = TypeOfVolume.WHISTLE;

    public void increaseSound() {
        this.sound = TypeOfVolume.values()[sound.ordinal() + 1];
    }

    public TypeOfVolume getSound(){
        return this.sound;
    }

}
