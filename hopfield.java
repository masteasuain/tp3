/*
 * TP3 - Inteligencia Artificial
 * Daniel Nicolás Allende
 * Arellano, Juan Maía
 * Benitez, Facundo Gabriel
 * Baffari, Nicolás Antonio
 * Asteasuain, Martin
 */
package com.mycompany.mavenproject2;

public class hopfield {
    public static void main (String[] args) {
        System.out.println("Modelo de Hopfield: Reconocimiento de patrones");

        /* ***********************************************
        Definicion de los patrones de entrenamiento
        **************************************************/
        System.out.println("--------------------------------------");
        System.out.println("----- Etapa de aprendizaje ---------");
        System.out.println("--------------------------------------");
        // Lectura del tamaño de la matriz patron
        int fil,col;
        System.out.println("Dimension del patron de aprendizaje");
        fil = Terminal.leeEntero("Numero de filas: ");
        col = Terminal.leeEntero("Numero de columnas: ");
        System.out.println("------------------------------");
        // lectura del numero de patrones de entrenamiento
        int M;
        M = Terminal.leeEntero("Numero de patrones de entrenamiento: ");
        System.out.println("--------------------------------------");
        System.out.println("Va a definir "+M+" patrones de entrenamiento de "+fil+" filas y "+col+" columnas cada uno");

        // N --> numero de neuronas de la red: tamaño de los vectores de aprendizaje
        int N = fil*col;

        /* Declaracion de la matriz de Patrones P
        de la forma E[M] = [e1,.., eN] */
        int[][]E = new int[M][N];

        // Lectura de los patrones P[i] para i=0 hasta M patrones
        int i, cont;
        int f,c;
        for (i=0;i<M;i++) {
            cont=0;
            System.out.println("Introduzca un 1 para pixel negro y -1 para pixel blanco");
            System.out.println("Patron num. "+(i+1)+"]");
            for (f=0;f<fil;f++)
                for (c=0;c<col;c++)
                    E[i][cont++] = Terminal.leeEntero("E["+f+"]["+c+"] = ");
        }
        /* ***********************************************
        ETAPA DE APRENDIZAJE
        Algoritmo de Hopfield
        ***********************************************/
        // Definicion de la matriz identidad de tamaño N*N
        int j;
        int [][]I = new int[N][N];
        for (i=0;i<N;i++)
            for (j=0;j<N;j++)
                if (i==j)
                    I[i][j]= 1;
                else
                    I[i][j] = 0;

        /*******************************************************
        Para cada patron calcular la matriz de pesos de acuerdo a
        la formula W = Sum (TE . E - I)
        donde Sum es la sumatoria de
        TE (matriz traspuesta del patron de entrada E) por la
        entrada E menos la matriz identidad I
        W es la matriz de pesos de N*N
        ************************************************* */
        int[][]W = new int[N][N];
        for (i=0;i<M;i++) {
            // Aplicamos el parentesis de la formula anterior
            int [][]T = new int[N][1];
            int [][]Ei = new int[1][N];
            for (j=0;j<N;j++)
                Ei[0][j]= E[i][j];
            matriz.traspuesta(Ei,1,N,T);
            int [][]P = new int[N][N];
            matriz.producto(T,Ei,N,N,1,P);
            int [][]OP = new int[N][N];
            matriz.opuesta(I,N,N,OP);
            int [][]S = new int[N][N];
            matriz.suma(P,OP,N,N,S);
            matriz.suma(W,S,N,N,W);
        }

        /* **********************************************
        ********** ETAPA DE FUNCIONAMIENTO ************
        ***********************************************/
        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println("----- Fase de Funcionamiento -----");
        System.out.println("----------------------------------");
        System.out.println("Introduzca una matriz de entrada de "+fil+" filas y "+col+" columnas");
        System.out.println("Introduzca un 1 para pixel negro y -1 para pixel blanco");
        System.out.println("Entrada: ");
        /* Declaracion de la matriz de entrada Ent
        de la forma Ent = [e1,.., eN] */
        int[][]Ent = new int[1][N];
        // Lectura de la entrada Ent
        cont=0;
        for (f=0;f<fil;f++)
            for (c=0;c<col;c++)
                Ent[0][cont++] = Terminal.leeEntero("Ent["+f+"]["+c+"] = ");

        System.out.print("Calculando salida ");
        // Calcula una nueva salida mientras sea distinta de la anterior salida
        // s(t+1) <> s(t)
        int [][]S = new int[1][N];
        boolean igual=false;
        do {
            System.out.print("..");
            // Aplicacion de la funcion escalon con desplazamiento 0
            matriz.producto(Ent,W,1,4,4,S);
            /* Transformacion de los valores de la salida S a valores discretos 1, -1
            si S[i,j] < 0 entonces S[i,j]= -1
            si S[i,j] >= 0 entonces S[i,j] = +1 */
            for (j=0;j<N;j++)
                if (S[0][j]<0)
                    S[0][j]= -1;
                else
                    S[0][j]= 1;
            // Comparacion de las salidas en t y (t+1)
            if (matriz.iguales(Ent,S,1,4))
                igual=true;
            else
                // La salida es la nueva entrada
                for (j=0;j<N;j++)
                    Ent[0][j] = S[0][j];
        } while (!igual);

        // Impresión de la salida
        System.out.println(" ");
        System.out.println("Salida:");
        for (j=0;j<N;j++) {
            if ((j % col) == 0)
                System.out.println("");
            System.out.print(S[0][j]+ " ");
        }
    }
}

/******** Fin de hopfield.java ************/

