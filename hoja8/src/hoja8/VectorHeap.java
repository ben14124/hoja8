/*
 * Hoja de trabajo 8
 * Heap
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 */


//package hoja8;
import java.util.Vector;


/**
 * Esta clase es utilizada para crear un vectorheap
 */


public class VectorHeap<E extends Comparable<E>> implements PriorityQueue2<E>
{

	protected Vector<E> data; // the data, kept in heap order
/**
 * Construye una nueva priotity queue
 */
	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}
/**
 * Construye una nueva priotity queue con parametro v
 * @param v vector con el cual se inicia queue
 */
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
        
/**
 * Retorn el padre de un nodo en una locacion i
 * @param i Locacion del nodo el cual se busca padre
 */  
        
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}
/**
 * Retorna el index del hijo izquierdo del nodo
 * @param i Locacion del nodo
 */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}
/**
 * Retorna el index del hijo derecho del nodo
 * @param i Locacion del nodo 
 */
	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}
/**
 * Mueve nodo de de la hoja a una posicion
 * @param leaf Hoja 
 */
	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}
/**
 * Se aniade un valor a la queue
 * @param value Valor que se desea agregar 
 */
	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}
/**
 * Mueve un nodo a la posicion a la que deberia de estar
 */
	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}
/**
 * Remueve un valor de queue 
 */
	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}
        
        
/**
 * Retorna el primer valor de la queue
 */        public E getFirst(){
            // pre: !isEmpty()
            // post: returns the minimum value in the priority queue
            return data.get(0);
        }
        
/**
 * Retorna si la queue esta vacia
 */
        public boolean isEmpty(){
            return size() == 0;
        }
/**
* Retorna el tamanio del vector de la queue
*/
        public int size(){
            return data.size();
        }
/**
* Remueve todos los elementos de la queue 
*/
        public void clear(){
            data.clear();
        }
        
}