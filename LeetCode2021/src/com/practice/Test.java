package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public int getMinPaint(int[][] existingSeg, int[][] newSeg)
    {
        int minPaint = 0;
        int lenExisting = existingSeg.length, lenNew = newSeg.length;
        int currExist = 0, currNew = 0;
        while(currExist < lenExisting && currNew < lenNew ){
            int[] tmpExist = existingSeg[currExist];
            int[] tmpNew = newSeg[currNew];
            int min = Math.min(tmpExist[0], tmpNew[0]);
            int max = Math.max(tmpExist[1], tmpNew[1]);
            if((tmpExist[1] <= tmpNew[1] && tmpExist[1] >= tmpNew[0]) || (tmpExist[0] >= tmpNew[1] && tmpExist[0] <= tmpNew[1]))
            {
                minPaint += tmpExist[0] - min == 0 ? 0 : tmpExist[0] - tmpNew[0];
                minPaint += tmpExist[1] - max == 0 ? 0 : tmpNew[1] - tmpExist[1];
            }
            else if(tmpExist[0] > tmpNew[1]  || tmpExist[1] < tmpNew[1])
                minPaint += tmpNew[1] - tmpNew[0];

            if(tmpExist[1] < tmpNew[1])
                currExist++;
            else
                currNew++;
        }
        return minPaint;
    }

    public int largestInteger(int num) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        while(num > 0)
        {
            digits.add(0,num%10);
            num /= 10;
            //System.out.println(digits.get(digits.size()-1));
        }
        for(int i = 0; i < digits.size(); i++)
        {
            if(i%2 == 0)
                even.add(digits.get(i));
            else
                odd.add(digits.get(i));
        }
        Collections.sort(even, Comparator.reverseOrder());
        Collections.sort(odd, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        int evenInd = 0, oddInd = 0, index = 0;
        while(evenInd < even.size() || oddInd < odd.size())
        {
            if(evenInd < even.size())
                sb.append(even.get(evenInd++));
            if(oddInd < odd.size())
                sb.append(odd.get(oddInd++));
        }

        int ans = Integer.parseInt(sb.toString());
        return ans;
    }
}
