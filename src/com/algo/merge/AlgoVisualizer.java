package com.algo.merge;

import java.awt.*;

public class AlgoVisualizer {

    private int DELAY = 40;
    private ArrayData aData;
    private AlgoFrame frame;

    public AlgoVisualizer(int N, String title, int sceneWidth, int sceneHeight) {

        this.aData = new ArrayData(N, sceneHeight);

        EventQueue.invokeLater(() -> {
            this.frame = new AlgoFrame(title, sceneWidth, sceneHeight);
            new Thread(() -> {
                this.run();
            }).start();
        });
    }

    private void run() {
        mergeSort(0, this.aData.length() - 1);
    }

    // 归并排序: [left, right]
    private void mergeSort(int left, int right) {

    }

    private void renderData() {
        this.frame.render(this.aData);
        AlgoVisHelper.pause(this.DELAY);
    }
}
