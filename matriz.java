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

    
} 
