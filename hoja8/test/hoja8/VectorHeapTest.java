/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hoja8;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dbs_jd
 */
public class VectorHeapTest {
    
    public VectorHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirst method, of class VectorHeap.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        VectorHeap instance = new VectorHeap();
        Paciente prueba1 = new Paciente("Prueba 1", "Fiebre", 'D');
        Paciente prueba2 = new Paciente("Prueba 2", "Fractura expuesta", 'B');
        Paciente prueba3 = new Paciente("Prueba 3", "Dolor de cabeza", 'E');
        instance.add(prueba1);
        instance.add(prueba2);
        instance.add(prueba3);
        Object expResult = prueba2;
        System.out.println("Paciente esperado (mayor prioridad): " + prueba2);
        Object result = instance.remove();
        System.out.println("Paciente obtenido: " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
