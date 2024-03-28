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
    // :)
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
	
	// ---------------------------Test cases for combine(Range range1, Range range2)
	
	@Test
    public void testCombineNullRange1() {
        Range result = Range.combine(null, new Range(2, 4));
        assertEquals("Combined range should be (2, 4)", new Range(2, 4), result);
    }

    @Test
    public void testCombineNullRange2() {
        Range result = Range.combine(new Range(-3, -1), null);
        assertEquals("Combined range should be (-3, -1)", new Range(-3, -1), result);
    }

    @Test
    public void testCombineNullRanges() {
        Range result = Range.combine(null, null);
        assertNull("Combined range should be null", result);
    }

    @Test
    public void testCombineEncompassingRanges() {
        Range range1 = new Range(-5, 5);
        Range range2 = new Range(-2, 2);
        Range result = Range.combine(range1, range2);
        assertEquals("Combined range should be (-5, 5)", new Range(-5, 5), result);
    }

    @Test
    public void testCombineOverlappingRanges() {
        Range range1 = new Range(-5, 0);
        Range range2 = new Range(-2, 3);
        Range result = Range.combine(range1, range2);
        assertEquals("Combined range should be (-5, 3)", new Range(-5, 3), result);
    }

    @Test
    public void testCombineDisjointRanges() {
        Range range1 = new Range(-5, -1);
        Range range2 = new Range(1, 5);
        Range result = Range.combine(range1, range2);
        assertEquals("Combined range should be (-5, 5)", new Range(-5, 5), result);
    }
    
    
    // --------------------------------- Test cases for expand()

    
    @Test
    public void testExpandPositiveMargins() {
        Range result = Range.expand(rangeObjectUnderTest, 0.1, 0.2);
        assertEquals("Expanded range should be (-1.2, 1.4)", new Range(-1.2, 1.4), result);
    }

    @Test
    public void testExpandNegativeMargins() {
        Range result = Range.expand(rangeObjectUnderTest, -0.2, -0.1);
        assertEquals("Expanded range should be (-0.8, 1.2)", new Range(-0.8, 1.2), result);
    }

    @Test
    public void testExpandDifferentMargins() {
        Range result = Range.expand(rangeObjectUnderTest, 0.1, 0.3);
        assertEquals("Expanded range should be (-1.3, 1.6)", new Range(-1.3, 1.6), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpandNullRange() {
        Range result = Range.expand(null, 0.1, 0.2);
        // Should throw IllegalArgumentException
    }

    
    // --------------------------------- Test cases for hashCode()
    
    @Test
    public void testHashCodeConsistency() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(0, 5);
        assertEquals("Hash codes should be consistent for equal objects", 
                     range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeDifference() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(1, 6);
        assertNotEquals("Hash codes should be different for different objects", 
                        range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeSelfConsistency() {
        int hashCode = rangeObjectUnderTest.hashCode();
        assertEquals("Hash code should be consistent for the same object", 
                     hashCode, rangeObjectUnderTest.hashCode());
    }
    
    
    // -------------------------------- Test cases for shift(Range base, double delta)
    
    @Test
    public void testShiftWithDeltaPositive() {
        Range shiftedRange = Range.shift(new Range(0, 5), 3);
        assertEquals("Lower bound should be shifted by 3", 
                     3.0, shiftedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be shifted by 3", 
                     8.0, shiftedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testShiftWithDeltaNegative() {
        Range shiftedRange = Range.shift(new Range(0, 5), -2);
        assertEquals("Lower bound should be shifted by -2", 
                     -2.0, shiftedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be shifted by -2", 
                     3.0, shiftedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testShiftWithZeroDelta() {
        Range shiftedRange = Range.shift(new Range(0, 5), 0);
        assertEquals("Lower bound should remain unchanged", 
                     0.0, shiftedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should remain unchanged", 
                     5.0, shiftedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testShiftAllowZeroCrossingTrue() {
        Range shiftedRange = Range.shift(new Range(-2, 2), -3, true);
        assertEquals("Lower bound should be shifted by -3", 
                     -5.0, shiftedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be shifted by -3", 
                     -1.0, shiftedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testShiftAllowZeroCrossingFalse() {
        Range shiftedRange = Range.shift(new Range(-2, 2), -3, false);
        assertEquals("Lower bound should be shifted to 0", 
                     0.0, shiftedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be shifted to 4", 
                     4.0, shiftedRange.getUpperBound(), 0.000001);
    }
    
    
    // ------------------------------------ Test cases for expandToInclude(Range range, double value)
    
    @Test
    public void testExpandToIncludeNullRange() {
        Range expandedRange = Range.expandToInclude(null, 5);
        assertEquals("Lower bound should be set to 5", 
                     5.0, expandedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be set to 5", 
                     5.0, expandedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testExpandToIncludeValueSmallerThanLowerBound() {
        Range expandedRange = Range.expandToInclude(new Range(0, 10), -2);
        assertEquals("Lower bound should be updated to -2", 
                     -2.0, expandedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should remain unchanged (10)", 
                     10.0, expandedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testExpandToIncludeValueGreaterThanUpperBound() {
        Range expandedRange = Range.expandToInclude(new Range(0, 10), 15);
        assertEquals("Lower bound should remain unchanged (0)", 
                     0.0, expandedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be updated to 15", 
                     15.0, expandedRange.getUpperBound(), 0.000001);
    }

    @Test
    public void testExpandToIncludeValueWithinRange() {
        Range originalRange = new Range(-5, 5);
        Range expandedRange = Range.expandToInclude(originalRange, 0);
        assertEquals("Lower bound should remain unchanged (-5)", 
                     -5.0, expandedRange.getLowerBound(), 0.000001);
        assertEquals("Upper bound should remain unchanged (5)", 
                     5.0, expandedRange.getUpperBound(), 0.000001);
        assertTrue("Expanded range should be the same object as the original range", 
                   expandedRange == originalRange);
    }
    
    
    // ---------------------------------- Test cases for Range(double lower, double upper)
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLowerGreaterThanUpper() {
        new Range(5, 1);
    }

    @Test
    public void testConstructorWithLowerEqualToUpper() {
        Range range = new Range(5, 5);
        assertEquals("Lower bound should be 5", 5.0, range.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be 5", 5.0, range.getUpperBound(), 0.000001);
    }

    @Test
    public void testConstructorWithValidRange() {
        Range range = new Range(-5, 10);
        assertEquals("Lower bound should be -5", -5.0, range.getLowerBound(), 0.000001);
        assertEquals("Upper bound should be 10", 10.0, range.getUpperBound(), 0.000001);
    }
    
    
    // ----------------------------------- Test cases for equals(Object obj)
    
    @Test
    public void testEqualsWithSameInstance() {
        assertTrue("Should return true when comparing with itself", rangeObjectUnderTest.equals(rangeObjectUnderTest));
    }

    @Test
    public void testEqualsWithEqualRanges() {
        Range equalRange = new Range(0, 10);
        assertTrue("Should return true for equal ranges", rangeObjectUnderTest.equals(equalRange));
    }

    @Test
    public void testEqualsWithDifferentRanges() {
        Range differentRange = new Range(5, 15);
        assertFalse("Should return false for different ranges", rangeObjectUnderTest.equals(differentRange));
    }

    @Test
    public void testEqualsWithDifferentObjectType() {
        assertFalse("Should return false when comparing with a different type", rangeObjectUnderTest.equals("not a Range"));
    }

    @Test
    public void testEqualsWithNull() {
        assertFalse("Should return false when comparing with null", rangeObjectUnderTest.equals(null));
    }

    @Test
    public void testEqualsWithEqualValuesDifferentObjects() {
        Range equalValuesDifferentObjects = new Range(0, 10);
        assertTrue("Should return true for equal values even if objects are different", rangeObjectUnderTest.equals(equalValuesDifferentObjects));
    }

    @Test
    public void testEqualsWithDifferentPrecision() {
        Range differentPrecision = new Range(0.0, 10.0);
        assertTrue("Should return true when comparing equal values with different precision", rangeObjectUnderTest.equals(differentPrecision));
    }
    
}
