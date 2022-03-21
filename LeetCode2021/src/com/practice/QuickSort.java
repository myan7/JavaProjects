package com.practice;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        numbers = new int[]{6, 91, 11, 55, 19, 29, 99, 21, 61, 4};
        //[27,79,65,54,27,10,54,82,93,11]
        print(numbers);
        quickSort(numbers);
        print(numbers);

    }

    private static void quickSort(int[] array)
    {
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array, int lowIndex, int highIndex)
    {
        if(lowIndex >=  highIndex)
            return;
        int pivotIndex = new Random().nextInt(highIndex-lowIndex)+lowIndex;
        int pivot = array[pivotIndex];
        // swap the pivot with the rightmost element
        swap(array,pivotIndex,highIndex);

        int leftPointer = partition(array, lowIndex,highIndex,pivot);
        //swap(array,leftPointer,pivotIndex);

        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);
    }


    private static int partition(int[] array, int lowIndex, int highIndex, int pivot)
    {
        int leftPointer = lowIndex;
        int rightPointer = highIndex-1; // right pointer is the left one to the pivot, which is the right most element of the (sub) array.
        while( leftPointer < rightPointer)
        {
            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while(array[leftPointer] <= pivot && leftPointer < rightPointer)
                leftPointer++;
            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while(array[rightPointer] >= pivot && leftPointer < rightPointer)
                rightPointer--;
            // this is to make sure all elements on the left, is smaller than pivot, and larger on the right
            swap(array,leftPointer,rightPointer);
        }

        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order.
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        if(array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2)
    {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void print(int[] arr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i : arr)
            sb.append(i).append(",");

        sb.deleteCharAt(sb.length()-1).append(']');
        System.out.println(sb.toString());
    }
}
