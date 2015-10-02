/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dbs_jd
 */
public class Driver2 {
    public static void main(String[] args) {
        File file = new File("pacientes.txt");
        int contador = 0;
        int contador1 = 0;
        int lines = 0;
        char prioridad = 'a'; //para guardar la prioridad del paciente
         
        try {
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            lines = 0;
            while (br2.readLine() != null) lines++;
            br2.close();
        }
        catch (IOException e){

        }
        Paciente pacientes[] = new Paciente[lines];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                for(String line; (line = br.readLine()) != null; ){
                    StringBuilder buildpalabrain = new StringBuilder();
                    StringBuilder buildpalabraes = new StringBuilder();
                    StringBuilder buildpalabraChar = new StringBuilder();
                    boolean idioma = true; //Si esta en true, significa que es una palabra en ingles. Si esta en false, es una palabra en espanol.

                    for (int x = 0; x<line.length(); x++){ //
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
                                prioridad = line.charAt(x);
                                prioridad = Character.toUpperCase(prioridad);

                            }
                        }
                        if (line.charAt(x) == 44){
                            x = x+1;
                            //Si es una coma, se cambia el idioma a espanol porque la palabra que sigue es la traduccion.
                            idioma = false;
                            contador1++;
                        }
                        if (line.charAt(x) == 32){
                            //Si es una coma, se cambia el idioma a espanol porque la palabra que sigue es la traduccion.
                        }                        
                        else {
                            //Si es un espacio, no se agrega
                        }
                    }
                    String palabrain = buildpalabrain.toString();
                    String palabraes = buildpalabraes.toString();
                    

                    pacientes[contador] = new Paciente(palabrain, palabraes, prioridad);
                    
                    contador++;
                    contador1 = 0;
                    
                    
                    
                }
            }
            catch(IOException ex) {
                
            }
        }
	catch(FileNotFoundException ex) {
            
        }  
    }
}
