/*
 * Hoja de trabajo 8
 * Splay trees
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 */

package hoja8;


import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Pocasangre, Juan Diego Benitez
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         boolean hacer = true;
         File file = new File("pacientes.txt");
         int contador = 0;
         int contador1 = 0;
         int lines = 0;

         try {
             BufferedReader br2 = new BufferedReader(new FileReader(file));
             lines = 0;
             while (br2.readLine() != null) lines++;
             br2.close();
         }
         catch (IOException e){

         }
        String palabras[][] = new String[lines][3];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                for(String line; (line = br.readLine()) != null; ){
                    StringBuilder buildpalabrain = new StringBuilder();
                    StringBuilder buildpalabraes = new StringBuilder();
                    StringBuilder buildpalabraChar = new StringBuilder();
                    boolean idioma = true; //Si esta en true, significa que es una palabra en ingles. Si esta en false, es una palabra en espanol.

                    for (int x = 0; x<line.length()-1; x++){ //
                        if (line.charAt(x) != 44){
                            if (idioma==true && contador1 == 0){ //se obtiene char por char para formar palabra
                                char c = line.charAt(x);
                                buildpalabrain.append(c);
                            }
                            if (idioma==false && contador1 == 1){
                                char c = line.charAt(x);
                                buildpalabraes.append(c);
                            }
                            if (idioma ==false && contador1 == 2){
                                char c = line.charAt(x);
                                buildpalabraChar.append(c);
                            }
                        }
                        if (line.charAt(x) == 44){
                            //Si es una coma, se cambia el idioma a espanol porque la palabra que sigue es la traduccion.
                            idioma = false;
                            contador1++;
                        }
                        else {
                            //Si es un espacio, no se agrega
                        }
                    }
                    String palabrain = buildpalabrain.toString();
                    String palabraes = buildpalabraes.toString();
                    String palabraChar = buildpalabraChar.toString();
                    
                    palabras[contador][2] = palabraChar; //agregan palabras en array que contiene en espaniol e ingles
                    palabras[contador][1] = palabrain; //agregan palabras en array que contiene en espaniol e ingles
                    palabras[contador][0] = palabraes;
                    contador++;
                    contador1 = 0;
                }
            }
            catch(IOException ex) {
                
            }
        }
	catch(FileNotFoundException ex) {
            
        }
        for(int x=0; x<contador;x++){
            for(int y=0; y<3; y++){
                System.out.println(palabras[x][y]);
            }
        }
        System.out.println("\n Texto Traducido \n");
    }
}