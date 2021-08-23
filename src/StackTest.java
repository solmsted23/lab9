/*
 * Mike McKee
 * CPSC 5002, Seattle University 
 * This is free an unencumbered software released into public domain. 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

       //needed for junit
import org.junit.jupiter.api.DynamicTest;


/**
 * JUnit testing Stack class. 
 * @author Mike McKee
 *
 */
public class StackTest {
    private static double TOLERANCE = 0.000001;   //constant tolerance number
    
    /**
     * Test method for Constructor.
     */
    @Test
    public void testConstructor() {
        //Testing Stack of Doubles
        // My own comment
        Stack<Double> testDouble = new Stack<>();
        //assertNotNull("Should not be null", testDouble);
        assertNotNull(testDouble, "Should not be null");
        
        //Testing Stack of String 
        Stack<String> testString = new Stack<>();
        assertNotNull( testString,"Should not be null" );
    }

    /**
     * Test method for push.
     */
    @Test
    public void testPush() {
        //Testing Stack of Doubles
        Stack<Double> testDouble = new Stack<>();
        testDouble.push(1.0);
        assertEquals(1.0, testDouble.pop(), TOLERANCE, "Should equal 1.0");
        testDouble.push(2.0);
        assertEquals(2.0, testDouble.pop(), TOLERANCE, "Should equal 2.0");
        testDouble.push(3.0);
        assertEquals(3.0, testDouble.pop(), TOLERANCE);
        
        testDouble.push(1.0);
        testDouble.push(2.0);
        testDouble.push(3.0);
        assertEquals(3.0, testDouble.pop(), TOLERANCE);
        assertEquals( 2.0, testDouble.pop(), TOLERANCE, "Should equal 2.0");
        assertEquals( 1.0, testDouble.pop(), TOLERANCE, "Should equal 1.0");
        
        //Testing Stack of String 
        Stack<String> testString = new Stack<>();
        testString.push("Hello");
        assertEquals("Should equal 'Hello'", "Hello", testString.pop());
        testString.push("World");
        assertEquals("Should equal 'World'", "World", testString.pop());
        testString.push("!");
        assertEquals("Should equal '!'", "!", testString.pop());
        
        testString.push("Hello");
        testString.push("World");
        testString.push("!");
        assertEquals("Should equal '!'", "!", testString.pop());
        assertEquals("Should equal 'World'", "World", testString.pop());
        assertEquals("Should equal 'Hello'", "Hello", testString.pop());
    }

    /**
     * Test method for peek.
     */
    @Test
    public void testPeek() {
        //Testing Stack of Doubles
        Stack<Double> testDouble= new Stack<>();
        testDouble.push(4.0);
        testDouble.push(5.0);
        testDouble.push(6.0);
        assertEquals( 6.0, testDouble.peek(), TOLERANCE, "Should equal 6.0");
        testDouble.pop();
        assertEquals(5.0, testDouble.peek(), TOLERANCE, "Should equal 5.0");
        testDouble.pop();
        assertEquals(4.0, testDouble.peek(), TOLERANCE, "Should equal 4.0");
        
        //Testing Stack of Strings
        Stack<String> testString= new Stack<>();
        testString.push("Hello");
        testString.push("World");
        testString.push("!");
        assertEquals("Should equal '!'", "!", testString.peek());
        assertEquals("Should equal '!'", "!", testString.peek());
        testString.pop();
        assertEquals("Should equal 'World'", "World", testString.peek());
        testString.pop();
        assertEquals("Should equal 'Hello'", "Hello", testString.pop());
    }
    
    /**
     * Test method for when peek method is called on an empty stack.
     */
    @Test
           // (expected = IllegalArgumentException.class)
    public void testPeekThrow() { 
        //Testing Stack of Doubles
        Stack<Double> testDouble= new Stack<>();

        assertThrows(IllegalArgumentException.class, () -> {
                    testDouble.peek();
        });
        
        //Testing Stack of String
        Stack<String> testString= new Stack<>();
        testString.peek();
    }

