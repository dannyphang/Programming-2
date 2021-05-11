import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        // double smoothness = 0.02;

        // //double x[4],y[4];
        // double[] x = new double[4];
        // double[] y = new double[4];
        
        // //double xt[200], yt[200];
        
        // double[] xt = new double[200];
        // double[] yt = new double[200];
        // double t, ytt = 100;
        // int i;
        // x[0] = 10;
        // x[1] = 50;
        // x[2] = 50;
        // x[3] = 100;
        // y[0] = ytt;
        // y[1] = ytt;
        // y[2] = ytt;
        // y[3] = ytt;
    
        // for (i = 0, t = 0; t <= 1.0; i++, t += smoothness) {
        //     xt[i] = pow((1 - t), 3) * x[0] + 3 * t * pow((1 - t), 2) * x[1] + 3 * pow(t, 2) * (1 - t) * x[2] + pow(t, 3) * x[3];
		// yt[i] = pow((1 - t), 3) * y[0] + 3 * t * pow((1 - t), 2) * y[1] + 3 * pow(t, 2) * (1 - t) * y[2] + pow(t, 3) * y[3];
        // }
        
        // for (i = 0, t = 0; t <= 1.0; i++, t += smoothness) {
        //     System.out.println(i + "--" + "xt: " + xt[i] + ", " + yt[i]);
        // }
        
        int[][] cp = { {10,10},{100,200},{200,50},{300,300} };
	    int[] c = new int[4];
        int k, n = 3;
	    double[] x = new double[4], y = new double[4];
        int u, blend;
        bezierCoefficients(n, c);
        for (u = 0; u < 100; u += 1)
	    {
            //x[u] = 0; y[u] = 0;
            for (k = 0; k < 4; k++)
            {
                blend = c[k] * pow(u, k) * pow(1 - u, n - k);
                x[u] += cp[k][0] * blend;
                y[u] += cp[k][1] * blend;
            }
            
	    }
        
        for (u = 0; u < 100; u += 1){
            System.out.println(u + "-- xu: " + x[u] + ", " + y[u]);
        }
    }

    public static void bezierCoefficients(int n, int[] c)
    {
        int k, i;
        for (k = 0; k <= n; k++)
        {
            c[k] = 1;
            for (i = n; i >= k + 1; i--) {
                c[k] *= i;
            }
                
            for (i = n - k; i >= 2; i--) {
                c[k] /= i;
            }
        }
    }
    
    public static int pow(int u, int k) {
        int temp=1;
        for(;k>0;k--)
        {
            temp*=u;
        }
        return temp;
    }
}
