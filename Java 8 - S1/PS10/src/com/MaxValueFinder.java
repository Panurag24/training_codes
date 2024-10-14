package com;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class MaxValueFinder extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 1000; // Threshold for splitting the array
    private int[] array;
    private int start;
    private int end;

    public MaxValueFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) { // If array size is less than or equal to the threshold, compute the max value
            int max = Integer.MIN_VALUE;
            int rangeStart = start;
            int rangeEnd = end;
            for (int i = start; i < end; i++) {
                if (array[i] > max) {
                    max = array[i];
                    rangeStart = start;
                    rangeEnd = end;
                }
            }
            System.out.println("Max value found: " + max + ", range: " + rangeStart + "-" + rangeEnd);
            return max;
        } else { 
            int mid = (start + end) / 2;
            MaxValueFinder leftTask = new MaxValueFinder(array, start, mid);
            MaxValueFinder rightTask = new MaxValueFinder(array, mid, end);

            leftTask.fork(); // Fork left task
            int rightResult = rightTask.compute(); // Compute right task
            int leftResult = leftTask.join(); // Join left task

            return Math.max(leftResult, rightResult); // Return the maximum value from the left and right tasks
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10000]; // Create array with 10000 elements
        for (int i = 0; i < 10000; i++) {
            array[i] = i + 1; // Assign values from 1 to 10000 to the array
        }

        ForkJoinPool pool = new ForkJoinPool();
        MaxValueFinder task = new MaxValueFinder(array, 0, array.length);
        int max = pool.invoke(task);

        System.out.println("\nMax value of the array: " + max);
    }
}

