package com.dojo.gameoflife;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LifeGameTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LifeGameTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LifeGameTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLifeGameTextParser()
    {
    	String str = "Generation 2:\n4 8\n........\n...**...\n...**...\n........\n";
    	LifeGameInfoParserInterface parser = new LifeGameInfoTextParser();
    	LifeGame game = new LifeGame();
    	game.setParser(parser);
    	game.initGame();
    	LifeInfo next = game.nextGeneration();
        assertEquals(str, next.toString());
    }
}
