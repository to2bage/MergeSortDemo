package com.algo.merge;

public class ArrayData {

    public int left;        // for render   [left,...
    public int right;       // for render   ..., right]
    public int mi;          // for render   [left, middle] 中的索引i
    public int mj;          // for render   [middle+1, right] 中的索引j

    private int[] datas;

    public ArrayData(int N, int randomBound) {

        this.datas = new int[N];

        for (int i = 0; i < this.datas.length; i++) {

            this.datas[i] = (int)(Math.random() * randomBound) + 1;
        }
    }

    public int length() {
        return this.datas.length;
    }

    public int getData(int index) {
        if (index < 0 || index >= this.datas.length) {
            throw new IllegalArgumentException("index is out of range");
        }
        return this.datas[index];
    }

    public void setData(int index, int value) {
        if (index < 0 || index >= this.datas.length) {
            throw new IllegalArgumentException("index is out of range");
        }
        this.datas[index] = value;
    }

    public void swap(int i, int j) {
        int temp = this.datas[i];
        this.datas[i] = this.datas[j];
        this.datas[j] = temp;
    }
}
