package by.belohvostik.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic,
                        RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();

        // случайное целое число между 0 и 2
        int randomNumber = random.nextInt(3);

        if (genre == MusicGenre.CLASSICAL) {
            // случайная классическая песня
            System.out.println(classicalMusic.getSongs().get(randomNumber));
        } else {
            // случайная рок песня
            System.out.println(rockMusic.getSongs().get(randomNumber));
        }
    }
}