    /**
     * Test method for pop.
     */
    @Test
    public void testPop() {
      //Testing Stack of Doubles
        Stack<Double> testDouble= new Stack<>();
        testDouble.push(1.0);
        testDouble.push(2.0);
        testDouble.push(3.0);
        assertEquals( 3.0, testDouble.pop(), TOLERANCE, "Should equal 3.0");
        assertEquals(2.0, testDouble.pop(), TOLERANCE, "Should equal 2.0");
        assertEquals(1.0, testDouble.pop(), TOLERANCE, "Should equal 1.0");
        
        testDouble.push(1.0);
        assertEquals(1.0, testDouble.pop(), TOLERANCE,"Should equal 1.0");
        testDouble.push(2.0);
        assertEquals(2.0, testDouble.pop(), TOLERANCE, "Should equal 2.0");
        testDouble.push(3.0);
        assertEquals(3.0, testDouble.pop(), TOLERANCE, "Should equal 3.0");
        
        //Testing Stack of Strings
        Stack<String> testString= new Stack<>();
        testString.push("Hello");
        testString.push("World");
        testString.push("!");
        assertEquals( "!", testString.pop(), "Should equal '!'");
        assertEquals( "World", testString.pop(), "Should equal 'World'");
        assertEquals( "Hello", testString.pop(), "Should equal 'Hello'");
        
        testString.push("Hello");
        assertEquals("Hello", testString.pop(), "Should equal 'Hello'");
        testString.push("World");
        assertEquals("World", testString.pop(), "Should equal 'World'" );
        testString.push("!");
        assertEquals("!", testString.pop(), "Should equal '!'");
    }
    
    /**
     * Test method for when pop method is called on an empty stack.
     */
    @Test
    public void testPopThrow() {
        //Testing Stack of Doubles
        Stack<Double> testDouble= new Stack<>();
        assertThrows(IllegalArgumentException.class, () -> {
            testDouble.pop();
        });

        //Testing Stack of String
        Stack<String> testString= new Stack<>();
        assertThrows(IllegalArgumentException.class, () -> {
            testString.pop();
        });

    }


    /**
     * Test method for empty.
     */
    @Test
    public void testEmpty() {
        //Testing Stack of Doubles
        Stack<Double> testDouble1= new Stack<>();
        assertTrue( testDouble1.empty(), "after construction" );
        testDouble1.push(1.0);
        assertFalse(testDouble1.empty(), "after enqueue"  );
        testDouble1.peek();
        assertFalse( testDouble1.empty(), "peek after enqueue" );
        testDouble1.pop();
        assertTrue( testDouble1.empty(), "after dequeue" );
        
        //Testing Stack of String
        Stack<String> testString1= new Stack<>();
        assertTrue( testString1.empty(), "after construction" );
        testString1.push("Hello");
        assertFalse( testString1.empty(), "after enqueue" );
        testString1.peek();
        assertFalse( testString1.empty(), "peek after enqueue" );
        testString1.pop();
        assertTrue( testString1.empty(), "after dequeue" );
    }

    /**
     * Test method for toString.
     */
    @Test
    public void testToString() {  
        //Testing Stack of Doubles
        Stack<Double> testDouble= new Stack<>();
        assertEquals("Empty", "", testDouble.toString());
        testDouble.push(1.0);
        assertEquals("One element", "1.0", testDouble.toString());
        testDouble.push(2.0);
        assertEquals("Two elements", "2.01.0", testDouble.toString());
        testDouble.push(3.0);
        assertEquals("Three elements", "3.02.01.0", testDouble.toString());
        testDouble.pop();
        assertEquals("Two elements", "2.01.0", testDouble.toString());
        
        Stack<Double> testDouble2 = testDouble.copy();
        assertEquals("Two elements", "2.01.0", testDouble2.toString());
        
        //Testing Stack of String
        Stack<String> testString= new Stack<>();
        assertEquals("Empty", "", testString.toString());
        testString.push("I");
        assertEquals("One element", "I", testString.toString());
        testString.push("Love");
        assertEquals("Two element", "LoveI", testString.toString());
        testString.push("Dogs");
        assertEquals("Three element", "DogsLoveI", testString.toString());
        testString.pop();
        assertEquals("Two elements", "LoveI", testString.toString());
        
        Stack<String> testString2= testString.copy();
        assertEquals("Two elements", "LoveI", testString2.toString());
    }

