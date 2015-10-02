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
 * Esta clase es utilizada como ficha del paciente e implementa la clase comparable para determinar la prioridad
 */
public class Paciente implements Comparable<Paciente> {
    private final String nombre;
    private final String enfermedad;
    private final char letra;
    
    /**
     * Constructor de clase
     * @param nombre Nombre de un paciente
     * @param enfermedad Enfermedad del paciente
     * @param letra Prioridad de enfermedad
     */
    public Paciente(String nombre, String enfermedad, char letra){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.letra = letra;
    }
    /**
     * Getter nombre
     * @return nombre Nombre de un paciente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter enfermedad
     * @return enfermedad Enfermedad del paciente
     */
    public String getEnfermedad() {
        return enfermedad;
    }
    /**
     * Getter letra
     * @return letra Prioridad de enfermedad
     */
    public char getLetra() {
        return letra;
    }

     /**
     * toString utilizado para imprimir
     * @return nombre + enfermedad + letra
     */   
    @Override
    public String toString() {
        return nombre + ", " + enfermedad + ", " + letra;
    }
    
    
    /**
     * compareTo compara las prioridades de los pacientes
     * @return 1, 0 o -1
     * @param otroPaciente Paciente con el que se compara
     */   
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
