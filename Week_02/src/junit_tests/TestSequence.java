package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Sequence;

public class TestSequence {

	@Test
	public void testGetSequence1() {
		String seq = Sequence.getSequence1(3, 2);
		assertEquals("<3, 5, 7, 9, 11>", seq);
	}

	@Test
	public void testGetSum1() {
		int sum = Sequence.getSum1(3, 2);
		assertEquals(35, sum);
	}
	
	@Test
	public void testGetSequence2() {
		String seq = Sequence.getSequence2(3, 2);
		assertEquals("<3, 5, 7, 9, 11>", seq);
	}

	@Test
	public void testGetSum2() {
		int sum = Sequence.getSum2(3, 2);
		assertEquals(35, sum);
	}	
}
