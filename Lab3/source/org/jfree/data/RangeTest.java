package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	// -------------------------------Test methods forgetCentralValues()

	@Test
	public void testCentralValueShouldBeZero() {
		//Tests if the central value of -1 and 1 is equal to 0
		rangeObjectUnderTest = new Range(-1, 1);
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueEqualValues() {
		//Tests if the central value of 1 and 1 is equal to 1
		rangeObjectUnderTest = new Range(1, 1);
		assertEquals("The central value of 1 and 1 should be 1", 1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueTwoPositives() {
		//Tests if the central value works with positives
		rangeObjectUnderTest = new Range(1, 3);
		assertEquals("The central value of 1 and 3 should be 2", 2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueNegativeValues() {
		//Tests if the central value works with negatives
		rangeObjectUnderTest = new Range(-3, -1);
		assertEquals("The central value of -3 and -1 should be -2", -2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueNegativeAndZero() {
		//Tests if the central value works with a negative and 0
		rangeObjectUnderTest = new Range(-2, 0);
		assertEquals("The central value of -2 and 0 should be -1", -1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueBothZero() {
		//Tests if the central value works with both parameters being 0
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The central value of 0 and 0 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueZeroAndPositive() {
		//Tests if the central value works with zero and a positive
		rangeObjectUnderTest = new Range(0, 2);
		assertEquals("The central value of 0 and 2 should be 1", 1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueEqualNegativeValues() {
		//Tests if the central value works with double negatives
		rangeObjectUnderTest = new Range(-2, -2);
		assertEquals("The central value of -2 and -2 should be -2", -2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	// ------------------------------- Test methods for constrain(double value)

	@Test
	public void testConstrainValueWithinRange() {
		//Test if the constrain value is within the given range
		rangeObjectUnderTest = new Range(1, 10);
		assertEquals("The constrain value should be 3", 3, rangeObjectUnderTest.constrain(3), 0.000000001d);
	}

	@Test
	public void testConstrainValueAboveRange() {
		//Test if the constrain value is above the given range
		rangeObjectUnderTest = new Range(1, 10);
		assertEquals("The constrain value should be 10", 10, rangeObjectUnderTest.constrain(11), 0.000000001d);
	}
	
	@Test
	public void testConstrainValueBelowRange() {
		//Test if the constrain value is below the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertEquals("The constrain value should be 5", 5, rangeObjectUnderTest.constrain(4), 0.000000001d);
	}

	@Test
	public void testConstrainUpperBoundary() {
		//Test if the constrain value allows the upper boundary of the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertEquals("The constrain value should be 10", 10, rangeObjectUnderTest.constrain(10), 0.000000001d);
	}

	@Test
	public void testConstrainLowerBoundary() {
		//Test if the constrain value allows the lower boundary of the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertEquals("The constrain value should be 5", 5, rangeObjectUnderTest.constrain(5), 0.000000001d);
	}

	@Test
	public void testConstrainNegativeUpperBoundary() {
		//Test if the constrain value allows the negative upper boundary of the given range
		rangeObjectUnderTest = new Range(-10, -5);
		assertEquals("The constrain value should be -5", -5, rangeObjectUnderTest.constrain(-5), 0.000000001d);
	}
	
	@Test
	public void testConstrainNegativeLowerBoundary() {
		//Test if the constrain value allows the negative lower boundary of the given range
		rangeObjectUnderTest = new Range(-5, 5);
		assertEquals("The constrain value should be -5", -5, rangeObjectUnderTest.constrain(-5), 0.000000001d);
	}

	// ------------------- Test methods for getUpperBound()

	@Test
	public void testUpperBoundNegativeAndZero() {
		//Test to find upper bound from a negative and zero range
		rangeObjectUnderTest = new Range(-5, 0);
		assertEquals("The upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundNegativeAndPositive() {
		//Test to find upper bound from a negative and positive range
		rangeObjectUnderTest = new Range(-5, 1);
		assertEquals("The upper bound should be 1", 1, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundTwoZeros() {
		//Test to find upper bound from a two zero range
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundEqualPositives() {
		//Test to find upper bound from two equal positive range
		rangeObjectUnderTest = new Range(5, 5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundEqualNegatives() {
		//Test to find upper bound from two equal negative range
		rangeObjectUnderTest = new Range(-5, -5);
		assertEquals("The upper bound should be -5", -5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundZeroAndPositive() {
		//Test to find upper bound from a zero and positive range 
		rangeObjectUnderTest = new Range(0, 5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}


	// ------------------------------- Test methods for getLowerBound()

	@Test
	public void testLowerBoundNegativeAndZero() {
		//Test to find lower bound from negative and zero range
		rangeObjectUnderTest = new Range(-5, 0);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundNegativeAndPositive() {
		//Test to find lower bound from negative and positive range
		rangeObjectUnderTest = new Range(-5, 1);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundTwoZeros() {
		//Test to find lower bound from a two zero range
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The lower bound should be 0", 0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundEqualPositives() {
		//Test to find lower bound from a two equal positive range
		rangeObjectUnderTest = new Range(5, 5);
		assertEquals("The lower bound should be 5", 5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundEqualNegatives() {
		//Test to find lower bound from a two equal negative range
		rangeObjectUnderTest = new Range(-5, -5);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundZeroAndPositive() {
		//Test to find lower bound from a zero and positive range
		rangeObjectUnderTest = new Range(0, 5);
		assertEquals("The lower bound should be 0", 0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	
	// ---------------------Test methods for intersects(double lower,double upper)

	@Test
	public void testIntersectsOnlyLowerIntersects() {
		//Tests if the double lower parameter of the ROUT intersects with the given range
		rangeObjectUnderTest = new Range(-10, 5);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 6));
	}

	@Test
	public void testIntersectsOnlyUpperIntersects() {
		//Tests if the double upper parameter of the ROUT intersects with the given range
		rangeObjectUnderTest = new Range(-5, 10);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(-6, 1));
	}

	@Test
	public void testIntersectsBothUpperAndLowerIntersect() {
		//Tests if both parameters intersect with the given range
		rangeObjectUnderTest = new Range(1, 15);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 10));
	}

	@Test
	public void testIntersectsBothAboveIntersection() {
		//Tests if both parameters will intersect while being above the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(15,20));
	}
	
	@Test
	public void testIntersectsBothBelowIntersection() {
		//Tests if both parameters will intersect while being below the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(-5,-1));
	}


	@Test
	public void testIntersectsUpperEqual() {
		//Tests if the intersect allows for the upper parameter to be equal with the given range
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(1, 10));
	}
	
	@Test
	public void testIntersectsLowerEqual() {
		//Tests if the intersect allows for the lower parameter to be equal with the given range
		rangeObjectUnderTest = new Range(5, 15);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(5, 10));
	}
	
	@Test
	public void testIntersectsLowerHigherThanUpper() {
		//Tests if the intersect allows for the lower parameter to have a higher value than the upper parameter
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(10,5));
	}


}
