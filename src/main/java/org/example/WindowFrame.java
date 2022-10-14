package org.example;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    private Canvas canvas;
    private final GameOfLife game;
    private final boolean[][] cells;
    private final int width;
    private final int height;

    public WindowFrame(boolean[][] cells, int width, int height) {
        this.cells = cells;
        game = new GameOfLife(cells, () -> canvas.repaint());
        this.width = width;
        this.height = height;
        init();
        game.start();

        this.setSize(width + 50, height + 150);
    }

    private void init() {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        Dimension fillSize = new Dimension(width, 10);
        this.add(new Box.Filler(fillSize, fillSize, fillSize));

        JPanel controlPanel = getControlPanel();
        controlPanel.setPreferredSize(new Dimension(width, 5));
        this.add(controlPanel);


        this.add(new Box.Filler(fillSize, fillSize, fillSize));

        JLabel sliderLabel = new JLabel("Animation speed");
        sliderLabel.setAlignmentX(0.4f);
        this.add(sliderLabel);

        this.add(new Box.Filler(fillSize, fillSize, fillSize));

        JSlider slider = new JSlider(1, 100);
        slider.addChangeListener(changeEvent -> game.setTimeout(1000 - 10L * slider.getValue()));

        slider.setMaximumSize(new Dimension(width / 4, 5));
        this.add(slider);

        this.add(new Box.Filler(fillSize, fillSize, fillSize));

        JPanel alignedCanvas = getAlignedCanvas();
        this.add(alignedCanvas);

        addListenersToButtons(controlPanel);
    }

    private JPanel getAlignedCanvas() {
        JPanel alignedCanvas = new JPanel();

        int adjustedWidth = (width / cells[0].length) * cells[0].length;
        int adjustedHeight = (height / cells.length) * cells.length;

        canvas = new Canvas(adjustedWidth, adjustedHeight, cells);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setAlignmentX(0.5f);
        alignedCanvas.add(canvas);
        return alignedCanvas;
    }

    private JPanel getControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 7));

        JButton play = new JButton("Play");
        JButton template = new JButton("Random board");
        JButton restart = new JButton("Pretty board");

        controlPanel.add(new JPanel());
        controlPanel.add(play);
        controlPanel.add(new JPanel());
        controlPanel.add(template);
        controlPanel.add(new JPanel());
        controlPanel.add(restart);
        controlPanel.add(new JPanel());

        return controlPanel;
    }

    private void addListenersToButtons(JPanel controlPanel) {
        Component[] buttons = controlPanel.getComponents();
        ((JButton)buttons[1]).addActionListener(event -> {
            if (((JButton) buttons[1]).getText().equals("Play")) {
                game.pause();
                ((JButton)buttons[1]).setText("Pause");
            } else {
                game.pause();
                ((JButton)buttons[1]).setText("Play");
            }
        });
        ((JButton)buttons[3]).addActionListener(event -> {
            game.initRandom();
            ((JButton)buttons[1]).setText("Play");
        });

        ((JButton)buttons[5]).addActionListener(event -> {
            game.initTemplate();
            ((JButton)buttons[1]).setText("Play");
        });
    }

}
