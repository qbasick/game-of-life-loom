package org.example;

public class PatternParser {

    static boolean[][] parse(String pattern) {
        String[] lines = pattern.split("\n");
        boolean[][] cells = new boolean[lines.length][lines[0].length()];
        for (int r = 0; r < lines.length; r++) {
            for (int c = 0; c < lines[r].length(); c++) {
                if (lines[r].charAt(c) == '*') {
                    cells[r][c] = true;
                }
            }
        }
        return cells;
    }

    static boolean[][] pad(boolean[][] cells, int left, int top, int right, int bottom) {
        boolean[][] padded = new boolean[cells.length + top + bottom][cells[0].length + left + right];
        for (int r = 0; r < cells.length; r++) {
            System.arraycopy(cells[r], 0, padded[r + top], left, cells[r].length);
        }
        return padded;
    }

    static boolean[][] templateToSize(boolean[][] cells, int width, int height) {
        int curWidth = cells.length;
        int curHeight = cells[0].length;
        int diffH = width - curWidth;
        int diffW = height - curHeight;
        assert diffH > 0;
        assert diffW > 0;

        int left = diffW / 2;
        int top = diffH / 2;
        int right = diffW % 2 == 0 ? left : left + 1;
        int bottom = diffH % 2 == 0 ? top : top + 1;

        return pad(cells, left, top, right, bottom);
    }
}
