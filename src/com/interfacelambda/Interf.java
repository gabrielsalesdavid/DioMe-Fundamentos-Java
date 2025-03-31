package com.interfacelambda;

public class Interf {

    public static void main(String[] args) {

        MusicPlayer musicPlay = new MusicPlayer() {

            @Override
            public void playMusic() {

                System.out.println("Tocando a musica!");
            }

            @Override
            public void pauseMusic() {
            }

            @Override
            public void stopMusic() {
            }
        };

        MusicPlayer musicPlay02 = new MusicPlayer() {

            @Override
            public void playMusic() {

                System.out.println("Tocando a musica!");
            }

            @Override
            public void pauseMusic() {
            }

            @Override
            public void stopMusic() {
            }
        };

        musicPlay.playMusic();
        System.out.println("1".getClass());
        System.out.println(musicPlay.getClass());
        System.out.println(musicPlay02.getClass());
    }
}