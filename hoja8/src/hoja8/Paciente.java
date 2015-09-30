/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public int compareTo(Paciente otroPaciente) {
        int mandar = 0;
        char letraOtro = otroPaciente.getLetra();
        if(letra > letraOtro){
            mandar = 1;
        }
        else{
            mandar = 0;
        }
        return mandar;
    }
}
