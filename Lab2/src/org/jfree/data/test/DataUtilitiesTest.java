package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

import org.junit.*;

public class DataUtilitiesTest {

	private Values2D data;
	private double[] dataArray;
	private double[][] dataArray2D;
	private KeyedValues dataValues;

	@Before
	public void setUp() throws Exception {

		// Setting up for testCalculateColumnTotal and testCalculateRowTotal
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();

		testValues.addValue(3, 4, 5);
		testValues.addValue(3, 0, 11);
		testValues.addValue(2, 1, 3);
		testValues.addValue(2, 2, 7);

		data = testValues;

		// Setting up for testCreateNumberArray
		dataArray = new double[5];
		dataArray[0] = 1.5;
		dataArray[1] = 2.5;
		dataArray[2] = 3.5;
		dataArray[3] = 4.5;
		dataArray[4] = 5.5;

		// Setting up for testCreateNumberArray2D
		dataArray2D = new double[3][4];
		dataArray2D[0][0] = 1.5;
		dataArray2D[0][1] = 2.5;
		dataArray2D[0][2] = 3.5;
		dataArray2D[0][3] = 4.5;
		dataArray2D[1][0] = 5.5;
		dataArray2D[1][1] = 6.5;
		dataArray2D[1][2] = 7.5;
		dataArray2D[1][3] = 8.5;
		dataArray2D[2][0] = 9.5;
		dataArray2D[2][1] = 10.5;
		dataArray2D[2][2] = 11.5;
		dataArray2D[2][3] = 12.5;

		// Setting up for testGetCumulativePercentages
		DefaultKeyedValues testKeyValues = new DefaultKeyedValues();

		testKeyValues.addValue((Comparable<?>) 0, 5);
		testKeyValues.addValue((Comparable<?>) 1, 9);
		testKeyValues.addValue((Comparable<?>) 2, 2);
		testKeyValues.addValue((Comparable<?>) 3, 4);

		dataValues = DataUtilities.getCumulativePercentages((KeyedValues) testKeyValues);
	}

	@After
	public void tearDown() throws Exception {
		data = null;
		dataArray = null;
		dataValues = null;
	}

	// CalculateColumnTotal

