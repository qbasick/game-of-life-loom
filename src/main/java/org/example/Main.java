package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            int width = 200;
            int height = 200;
            int frameWidth = 800;
            int frameHeight = 600;
            if (args.length != 0) {
                if (args[0].equals("1")) {
                    width = 100;
                    height = 100;
                }
                if (args[0].equals("2")) {
                    width = 500;
                    frameWidth = 1500;
                }
            }


            boolean[][] arr = new boolean[height][width];
            Random random = new Random();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    arr[i][j] = random.nextBoolean();
                }
            }

            WindowFrame frame = new WindowFrame(arr, frameWidth, frameHeight);
            frame.setTitle("Game of Life");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
