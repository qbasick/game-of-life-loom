package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class GameOfLife {
    private final Cell[][] cells;
    private final boolean[][] currentGrid;
    private final boolean[][] nextGrid;
    private final int width;
    private final int height;
    private volatile boolean paused = true;
    private volatile boolean stopped = false;

    private volatile long timeout = 500L;

    BlockingQueue<Boolean>[][] ticks;
    BlockingQueue<Boolean>[][] responses;
    CyclicBarrier cyclicBarrier;
    private Thread worker;

    private final Runnable r;
    public GameOfLife(boolean[][] currentGrid, Runnable r) {
        this.currentGrid = currentGrid;
        this.width = currentGrid.length;
        this.height = currentGrid[0].length;

        ticks = new BlockingQueue[width][height];
        responses = new BlockingQueue[width][height];
        cells = new Cell[width][height];
        nextGrid = new boolean[width][height];
        this.r = r;
        Runnable runnable = () -> {
            updateGrid();
            r.run();
        };
        cyclicBarrier = new CyclicBarrier(width * height + 1, runnable);
        initCell();
        initChannels();
    }


    public void start() {
        Arrays.stream(cells).forEach(row -> {
            Arrays.stream(row).forEach(Cell::start);
        });
        worker = new Thread(this::run);
        worker.start();
    }

    public void stop() {
        stopped = true;
        paused = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public void pause() {
        synchronized (this) {
            this.paused = !this.paused;
            notifyAll();
        }
    }
    public void run() {
        while (!stopped) {
            try {
                while (paused) {
                    synchronized (this) {
                        wait();
                    }
                }
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        ticks[i][j].put(true);
                    }
                }
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        nextGrid[i][j] = responses[i][j].take();
                    }
                }
                cyclicBarrier.await();
                if (timeout > 50L) {
                    Thread.sleep(timeout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void initRandom() {
        reinitialize();
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                currentGrid[i][j] = random.nextBoolean();
            }
        }
        restart();
    }
    public void initTemplate() {
        reinitialize();
        boolean[][] template = PreparedTemplates.getRandomTemplate(width, height);
        for (int i = 0; i < width; i++) {
            if (height >= 0) System.arraycopy(template[i], 0, currentGrid[i], 0, height);
        }
        restart();
    }

    private void reinitialize() {
        stop();
        // wait for worker thread to complete cycles and finish
        try {
            worker.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        stopped = false;
        paused = true;
    }

    private void restart() {
        initCell();
        initChannels();
        r.run(); // rerender board
        start();
    }
    private void initCell() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boolean alive = currentGrid[i][j];
                BlockingQueue<Boolean> tick = new ArrayBlockingQueue<>(1);
                ticks[i][j] = tick;
                BlockingQueue<Boolean> response = new ArrayBlockingQueue<>(1);

                responses[i][j] = response;
                List<BlockingQueue<Boolean>> inChannels = new ArrayList<>();
                List<BlockingQueue<Boolean>> outChannels = new ArrayList<>();
                Cell cell = new Cell(alive, tick, response, inChannels, outChannels, cyclicBarrier);
                cells[i][j] = cell;
            }
        }
    }

    private void initChannels() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (Cell neighbour : neighbours(i, j)) {
                    BlockingQueue<Boolean> channel = new ArrayBlockingQueue<>(1);
                    cells[i][j].getInChannels().add(channel);
                    neighbour.getOutChannels().add(channel);
                }
            }
        }
    }

    private List<Cell> neighbours(int i, int j) {
        List<Cell> res  = new ArrayList<>();
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                if (a == 0 && b == 0) { continue;}
                res.add(cells[Math.floorMod(i + a, width)][Math.floorMod(j + b, height)]);
            }
        }
        return res;
    }

    private void updateGrid() {
        for (int i = 0; i < width; i++) {
            if (height >= 0) System.arraycopy(nextGrid[i], 0, currentGrid[i], 0, height);
        }
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