    /**
     * Test method for copy.
     */
    @Test
    public void testCopy() {
        //Testing Stack of Doubles
        Stack<Double> testDouble1= new Stack<>();
        Stack<Double> testDouble3= new Stack<>();
        assertTrue( testDouble1.equals(testDouble3), "Stack1 and Stack3");
        
        testDouble1.push(1.0);
        testDouble1.push(2.0);
        testDouble1.push(3.0);
        
        Stack<Double> testDouble2 = testDouble1.copy();
        assertNotSame( testDouble1, testDouble2, "Should not be same object");
        assertTrue( testDouble1.equals(testDouble2), "Stack1 and Stack2");
        assertEquals("Stack1 and Stack2", testDouble2.toString(), 
                     testDouble1.toString());
        
        Stack<Double> testDouble4 = testDouble3.copy();
        assertNotSame( testDouble3, testDouble4, "Should not be same object");
        assertTrue( testDouble3.equals(testDouble4), "Stack3 and Stack4");
        
        //Testing Stack of String
        Stack<String> testString1= new Stack<>();
        Stack<String> testString3= new Stack<>();
        assertTrue( testString1.equals(testString3), "Stack1 and Stack3");
        
        testString1.push("I");
        testString1.push("Love");
        testString1.push("Dogs");
        
        Stack<String> testString2 = testString1.copy();
        assertNotSame(testString1, testString2, "Should not be same object" );
        assertTrue( testString1.equals(testString2), "String1 and String2");
        assertEquals("String1 and String2", testString1.toString(), 
                      testString2.toString());
        
        Stack<String> testString4 = testString3.copy();
        assertNotSame( testString3, testString4, "Should not be same object");
        assertTrue( testString3.equals(testString4), "Stack3 and Stack4");
    }

    /**
     * Test method for Equals.
     */
    @Test
    public void testEquals() {
        //Testing Stack of Doubles
        Stack<Double> testDouble1= new Stack<>();
        testDouble1.push(1.0);
        testDouble1.push(2.0);
        testDouble1.push(3.0);
        
        Stack<Double> testDouble2 = testDouble1.copy();
        assertTrue( testDouble1.equals(testDouble2), "Stack1 and Stack2");
        assertTrue( testDouble2.equals(testDouble1), "Stack2 and Stack1");
        
        Stack<Double> testDouble3 = testDouble1.copy();
        testDouble3.push(1.0);
        assertFalse( testDouble1.equals(testDouble3), "Stack1 and Stack3");
        assertFalse( testDouble3.equals(testDouble1), "Stack3 and Stack1");
        
        Stack<Double> testDouble4 = testDouble1.copy();
        Stack<Double> testDouble5 = testDouble1.copy();
        assertTrue( testDouble4.equals(testDouble5), "Stack4 and Stack5");
        
        //Testing Stack of String
        Stack<String> testString1= new Stack<>();
        testString1.push("I");
        testString1.push("Love");
        testString1.push("Dogs");
        
        Stack<String> testString2 = testString1.copy();
        assertTrue( testString1.equals(testString2), "String1 and String2");
        assertTrue(testString2.equals(testString1), "String2 and String1");
        
        Stack<String> testString3= new Stack<>();
        testString1.push("I");
        assertFalse( testString1.equals(testString3), "String1 and String3");
        assertFalse(testString3.equals(testString1), "String3 and String1");
        
        Stack<String> testString4= new Stack<>();
        Stack<String> testString5= new Stack<>();
        assertTrue( testString4.equals(testString5), "String4 and String5");
    }
}
