package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {
	
	private static AthleticGame game;
	
	@BeforeClass
	public static void init() {
		game = new AthleticGame("100_metri");
	}

	@After
	public void resetWorks() {
		game.reset();
	}
	
	@Before
	public void startWorks() {
		game.start();
	}
	
	@Test
	public void getWinnerTest1() {
		game.addArrival("giovanni", Instant.now().plusMillis(1000));
		game.addArrival("tonino", Instant.now().plusMillis(2000));
		game.addArrival("franco", Instant.now().plusMillis(3000));
		game.addArrival("ElMacro", Instant.now().plusMillis(4000));
		
		System.out.println(game.getWinner());
		Assert.assertEquals("giovanni", game.getWinner());
	}
	
	@Test 
	public void getWinnerTest2() {
		Assert.assertEquals(null, game.getWinner());
	}
}