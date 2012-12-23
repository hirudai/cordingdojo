package com.dojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple BowlingScoreTest.
 */
public class BowlingScoreTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BowlingScoreTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BowlingScoreTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	BowlingScore bs = new BowlingScore();

    	assertEquals("9-9-9-9-9-9-9-9-9-9-", 90, bs.getTotalScore("9-9-9-9-9-9-9-9-9-9-") );
        assertEquals("1/2/3/4/5/6/7/8/9/1/2", 147, bs.getTotalScore("1/2/3/4/5/6/7/8/9/1/2") );
          	
        assertEquals("0000000000", 0, bs.getTotalScore("0000000000") );
        assertEquals("/111111111111111111", 29, bs.getTotalScore("/111111111111111111") );
        assertEquals("1111111111111111111/1", 29, bs.getTotalScore("1111111111111111111/1") );
        assertEquals("X111111111111111111", 30, bs.getTotalScore("X111111111111111111") );
        assertEquals("111111111111111111X11", 30, bs.getTotalScore("111111111111111111X11") );       
        assertEquals("XXXXXXXXXXXX", 300, bs.getTotalScore("XXXXXXXXXXXX") );
    }
}
