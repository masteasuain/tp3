/*
 * TP3 - Inteligencia Artificial
 * Daniel Nicolás Allende
 * Arellano, Juan Maía
 * Benitez, Facundo Gabriel
 * Baffari, Nicolás Antonio
 * Asteasuain, Martin
 */

package com.mycompany.mavenproject2;

public class matriz {

    public static void traspuesta(int [][]A,int f,int c,int [][]T) {
        int i,j;
        for (i=0;i<f;i++)
            for (j=0;j<c;j++)
                T[j][i]=A[i][j];
    }

    public static void producto(int [][]A,int [][]B, int Af, int Bc, int cf,int [][]P) {
        int i,j,k;
        for (i=0;i<Af;i++)
            for (j=0;j<Bc;j++)
                for (k=0;k<cf;k++)
                    P[i][j] += A[i][k] * B[k][j];
    }

    public static void opuesta(int [][]A ,int f, int c,int [][]OP) {
        int i,j;
        for (i=0;i<f;i++)
            for (j=0;j<c;j++)
                OP[i][j]=-A[i][j];
    }

    public static void suma(int [][]A,int [][]B,int f, int c,int [][]S) {
        int i,j;
        for (i=0;i<f;i++)
            for (j=0;j<c;j++)
                S[i][j]=A[i][j] + B[i][j];
    }

    public static boolean iguales(int [][]A,int [][]B, int f, int c) {
        int i,j;
        boolean igual=true;
        for (i=0;i<f;i++)
            for (j=0;j<c;j++)
                if (A[i][j]!= B[i][j])
                    return (false);
        return (igual);
    }

    public static int posminimo(double []A) {
        int i, pos=0, size;
        double valminimo;

        valminimo= A[0];
        size= A.length;
        for (i=1;i<size;i++)
            if (valminimo > A[i]) {
                valminimo=A[i];
                pos=i;
            }
        return (pos);
    }

    public static void R_Gauss(double [][]M,int f,int c,int x, int y) {

        int i,j,m;
        double k;
        double []B= new double [f];

        for (i=0;i<f;i++)
            if (i==x) 
                continue;
            else {
                for (m=0;m<f;m++)
                    B[m]= M[m][y];
                k= - M[i][y];

                for (j=0;j<c;j++)
                    M[i][j] += -M[x][j] * B[i];
            } 
    }

    public static void Gauss(double [][]M,int f,int c) {

        int i,j,k;
        double []B= new double [c];

        for (i=0;i<(f-1);i++)
            for (k=i+1;k<f;k++){
                for (j=0;j<c;j++)
                    B[j]= -M[k][i]* M[i][j] + M[i][i]*M[k][j];
                for (j=0;j<c;j++)
                    M[k][j] = B[j];
            }
    }

} 
