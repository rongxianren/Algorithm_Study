package com.rongxianren.algorithm.recurion;

/**
 * 0-1背包问题
 * 我们有一个背包，背包的总容量是Wkg。现在我们有n个物品，每个物品的重量不等，
 * 并且不可分割。我们现在期望选几件物品，装载到背包中。在不超过背包所能装载
 * 重量的前提下，如何让背包的总重量最大？
 */
public class Package01Question {

    private static int mMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] datas = new int[]{10, 7, 9, 8, 9, 8, 11};
        int capacity = 32;
        findMaxCapacity(datas, 0, capacity, 0);
        System.out.println("max capacity = " + mMax);
    }

    /**
     * @param datas           物品集合
     * @param currentWeight   当前放进背包物品的总重量
     * @param packageCapacity 背包的总容量
     * @param index           当前准备处理的物品的下标
     */
    private static void findMaxCapacity(int[] datas, int currentWeight, int packageCapacity, int index) {
        if (datas == null || datas.length == 0) {
            return;
        }

        if (currentWeight > mMax) {
            mMax = currentWeight;
        }

        if (index == datas.length || currentWeight == packageCapacity) {
            return;
        }
        findMaxCapacity(datas, currentWeight, packageCapacity, index + 1);

        if (currentWeight + datas[index] <= packageCapacity) {
            findMaxCapacity(datas, currentWeight + datas[index], packageCapacity, index + 1);
        }
    }
}
