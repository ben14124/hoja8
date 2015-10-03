/*
 * Hoja de trabajo 8
 * Heap
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 */


//package hoja8;

/**
 * Esta clase es utilizada como interfaz de la priotiry queue
 */

public interface PriorityQueue2<E extends Comparable<E>>
{
    /**
     * Retorna el valor minimo en la priotiry queue
     * @return 
     */
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
    /**
     * Retorna y remueve el valor minimo en la priotiry queue
     * @return 
     */
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
    /**
     * Aniade un valor en la priotiry queue
     * 
     * @param value
     */
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
    /**
     * Retorna true si el la cola no tiene elementos
     * @return 
     */
        public boolean isEmpty();
	// post: returns true iff no elements are in queue
    /**
     * Retorna el valor de elementos
     * @return 
     */	
	public int size();
	// post: returns number of elements within queue
    /**
     * Remueve todos los elementos 
     */	
        public void clear();
	// post: removes all elements from queue
}