	@Test
	public void testCalculateColumnTotal_WithValidDataAndLastColumnValue() {
		int column = data.getColumnCount() - 1;

		assertEquals("Valid 2D matrix and last column value: Expected sum of last column.", 16.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndZeroColumnValue() {
		int column = 0;

		assertEquals("Valid 2D matrix and column value zero: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndColumnValue() {
		int column = 1;

		assertEquals("Valid 2D matrix and column value: Expected 4.0.", 4.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndInvalidColumnValueLessThan0() {
		try {
			int column = -1;

			assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
					DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
		} catch (IndexOutOfBoundsException e) {
			fail("Expected 0.0 returned for invalid column value on valid 2D matrix.");
		}
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndInvalidColumnValueGreaterThanNumberOfColumns() {
		try {
			int column = 13;

			assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
					DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
		} catch (IndexOutOfBoundsException e) {
			fail("Expected 0.0 returned for invalid column value on valid 2D matrix.");
		}
	}

	@Test
	public void testCalculateColumnTotal_WithEmptyDataAndValidColumnValue() {
		int column = 1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Empty 2D matrix: Expected 0.0.", 0.0, DataUtilities.calculateColumnTotal(data, column),
				0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithEmptyDataAndInvalidColumnValueLessThan0() {
		int column = -1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithEmptyDataAndInvalidColumnValueGreaterThanNumberOfColumns() {
		int column = 13;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithNullDataAndValidColumnValue() {
		int column = 1;

		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("Expected IllegalArgumentException for null 2D matrix and valid column value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and valid column value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateColumnTotal_WithNullDataAndInvalidColumnValueLessThan0() {
		int column = -1;

		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid column value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid column value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateColumnTotal_WithNullDataAndInvalidColumnValueGreaterThanNumberOfColumns() {
		int column = 13;

		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid column value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid column value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	// CalculateRowTotal

	@Test
	public void testCalculateRowTotal_WithValidDataAndZeroRowValue() {
		int row = 0;

		assertEquals("Valid 2D matrix and row value zero: Expected 12.0.", 12.0,
				DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndRowValue() {
		int row = 0;

		assertEquals("Valid 2D matrix and row value: Expected 12.0.", 12.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndLastRowValue() {
		int row = data.getRowCount() - 1;

		assertEquals("Valid 2D matrix and last row value: Expected sum of last row.", 18.0,
				DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndInvalidRowValueLessThan0() {
		try {

			int row = -1;

			assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
					0.0000001d);
		} catch (IndexOutOfBoundsException e) {
			fail("Expected 0.0 returned for invalid row value on valid 2D matrix.");
		}
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndInvalidRowValueGreaterThanNumberOfRows() {
		try {
			int row = 13;

			assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
					0.0000001d);
		} catch (IndexOutOfBoundsException e) {
			fail("Expected 0.0 returned for invalid row value on valid 2D matrix.");
		}
	}

	@Test
	public void testCalculateRowTotal_WithEmptyDataAndValidRowValue() {
		int row = 0;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Empty 2D matrix: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithEmptyDataAndInvalidRowValueLessThan0() {
		int row = -1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithEmptyDataAndInvalidRowValueGreaterThanNumberOfRows() {
		int row = 13;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithNullDataAndValidRowValue() {
		int row = 0;

		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("Expected IllegalArgumentException for null 2D matrix and valid row value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and valid row value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateRowTotal_WithNullDataAndInvalidRowValueLessThan0() {
		int row = -1;

		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid row value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid row value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateRowTotal_WithNullDataAndInvalidRowValueGreaterThanNumberOfRows() {
		int row = 13;

		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid row value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid row value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	// CreateNumberArray

	@Test
	public void testCreateNumberArray_WithValidDataArray() {
		Number[] expectedOutput = { 1.5, 2.5, 3.5 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithEmptyDataArray() {
		Number[] expectedOutput = {};

		dataArray = new double[0];

		assertArrayEquals("Empty double array supplied: Expected empty array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithNullDataArray() {
		try {
			DataUtilities.createNumberArray(null);
			fail("Expected IllegalArgumentException for null data array.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data array.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfNegativeValues() {
		Number[] expectedOutput = { -1.5, -2.5, -3.5 };

		double[] dataArray = { -1.5, -2.5, -3.5 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfZeroValues() {
		Number[] expectedOutput = { 0.0, 0.0, 0.0 };

		double[] dataArray = { 0.0, 0.0, 0.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfLargeValues() {
		Number[] expectedOutput = { 1000.0, 2000.0, 3000.0 };

		double[] dataArray = { 1000.0, 2000.0, 3000.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfMixedValues() {
		Number[] expectedOutput = { 1.5, -2.5, 0.0, 3000.0 };

		double[] dataArray = { 1.5, -2.5, 0.0, 3000.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	// CreateNumberArray2D

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2D() {

		Number[][] expectedOutput = { { 1.5, 2.5, 3.5 }, { 4.5, 5.5, 6.5 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithEmptyDataArray2D() {
		Number[][] expectedOutput = {};

		dataArray2D = new double[0][0];

		assertArrayEquals("Empty 2D double array supplied: Expected empty 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithNullDataArray2D() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("Expected IllegalArgumentException for null 2D double array.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null 2D double array.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfNegativeValues() {
		Number[][] expectedOutput = { { -1.5, -2.5, -3.5 }, { -4.5, -5.5, -6.5 } };

		double[][] dataArray2D = { { -1.5, -2.5, -3.5 }, { -4.5, -5.5, -6.5 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfZeroValues() {
		Number[][] expectedOutput = { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };

		double[][] dataArray2D = { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfLargeValues() {
		Number[][] expectedOutput = { { 1000.0, 2000.0, 3000.0 }, { 4000.0, 5000.0, 6000.0 } };

		double[][] dataArray2D = { { 1000.0, 2000.0, 3000.0 }, { 4000.0, 5000.0, 6000.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfMixedValues() {
		Number[][] expectedOutput = { { 1.5, -2.5, 3.5 }, { 0.0, 4000.0, 0.0 } };

		double[][] dataArray2D = { { 1.5, -2.5, 3.5 }, { 0.0, 4000.0, 0.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}
}