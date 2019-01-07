/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @brief A generic list ADT with elements of type T.
 */
public class GenericList<T>
{
   protected ArrayList<T> s;
   public final static int MAX_SIZE = 100; 
   public GenericList()
   {
     s = new ArrayList<T>();
   }

  /**
   * @brief Inserts an element into the specified location in the list
   * @param i Specified index
   * @param p Element to be inserted
   */
   public void add(int i, T p)
   {
     //check exception for MAX_SIZE
     if (s.size() == MAX_SIZE)
     {
       throw new FullSequenceException("Cannot add to list.  List is full.");
     }
     
     try
     {
       s.add(i, p);
     }
     catch (IndexOutOfBoundsException e)
     {
       throw new InvalidPositionException("Position " + i + " does not exist in the list");
     } 
   }

  /**
   * @brief Deletes an element at the spcified element in the list
   * @param i Specified index
   */
   public void del(int i)
   {
     try
     {
       s.remove(i);
     }
     catch (IndexOutOfBoundsException e)
     {
       throw new InvalidPositionException("Position " + i + " does not exist in the list");
     }
   }

  /**
   * @brief Sets an element at the specified location
   * @param i Specified index
   * @param p Element to be set
   */
   public void setval(int i, T p)
   {
     try
     {
       s.set(i, p);
     }
     catch (IndexOutOfBoundsException e)
     {
       throw new InvalidPositionException("Position " + i + " does not exist in the list");
     }
   }

  /**
   * @brief Gets an element at the specified location
   * @param i Specified index
   */
   public T getval(int i)
   {
     T p;
     try
     {
       p = s.get(i);
     }
     catch (IndexOutOfBoundsException e)
     {
       throw new InvalidPositionException("Position " + i + " does not exist in the list");
     }
     return p;
   }

  /**
   * @brief Returns the size of the list
   */
   public int size()
   {
     return s.size();
   }

  /**
   * @brief Sorts the list
   * @param comp The comparator that will be used to sort the data
   */
   public void sortList(Comparator<T> comp)
   {
     Collections.sort(s, comp);
   }
}