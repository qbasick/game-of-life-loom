package org.example;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    private final int width;
    private final int height;
    private final boolean[][] cells;

    public Canvas(int width, int height, boolean[][] cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (cells == null)
            return;
        int cellWidth = width / cells[0].length;
        int cellHeight = height / cells.length;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.LIGHT_GRAY);

        // vertical lines
        for (int x = 0; x <= width; x += cellWidth) {
            g.drawLine(x, 0, x, height);
        }
        // horizontal lines
        for (int y = 0; y <= height; y += cellHeight) {
            g.drawLine(0, y, width, y);
        }

        g.setColor(Color.ORANGE);
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[0].length; c++) {
                if (cells[r][c]) {
                    g.fillRect(c * cellWidth, r * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

}
