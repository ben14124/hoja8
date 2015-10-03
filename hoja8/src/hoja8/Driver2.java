/*
 * Hoja de trabajo 8
 * Heap
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 */

//package hoja8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase utilizada como driver para ejecutar la queue
 * @author Daniela Pocasangre - Juan Diego Benitez
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
        
        VectorHeap<Paciente> cola = new VectorHeap<Paciente>();
        
        for (int x = 0; x<contador; x++){
            cola.add(pacientes[x]);
        }
        System.out.println("Programa de atencion de emergencias\nLos pacientes deben de ser atendidos de la siguiente manera: ");
        while (cola.size() != 0)
        {
            System.out.println(cola.remove());
        }
        
    }
}
