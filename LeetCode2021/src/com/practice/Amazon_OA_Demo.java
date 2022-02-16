package com.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Eight houses, represented as cells, are arranged in a straight line.
Each day every cell competes with its adjacent cells(neighbors).
An integer values of 1 represents an active cell and a value of 0 represents an inactive cell.

If the neighbors on both the sides of cell are either active or inactive,
the cell becomes inactive on the next day; otherwise the cell becomes active.
The two cells on each end have a single adjacent cell,
so assume that the unoccupied space on the opposite side is an inactive cell.
Even after updating the cell state, consider its previous state when updating the state of other cells.
The state information of all cells should be updated simultaneously.

write an algorithm to output the state of the cells after the given number of days.

input
the input to the function/method consists of 2 arguments:
states, a list of integers representing the current state of cells;
days, an integer representing the number of days.

output
return a list of integers representing the state of the cells after the given number of days.

Note
The elements of the list states contain only 0s and 1s.

[1,0,0,0,0,1,0,0] 1 =>
[0,1,0,0,1,0,1,0]

[1,0,0,0,0,1,0,0] 2 =>
[0,1,0,0,1,0,1,0] -> [1,0,1,1,0,1,0,0]
[1,0,1,1,0,1,0,0]


*/
public class Amazon_OA_Demo {
    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        // [101] 1 -> [000]
        List<Integer> lst = new ArrayList<>(states.length);
        int[] temp = new int[states.length];

        for(int i = 1; i <= days; i++)
        {
            helper(states,temp);
        }

        for(int state: temp)
            lst.add(state);
        return lst;

    }
    // METHOD SIGNATURE ENDS
    public void helper(int[] states,int[] ans)
    {
        for(int i = 0; i < states.length-1;i++)
        {
            if(i == 0 )
                ans[i] = states[i + 1] == 0 ? 0 : 1;
            else if (i == states.length - 1)
                ans[i] = states[i - 1] == 0 ? 1 : 0;
            else
                ans[i] = states[i-1] == states[i+1] && states[i+1] == 0 ? 0 : 1;
        }
        for(int i = 0; i< states.length;i++)
        {
            states[i] = ans[i];
        }
        // last for loop can be replaced with System.arraycopy(ans, 0, states, 0, states.length);
    }
}
