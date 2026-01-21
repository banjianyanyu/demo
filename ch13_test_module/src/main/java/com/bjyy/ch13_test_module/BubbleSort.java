package com.bjyy.ch13_test_module;

public class BubbleSort {
    
    /**
     * 冒泡排序 - 升序排列
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSortAsc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 标记是否发生交换，如果没有交换则说明已经排序完成
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果一轮中没有发生交换，提前结束排序
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
    
    /**
     * 冒泡排序 - 降序排列
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
    
    /**
     * 打印数组元素
     * @param arr 数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        printArray(bubbleSortAsc(arr));
        printArray(bubbleSortDesc(arr));
    }
}