package com.myjobhunting;
// https://leetcode.com/problems/sparse-matrix-multiplication/

/*
Given two sparse matrices mat1 of size m x k and mat2 of size k x n,
return the result of mat1 x mat2. You may assume that multiplication is always possible.

Example 1:
Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
Output: [[7,0,0],[-7,0,3]]

Example 2:
Input: mat1 = [[0]], mat2 = [[0]]
Output: [[0]]

Constraints:
m == mat1.length
k == mat1[i].length == mat2.length
n == mat2[i].length
1 <= m, n, k <= 100
-100 <= mat1[i][j], mat2[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

class MYPair<U, V>
{
    public final U first;       // the first field of a pair
    public final V second;      // the second field of a pair

    // Constructs a new pair with specified values
    public MYPair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    // Checks specified object is "equal to" the current object or not
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MYPair<?, ?> pair = (MYPair<?, ?>) o;

        // call `equals()` method of the underlying objects
        if (!first.equals(pair.first)) {
            return false;
        }
        return second.equals(pair.second);
    }

    @Override
    // Computes hash code for an object to support hash tables
    public int hashCode()
    {
        // use hash codes of the underlying objects
        return 31 * first.hashCode() + second.hashCode();
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    /*// Factory method for creating a typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }*/

    public U getKey(){
        return this.first;
    }

    public V getValue(){
        return this.second;
    }
}

public class MEDIUM_311_SparseMatrixMultiplication {

    /* Compressed Sparse Row (CSR)
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 43 MB, less than 83.83% of Java online submissions for Sparse Matrix Multiplication.
     */
    class Pair{
        int key;
        int value;
        public Pair(int k, int v)
        {
            this.key = k;
            this.value = v;
        }
        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.value;
        }
    }
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;

        // Store the non-zero values of each matrix.
        List<List<Pair>> A = compressMatrix(mat1);
        List<List<Pair>> B = compressMatrix(mat2);

        int[][] ans = new int[m][n];

        for (int mat1Row = 0; mat1Row < m; ++mat1Row) {
            // Iterate on all current 'row' non-zero elements of mat1.
            for (Pair mat1Element : A.get(mat1Row)) {
                int element1 = mat1Element.getKey();
                int mat1Col = mat1Element.getValue();
                // Multiply and add all non-zero elements of mat2
                // where the row is equal to col of current element of mat1.
                for (Pair mat2Element : B.get(mat1Col)) {
                    int element2 = mat2Element.getKey();
                    int mat2Col = mat2Element.getValue();
                    ans[mat1Row][mat2Col] += element1 * element2;
                }
            }
        }
        return ans;
    }
    public List<List<Pair>> compressMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<List<Pair>> compressedMatrix = new ArrayList<>();

        for (int row = 0; row < rows; ++row) {
            List<Pair> currRow = new ArrayList<>();
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] != 0) {
                    currRow.add(new Pair(matrix[row][col], col));
                }
            }
            compressedMatrix.add(currRow);
        }
        return compressedMatrix;
    }


    /* Approach 2 in LC solution
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 44.8 MB, less than 52.41% of Java online submissions for Sparse Matrix Multiplication.
     */
    public int[][] multiplyLC(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        // Store the non-zero values of each matrix.
        ArrayList<ArrayList<MYPair<Integer, Integer>>> A = compressMatrixLC(mat1);
        ArrayList<ArrayList<MYPair<Integer, Integer>>> B = compressMatrixLC(mat2);

        int[][] ans = new int[m][n];

        for (int mat1Row = 0; mat1Row < m; ++mat1Row) {
            // Iterate on all current 'row' non-zero elements of mat1.
            for (MYPair mat1Element : A.get(mat1Row)) {
                int element1 = (int)mat1Element.getKey();
                int mat1Col = (int)mat1Element.getValue();

                // Multiply and add all non-zero elements of mat2
                // where the row is equal to col of current element of mat1.
                for (MYPair mat2Element : B.get(mat1Col)) {
                    int element2 = (int)mat2Element.getKey();
                    int mat2Col = (int)mat2Element.getValue();
                    ans[mat1Row][mat2Col] += element1 * element2;
                }
            }
        }

        return ans;
    }
    public ArrayList<ArrayList<MYPair<Integer, Integer>>> compressMatrixLC(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        ArrayList<ArrayList<MYPair<Integer, Integer>>> compressedMatrix = new ArrayList<>();

        for (int row = 0; row < rows; ++row) {
            ArrayList<MYPair<Integer, Integer>> currRow = new ArrayList<>();
            for (int col = 0; col < cols; ++col) {
                if (matrix[row][col] != 0) {
                    currRow.add(new MYPair(matrix[row][col], col));
                }
            }
            compressedMatrix.add(currRow);
        }
        return compressedMatrix;
    }


    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 44.8 MB, less than 52.41% of Java online submissions for Sparse Matrix Multiplication.
     */
    public int[][] multiply2(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length, col1 = mat1[0].length, col2 = mat2[0].length;
        int[][] ans = new int[row1][col2];
        for(int row = 0; row < row1; row++){
            for(int i = 0 ; i < col1; i++){
                if(mat1[row][i] != 0){ // If current element of mat1 is non-zero then iterate over all columns of mat2.
                    for(int col = 0 ; col < col2; col++)
                        ans[row][col] += mat1[row][i]* mat2[i][col];
                }
            }
        }
        return ans;
    }

    // swith order, as long as the index is correct, you can change the order of the for loop.
    public int[][] multiply1(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length, col1 = mat1[0].length, col2 = mat2[0].length;
        int[][] ans = new int[row1][col2];
        for(int row = 0; row < row1; row++)
            for(int i = 0 ; i < col1; i++)
                for(int col = 0 ; col < col2; col++)
                    ans[row][col] += mat1[row][i]* mat2[i][col];
        return ans;
    }

    /*
    Runtime: 2 ms, faster than 47.09% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 43 MB, less than 81.72% of Java online submissions for Sparse Matrix Multiplication.
    Time complexity: O(row1⋅col1⋅col2).
    Runtime: 4 ms, faster than 29.13% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 44.9 MB, less than 43.38% of Java online submissions for Sparse Matrix Multiplication.
     */
    public int[][] multiply0(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length, col1 = mat1[0].length, col2 = mat2[0].length;
        int[][] ans = new int[row1][col2];
        for(int row = 0; row < row1; row++)
        {
            for(int col = 0 ; col < col2; col++)
            {
                int sum = 0;
                for(int i = 0 ; i < col1; i++)
                    sum += mat1[row][i]* mat2[i][col];
                ans[row][col] = sum;
            }
        }
        return ans;
    }
}
