/*
 * TP3 - Inteligencia Artificial
 * Daniel Nicolás Allende
 * Arellano, Juan Maía
 * Benitez, Facundo Gabriel
 * Baffari, Nicolás Antonio
 * Asteasuain, Martin
 */
package com.mycompany.mavenproject2;

public class Terminal {

   public static void imprimeMensaje(String mensaje) {
       System.out.print(mensaje + " ");
       System.out.flush();
    }

    public static void imprimeMensaje() {
       System.out.println();
       System.out.flush();
    }       

    public static String leeCadena() {
       int caracter;
       String cadena = "";
       boolean fin = false;
       while (!fin) {
          try {
             caracter = System.in.read();
             if (caracter < 0 || 
                 (char)caracter == '\n')
                fin = true;
             else
                 if (!Character.isISOControl((char)caracter))
                     cadena += (char)caracter; 
          } catch(java.io.IOException e) {  
                fin = true;
          }
       }
       return cadena;
    }
                    
    public static String leeCadena (String mensaje) {
       imprimeMensaje(mensaje);
       return leeCadena();
    }

    public static int leeEntero(String mensaje) {
       while(true) {
          imprimeMensaje(mensaje);
          try {
             return Integer.valueOf(
                   leeCadena().trim()).intValue();
          } catch(NumberFormatException e) {
             System.out.println
                ("ERROR: Vuelve a intentarlo.");
          }
       }
    }

    public static int leeEntero(String mensaje,int minimo) {
         int entero;
         do {
                 entero = leeEntero(mensaje);
                 if (entero < minimo)
                    System.out.println(
                        "#>> ERROR: Valor mínimo = " + minimo);
         } while (entero < minimo);

         return entero;
    }

    public static int leeEntero(String mensaje,int minimo,
                                               int maximo) {
         int entero;
         do {
                 entero = leeEntero(mensaje);
                 if (entero < minimo)
                    System.out.println(
                       "#>> ERROR: Valor mínimo = " + minimo);
                 else if (entero > maximo)
                    System.out.println(
                       "#>> ERROR: Valor maximo = " + maximo);
         } while (entero < minimo || entero > maximo);

         return entero;
    }

    public static double leeReal(String mensaje) {
                  while(true) {
                     imprimeMensaje(mensaje);
                     try {
                        return Double.valueOf(
                              leeCadena().trim()).doubleValue();
                     } catch(NumberFormatException e) {
                        System.out.println
                           ("ERROR: Vuelve a intentarlo.");
                     }
                  }
               }
                
}
                
               
