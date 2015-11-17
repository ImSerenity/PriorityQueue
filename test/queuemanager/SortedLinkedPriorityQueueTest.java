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
public class SortedLinkedPriorityQueueTest {
    
    public SortedLinkedPriorityQueueTest() {
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
     * Test of add method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() {
        System.out.println("Add Test");
        Object item = "Thomas";
        int priority = 2;
        Object item2 = "James";
        int priority2 = 4;        
        Object item3 = "Ben";
        int priority3 = 1;
        
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        instance.add(item, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
    
        // TODO review the generated test code and remove the default call to fail.
        fail("Can not test due to add function not working.");
    }

    /**
     * Test of head method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("Head Test 1");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        instance.add("Thomas", 2);
        instance.add("James", 4);
        instance.add("Ben", 1);
        instance.head();

        Object expResult = "Ben";
        Object result = instance.head();
        assertEquals(expResult, result);
        System.out.println("Expected: " + expResult + ". " + "Actual: " + result);
    }

    /**
     * Test of remove method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("Remove Test 1");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        instance.add("Thomas", 1);
        instance.add("James", 3);
        System.out.println("Head: " + instance.head());
        instance.remove();
        System.out.println("Head: " + instance.head());
        
        fail("Can't test due to add() function not working");
    }

    /**
     * Test of isEmpty method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println("Values: " + instance.toString());
        System.out.println("Is Empty: " + instance.isEmpty());
    }

    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedLinkedPriorityQueue instance = new SortedLinkedPriorityQueue();
        String expResult = "LinkedStack: size = 0, contents = [], isEmpty() = true";
        String result = instance.toString();
        assertEquals(expResult, result);
    }   
}
