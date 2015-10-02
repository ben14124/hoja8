/*
 * Hoja de trabajo 8
 * Heap
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 */

package hoja8;

import java.util.*;
import java.io.*;

/**
 *
 * @author Daniela
 */
public class Paciente implements Comparable<Paciente> {
    private final String nombre;
    private final String enfermedad;
    private final char letra;
    
    public Paciente(String nombre, String enfermedad, char letra){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.letra = letra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public char getLetra() {
        return letra;
    }

    @Override
    public String toString() {
        return nombre + ", " + enfermedad + ", " + letra;
    }
    
    
    
    @Override
    public int compareTo(Paciente otroPaciente) {
        int mandar = 0;
        char letraOtro = otroPaciente.getLetra();
        if(letra > letraOtro){
            return 1;
            
        }
        else if (letra == letraOtro){
           return 0;
            
        }
        return -1;
    }
}
