package com.practice;

import java.util.Random;

public class QuickSort2 {

    public static void main(String[] args)
    {
        int[] array = new int[]{6,7,3,5,4};
        QuickSort2 qs2 = new QuickSort2();
        qs2.print(array);
        qs2.quickSort(array);
        qs2.print(array);
    }


    public void quickSort(int[] array)
    {
        quickSort(array, 0, array.length-1);
    }

    private void quickSort(int[] array, int low, int high){
        if(low < high +1)
        {
            int p = partition(array,low, high);
            quickSort(array,low,p-1);
            quickSort(array,p+1,high);
        }
    }

    private void swap(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    // return random pivot index between low and high, inclusive.
    private int getPivot(int low, int high){
        Random rand = new Random();
        return rand.nextInt(high-low+1) + low;
    }

    // moves all the elements n < pivot to the left of the pivot, and
    // all the elements that n > pivot to the right of the pivot.
    private int partition(int[] array, int low, int high){
        swap(array, low, getPivot(low,high));
        int border = low+1;
        for(int i = border; i<=high; i++)
        {
            if(array[i] < array[low])
                swap(array, i, border++);
        }
        swap(array, low, border-1);
        return border-1;
    }

    private void print(int[] arr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i : arr)
            sb.append(i).append(",");

        sb.deleteCharAt(sb.length()-1).append(']');
        System.out.println(sb.toString());
    }
}
