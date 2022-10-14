package org.example;

import java.util.List;
import java.util.concurrent.*;
public class Cell {
    private boolean alive;
    private final BlockingQueue<Boolean> tick;
    private final BlockingQueue<Boolean> response;
    private final List<BlockingQueue<Boolean>> inChannels;
    private final List<BlockingQueue<Boolean>> outChannels;

    private final CyclicBarrier cyclicBarrier;


    public Cell(boolean alive,
                BlockingQueue<Boolean> tick,
                BlockingQueue<Boolean> response,
                List<BlockingQueue<Boolean>> inChannels,
                List<BlockingQueue<Boolean>> outChannels,
                CyclicBarrier cyclicBarrier) {
        this.alive = alive;
        this.tick = tick;
        this.response = response;
        this.inChannels = inChannels;
        this.outChannels = outChannels;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void start() {
        Thread.startVirtualThread(this::run);
    }

    private void run() {
        while (true) {
            try {
                // awake
                tick.take();
                // notify neighbours
                for (BlockingQueue<Boolean> ch : outChannels) {
                    ch.put(alive);
                }
                // get neighbours state
                int neighbours = 0;
                for (BlockingQueue<Boolean> ch : inChannels) {
                    if (ch.take()) {
                        neighbours++;
                    }
                }
                // calculate and signal next state
                alive = nextGeneration(neighbours);
                response.put(alive);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private boolean nextGeneration(int neighbours) {
        if (alive) {
            return neighbours == 2 || neighbours == 3;
        } else {
            return neighbours == 3;
        }
    }


    public boolean isAlive() {
        return alive;
    }

    public BlockingQueue<Boolean> getTick() {
        return tick;
    }

    public BlockingQueue<Boolean> getResponse() {
        return response;
    }

    public List<BlockingQueue<Boolean>> getInChannels() {
        return inChannels;
    }

    public List<BlockingQueue<Boolean>> getOutChannels() {
        return outChannels;
    }
}
