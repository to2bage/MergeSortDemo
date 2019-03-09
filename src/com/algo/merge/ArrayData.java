package com.algo.merge;

public class ArrayData {

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

    public void swap(int i, int j) {
        int temp = this.datas[i];
        this.datas[i] = this.datas[j];
        this.datas[j] = temp;
    }
}
