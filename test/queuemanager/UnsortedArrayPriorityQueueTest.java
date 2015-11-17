/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class UnsortedArrayPriorityQueueTest {
    
    public UnsortedArrayPriorityQueueTest() {
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
     * Test of head method, of class UnsortedArrayPriorityQueue.
     * @throws java.lang.Exception
     */
    @Test
    public void testHead1() throws Exception {
        System.out.println("Head Test 1");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        instance.add("One", 1);
        instance.add("Two", 2);
        instance.head();
        Object expResult = "Two";
        Object result = instance.head();
        assertEquals(expResult, result);
        
        System.out.println("Expected: " + expResult + ". " + "Actual: " + result);
    }
    
    @Test
    public void testHead2() throws Exception {
        System.out.println("Head Test 2");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        instance.add("Three", 3);
        instance.add("Four", 4);
        instance.add("One", 1);
        instance.add("Two", 2);
        instance.head();
        Object expResult = "Four";
        Object result = instance.head();
        assertEquals(expResult, result);
        
        System.out.println("Expected: " + expResult + ". " + "Actual: " + result);
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("Add Test 1");
        Object item = "Thomas";
        int priority = 1;
        Object item2 = "James";
        int priority2 = 3;        
        Object item3 = "Ben";
        int priority3 = 2;
        
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        instance.add(item, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        Object expResult = "[(Thomas, 1), (James, 3), (Ben, 2)]";
        
        Object result = instance.toString();
        assertEquals(expResult, result);
        
        System.out.println("Exp Priority Result: " + expResult + ". Actual: " + result + ".");
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    /* @Test
    public void testRemove1() throws Exception {
    System.out.println("Remove Test 1");
    UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
    instance.add("One", 1);
    instance.add("Two", 2);
    System.out.println("Head: " + instance.head());
    instance.remove();
    System.out.println("Head: " + instance.head());
    }*/

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty Test");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        System.out.println("Values: " + instance.toString());
        System.out.println("Is Empty: " + instance.isEmpty());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2() throws QueueOverflowException {
        System.out.println("isEmpty Test 2");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        instance.add("Thomas", 3);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        System.out.println("Values: " + instance.toString());
        System.out.println("Is Empty: " + instance.isEmpty());
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws QueueOverflowException {
        System.out.println("toString");
        UnsortedArrayPriorityQueue instance = new UnsortedArrayPriorityQueue(10);
        instance.add("Thomas", 2);
        String expResult = "[(Thomas, 2)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
