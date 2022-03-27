package com.practice;

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
}
