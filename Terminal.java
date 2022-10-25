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

    
                
}
                
               
