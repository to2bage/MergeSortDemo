package com.algo.merge;

import java.awt.*;
import java.util.Arrays;

public class AlgoVisualizer {

    private int DELAY = 180;
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
        this.renderData(0, this.aData.length() - 1, -1, -1);       // render
        mergeSort(0, this.aData.length() - 1);
        this.renderData(0, this.aData.length() - 1, -1, -1);       // render
    }

    // 归并排序: [left, right]
    private void mergeSort(int left, int right) {
        this.renderData(left, right, -1, -1);        // render

        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);

        merge(left, middle, right);
    }

    // 归并区间 [left, middle] 和 [middle + 1, right]
    private void merge(int left, int middle, int right) {

        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            aux[i - left] = this.aData.getData(i);
        }

        int i = left;
        int j = middle + 1;

        this.renderData(left, right, i, j);

        for (int k = left; k <= right; k++) {
            if (i > middle) {
                this.aData.setData(k, aux[j - left]);
                j++;
            } else if (j > right) {
                this.aData.setData(k, aux[i - left]);
                i++;
            } else if (aux[i - left] < aux[j - left]) {
                this.aData.setData(k, aux[i - left]);
                i++;
            } else if (aux[j - left] <= aux[i - left]) {
                this.aData.setData(k, aux[j - left]);
                j++;
            }

            this.renderData(left, right, i, j);
        }
    }

    private void renderData(int left, int right, int mi, int mj) {
        this.aData.left = left;
        this.aData.right = right;
        this.aData.mi = mi;
        this.aData.mj = mj;

        this.frame.render(this.aData);
        AlgoVisHelper.pause(this.DELAY);
    }
}
