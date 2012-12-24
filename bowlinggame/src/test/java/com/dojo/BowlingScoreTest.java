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
	
	private BowlingScore bs;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BowlingScoreTest( String testName )
    {
        super( testName );
    }

	protected void setUp() throws Exception{
		bs = new BowlingScore();
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
    }
    
    public void testGutterGame() throws Exception {
        assertEquals("0000000000", 0, bs.getTotalScore("0000000000") );    	
    }
    
	public void testAllOnes() throws Exception {
		assertEquals("11111111111111111111",20, bs.getTotalScore("11111111111111111111"));
	}
    
	public void testAllSpare()throws Exception {
        assertEquals("1/2/3/4/5/6/7/8/9/1/2", 147, bs.getTotalScore("1/2/3/4/5/6/7/8/9/1/2") );		
	}
	
	public void testAllNineGutter() throws Exception{
    	assertEquals("9-9-9-9-9-9-9-9-9-9-", 90, bs.getTotalScore("9-9-9-9-9-9-9-9-9-9-") );	
	}
	
	public void testFirstOneSpare() throws Exception{
        assertEquals("/111111111111111111", 29, bs.getTotalScore("/111111111111111111") );
	}

	public void testLastOneSpare() throws Exception{
        assertEquals("1111111111111111111/1", 29, bs.getTotalScore("1111111111111111111/1") );
	}

	public void testFirstOneStrike() throws Exception{
        assertEquals("X111111111111111111", 30, bs.getTotalScore("X111111111111111111") );
	}

	public void testLastOneStrike() throws Exception{
        assertEquals("111111111111111111X11", 30, bs.getTotalScore("111111111111111111X11") );       
	}

	
	public void testPerfectGame() throws Exception{
        assertEquals("XXXXXXXXXXXX", 300, bs.getTotalScore("XXXXXXXXXXXX") );
	}

}
