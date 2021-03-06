package com.myjobhunting;

public class MEDIUM_050_Pow_x_n_ {
    public double myPow(double x, int n) {
        double temp=x;
        if(n==0)
            return 1;
        temp=myPow(x,n/2);
        if(n%2==0)
            return temp*temp;
        else
        {
            if(n > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }
}
