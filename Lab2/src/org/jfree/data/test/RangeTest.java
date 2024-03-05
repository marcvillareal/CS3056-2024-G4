package org.jfree.data.test;

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
		rangeObjectUnderTest = new Range(-1, 1);
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueEqualValues() {
		rangeObjectUnderTest = new Range(1, 1);
		assertEquals("The central value of 1 and 1 should be 1", 1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueTwoPositives() {
		rangeObjectUnderTest = new Range(1, 3);
		assertEquals("The central value of 1 and 3 should be 2", 2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueNegativeValues() {
		rangeObjectUnderTest = new Range(-3, -1);
		assertEquals("The central value of -3 and -1 should be -2", -2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueNegativeAndZero() {
		rangeObjectUnderTest = new Range(-2, 0);
		assertEquals("The central value of -2 and 0 should be -1", -1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueNegativeAndPositive() {
		rangeObjectUnderTest = new Range(-1, 2);
		assertEquals("The central value of -1 and 2 should be 1", 1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueBothZero() {
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The central value of 0 and 0 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueZeroAndPositive() {
		rangeObjectUnderTest = new Range(0, 2);
		assertEquals("The central value of 0 and 2 should be 1", 1, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testCentralValueEqualNegativeValues() {
		rangeObjectUnderTest = new Range(-2, -2);
		assertEquals("The central value of -2 and -2 should be -2", -2, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	// ------------------------------- Test methods for constrain(double value)

	@Test
	public void testConstrainEqualsLowerRange() {
		assertEquals("The constrain value should be 3", 3, rangeObjectUnderTest.constrain(2), 0.000000001d);
	}

	@Test
	public void testConstrainEqualsUpperRange() {
		assertEquals("The constrain value should be 5", 5, rangeObjectUnderTest.constrain(10), 0.000000001d);
	}
	
	@Test
	public void testConstrainLowerBoundary() {
		assertEquals("The constrain value should be 5", 5, rangeObjectUnderTest.constrain(5), 0.000000001d);
	}

	@Test
	public void testConstrainUpperBoundary() {
		assertEquals("The constrain value should be 10", 10, rangeObjectUnderTest.constrain(10), 0.000000001d);
	}

	@Test
	public void testConstrainNegativeLowerBoundary() {
		assertEquals("The constrain value should be -10", -10, rangeObjectUnderTest.constrain(-10), 0.000000001d);
	}

	@Test
	public void testConstrainNegativeUpperBoundary() {
		assertEquals("The constrain value should be -5", -5, rangeObjectUnderTest.constrain(-5), 0.000000001d);
	}

	// ------------------- Test methods for getUpperBound()

	@Test
	public void testUpperBoundTwoNegatives() {
		rangeObjectUnderTest = new Range(-5, -1);
		assertEquals("The upper bound should be -1", -1, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundNegativeAndZero() {
		rangeObjectUnderTest = new Range(-5, 0);
		assertEquals("The upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundNegativeAndPositive() {
		rangeObjectUnderTest = new Range(-5, 1);
		assertEquals("The upper bound should be 1", 1, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundTwoZeros() {
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundEqualPositives() {
		rangeObjectUnderTest = new Range(5, 5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundEqualNegatives() {
		rangeObjectUnderTest = new Range(-5, -5);
		assertEquals("The upper bound should be -5", -5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundZeroAndPositive() {
		rangeObjectUnderTest = new Range(0, 5);
		assertEquals("The upper bound should be 5", 5, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundTwoPositives() {
		rangeObjectUnderTest = new Range(5, 15);
		assertEquals("The upper bound should be 15", 15, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	// ------------------------------- Test methods for getLowerBound()

	@Test
	public void testLowerBoundTwoNegatives() {
		rangeObjectUnderTest = new Range(-5, -1);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundNegativeAndZero() {
		rangeObjectUnderTest = new Range(-5, 0);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundNegativeAndPositive() {
		rangeObjectUnderTest = new Range(-5, 1);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundTwoZeros() {
		rangeObjectUnderTest = new Range(0, 0);
		assertEquals("The lower bound should be 0", 0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundEqualPositives() {
		rangeObjectUnderTest = new Range(5, 5);
		assertEquals("The lower bound should be 5", 5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundEqualNegatives() {
		rangeObjectUnderTest = new Range(-5, -5);
		assertEquals("The lower bound should be -5", -5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundZeroAndPositive() {
		rangeObjectUnderTest = new Range(0, 5);
		assertEquals("The lower bound should be 0", 0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundTwoPositives() {
		rangeObjectUnderTest = new Range(5, 15);
		assertEquals("The lower bound should be 5", 5, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	// ---------------------Test methods for intersects(double lower,double upper)

	@Test
	public void testIntersectsOnlyLowerIntersects() {
		rangeObjectUnderTest = new Range(-10, 5);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 6));
	}

	@Test
	public void testIntersectsOnlyUpperIntersects() {
		rangeObjectUnderTest = new Range(-5, 10);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(-6, 1));
	}

	@Test
	public void testIntersectsBothUpperAndLowerIntersect() {
		rangeObjectUnderTest = new Range(1, 15);
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 10));
	}

	@Test
	public void testIntersectsBothAboveIntersection() {
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(15,20));
	}
	
	@Test
	public void testIntersectsBothBelowIntersection() {
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(-5,-1));
	}


	@Test
	public void testIntersectsUpperEqual() {
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(1, 10));
	}
	
	@Test
	public void testIntersectsLowerEqual() {
		rangeObjectUnderTest = new Range(5, 15);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(5, 10));
	}
	
	@Test
	public void testIntersectsLowerHigherThanUpper() {
		rangeObjectUnderTest = new Range(5, 10);
		assertFalse("Should return false", rangeObjectUnderTest.intersects(10,5));
	}


}
