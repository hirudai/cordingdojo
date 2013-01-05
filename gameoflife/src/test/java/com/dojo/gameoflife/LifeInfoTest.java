package com.dojo.gameoflife;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LifeInfoTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LifeInfoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LifeInfoTest.class );
    }

	public void testToStringFormat() throws Exception{
		String str = "Generation 1:\n4 8\n........\n....*...\n...**...\n........\n";
		LifeInfo li  = new LifeInfo();
		li.setGeneration(1);
		li.setMatColCount(8);
		li.setMatRowCount(4);
		li.initLifeMatrix();
		for(int i = 0 ; i < li.getMatRowCount() ; i++ ){
			for (int j = 0 ; j < li.getMatColCount() ; j++ ){
				li.getLifeMatrix()[i][j] = '.';
			}
		}
		li.getLifeMatrix()[1][4] = '*';
		li.getLifeMatrix()[2][3] = '*';
		li.getLifeMatrix()[2][4] = '*';
		
		assertEquals(str, li.toString());
	}
}
