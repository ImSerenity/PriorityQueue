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
public class UnsortedLinkedPriorityQueueTest {
    
    public UnsortedLinkedPriorityQueueTest() {
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
     * Test of add method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("Add Test 1");
        Object item = "Thomas";
        int priority = 1;
        Object item2 = "James";
        int priority2 = 4;
        Object item3 = "Ben";
        int priority3 = 3;
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add(item, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        
        Object expResult = "LinkedStack: size = 3, contents = [Ben], James], Thomas], isEmpty() = false, head() = ";
        Object result = instance.toString();
        
        assertEquals(expResult, result);
        System.out.println(instance.toString());
    }
    
    @Test
    public void testAdd2() throws Exception {
        System.out.println("Add Test 2");
        Object item = "Thomas";
        int priority = 3;
        Object item2 = "James";
        int priority2 = 2;
        Object item3 = "Ben";
        int priority3 = 1;
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add(item, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        
        Object expResult = "LinkedStack: size = 3, contents = [Ben], James], Thomas], isEmpty() = false, head() = ";
        Object result = instance.toString();
        
        assertEquals(expResult, result);
        System.out.println(instance.toString());
    }

    @Test
    public void testAdd3() throws Exception {
        System.out.println("Add Test 3");
        Object item = "Thomas";
        int priority = 3;
        Object item2 = "James";
        int priority2 = 2;
        Object item3 = "Ben";
        int priority3 = 1;
        Object item4 = "FourthName";
        int priority4 = 7;
        Object item5 = "FifthName";
        int priority5 = 9;
        Object item6 = "SixthName";
        int priority6 = 5;
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add(item, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
        instance.add(item6, priority6);
        
        Object expResult = "LinkedStack: size = 6, contents = [SixthName], FifthName], FourthName], Ben], James], Thomas], isEmpty() = false, head() = ";
        Object result = instance.toString();
        
        assertEquals(expResult, result);
        System.out.println(instance.toString());
    }
    /**
     * Test of head method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add("Thomas", 2);
        instance.add("James", 4);
        instance.add("Ben", 1);
        Object expResult = "James";
        Object result = instance.head();
        assertEquals(expResult, result);

    }

    /**
     * Test of remove method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("Remove Test 1");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add("Thomas", 1);
        instance.add("James", 3);
        System.out.println("Head Before: " + instance.head());
        instance.remove();
        System.out.println("Head After: " + instance.head());
        Object expResult = "Thomas";
        Object result = instance.head();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty Test 1");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println(instance.toString());
    }
    
    @Test
    public void testIsEmpty2() throws QueueOverflowException {
        System.out.println("isEmpty Test 2");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add("Thomas", 2);       
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println(instance.toString());
    }

    /**
     * Test of toString method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString Test");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        String expResult = "LinkedStack: size = 0, contents = [, isEmpty() = true";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString2() throws QueueOverflowException {
        System.out.println("toString Test 2");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        instance.add("Thomas", 3);
        String expResult = "LinkedStack: size = 1, contents = [Thomas], isEmpty() = false, head() = ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
