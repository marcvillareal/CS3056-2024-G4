package org.jfree.data;

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

	// --------------------- CalculateColumnTotal Tests ---------------------

	@Test
	public void testCalculateColumnTotal_WithValidDataAndLastColumnValue() {
		// Test summing up the last column in a valid 2D matrix.
		int column = data.getColumnCount() - 1;

		assertEquals("Valid 2D matrix and last column value: Expected sum of last column.", 16.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndZeroColumnValue() {
		// Test summing up the zeroth column in a valid 2D matrix.
		int column = 0;

		assertEquals("Valid 2D matrix and column value zero: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndColumnValue() {
		// Test summing up a specific column in a valid 2D matrix.
		int column = 1;

		assertEquals("Valid 2D matrix and column value: Expected 4.0.", 4.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithValidDataAndInvalidColumnValueLessThan0() {
		// Test summing up a column with an invalid index (< 0) in a valid 2D matrix.
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
		// Test summing up a column with an index exceeding the number of columns in a
		// valid 2D matrix.
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
		// Test summing up a column in an empty 2D matrix.
		int column = 1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Empty 2D matrix: Expected 0.0.", 0.0, DataUtilities.calculateColumnTotal(data, column),
				0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithEmptyDataAndInvalidColumnValueLessThan0() {
		// Test summing up a column with an invalid index (< 0) in an empty 2D matrix.
		int column = -1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithEmptyDataAndInvalidColumnValueGreaterThanNumberOfColumns() {
		// Test summing up a column with an index exceeding the number of columns in an
		// empty 2D matrix.
		int column = 13;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid column value supplied: Expected 0.0.", 0.0,
				DataUtilities.calculateColumnTotal(data, column), 0.0000001d);
	}

	@Test
	public void testCalculateColumnTotal_WithNullDataAndValidColumnValue() {
		// Test summing up a column in a null 2D matrix.
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
		// Test summing up a column with an invalid index (< 0) in a null 2D matrix.
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
		// Test summing up a column with an index exceeding the number of columns in a
		// null 2D matrix.
		int column = 13;

		try {
			DataUtilities.calculateColumnTotal(null, column);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid column value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid column value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	// --------------------- CalculateRowTotal Tests ---------------------

	@Test
	public void testCalculateRowTotal_WithValidDataAndZeroRowValue() {
		// Test summing up the zeroth row in a valid 2D matrix.
		int row = 0;

		assertEquals("Valid 2D matrix and row value zero: Expected 12.0.", 12.0,
				DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndRowValue() {
		// Test summing up a specific row in a valid 2D matrix.
		int row = 0;

		assertEquals("Valid 2D matrix and row value: Expected 12.0.", 12.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndLastRowValue() {
		// Test summing up the last row in a valid 2D matrix.
		int row = data.getRowCount() - 1;

		assertEquals("Valid 2D matrix and last row value: Expected sum of last row.", 18.0,
				DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndInvalidRowValueLessThan0() {
		// Test summing up a row with an invalid index (< 0) in a valid 2D matrix.
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
		// Test summing up a row with an index exceeding the number of rows in a valid
		// 2D matrix.
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
		// Test summing up a row in an empty 2D matrix.
		int row = 0;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Empty 2D matrix: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row), 0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithEmptyDataAndInvalidRowValueLessThan0() {
		// Test summing up a row with an invalid index (< 0) in an empty 2D matrix.
		int row = -1;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithEmptyDataAndInvalidRowValueGreaterThanNumberOfRows() {
		// Test summing up a row with an index exceeding the number of rows in an empty
		// 2D matrix.
		int row = 13;

		DefaultKeyedValues2D testEmpty = new DefaultKeyedValues2D();

		data = testEmpty;

		assertEquals("Invalid row value supplied: Expected 0.0.", 0.0, DataUtilities.calculateRowTotal(data, row),
				0.0000001d);
	}

	@Test
	public void testCalculateRowTotal_WithNullDataAndValidRowValue() {
		// Test summing up a row in a null 2D matrix.
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
		// Test summing up a row with an invalid index (< 0) in a null 2D matrix.
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
		// Test summing up a row with an index exceeding the number of rows in a null 2D
		// matrix.
		int row = 13;

		try {
			DataUtilities.calculateRowTotal(null, row);
			fail("Expected IllegalArgumentException for null 2D matrix and invalid row value.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data and invalid row value.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	// --------------------- CreateNumberArray Tests ---------------------

	@Test
	public void testCreateNumberArray_WithValidDataArray() {
		// Test converting a valid double array to an array of Number objects.
		Number[] expectedOutput = { 1.5, 2.5, 3.5 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithEmptyDataArray() {
		// Test converting an empty double array to an array of Number objects.
		Number[] expectedOutput = {};

		dataArray = new double[0];

		assertArrayEquals("Empty double array supplied: Expected empty array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithNullDataArray() {
		// Test converting a null double array to an array of Number objects.
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
		// Test converting a valid double array with negative values to an array of
		// Number objects.
		Number[] expectedOutput = { -1.5, -2.5, -3.5 };

		double[] dataArray = { -1.5, -2.5, -3.5 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfZeroValues() {
		// Test converting a valid double array with zero values to an array of Number
		// objects.
		Number[] expectedOutput = { 0.0, 0.0, 0.0 };

		double[] dataArray = { 0.0, 0.0, 0.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfLargeValues() {
		// Test converting a valid double array with large values to an array of Number
		// objects.
		Number[] expectedOutput = { 1000.0, 2000.0, 3000.0 };

		double[] dataArray = { 1000.0, 2000.0, 3000.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	@Test
	public void testCreateNumberArray_WithValidDataArrayOfMixedValues() {
		// Test converting a valid double array with mixed values to an array of Number
		// objects.
		Number[] expectedOutput = { 1.5, -2.5, 0.0, 3000.0 };

		double[] dataArray = { 1.5, -2.5, 0.0, 3000.0 };

		assertArrayEquals("Valid double array supplied: Expected array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray(dataArray));
	}

	// --------------------- CreateNumberArray2D Tests ---------------------

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2D() {
		// Test converting a valid 2D double array to a 2D array of Number objects.
		Number[][] expectedOutput = { { 1.5, 2.5, 3.5 }, { 4.5, 5.5, 6.5 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithEmptyDataArray2D() {
		// Test converting an empty 2D double array to an empty 2D array of Number
		// objects.
		Number[][] expectedOutput = {};

		dataArray2D = new double[0][0];

		assertArrayEquals("Empty 2D double array supplied: Expected empty 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithNullDataArray2D() {
		// Test converting a null 2D double array to a 2D array of Number objects.
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
		// Test converting a valid 2D double array with negative values to a 2D array of
		// Number objects.
		Number[][] expectedOutput = { { -1.5, -2.5, -3.5 }, { -4.5, -5.5, -6.5 } };

		double[][] dataArray2D = { { -1.5, -2.5, -3.5 }, { -4.5, -5.5, -6.5 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfZeroValues() {
		// Test converting a valid 2D double array with zero values to a 2D array of
		// Number objects.
		Number[][] expectedOutput = { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };

		double[][] dataArray2D = { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfLargeValues() {
		// Test converting a valid 2D double array with large values to a 2D array of
		// Number objects.
		Number[][] expectedOutput = { { 1000.0, 2000.0, 3000.0 }, { 4000.0, 5000.0, 6000.0 } };

		double[][] dataArray2D = { { 1000.0, 2000.0, 3000.0 }, { 4000.0, 5000.0, 6000.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	@Test
	public void testCreateNumberArray2D_WithValidDataArray2DOfMixedValues() {
		// Test converting a valid 2D double array with mixed values to a 2D array of
		// Number objects.
		Number[][] expectedOutput = { { 1.5, -2.5, 0.0 }, { 3000.0, -4000.0, 5000.0 } };

		double[][] dataArray2D = { { 1.5, -2.5, 0.0 }, { 3000.0, -4000.0, 5000.0 } };

		assertArrayEquals("Valid 2D double array supplied: Expected 2D array of Number objects.", expectedOutput,
				DataUtilities.createNumberArray2D(dataArray2D));
	}

	// --------------------- GetCumulativePercentages Tests ---------------------

	@Test
	public void testGetCumulativePercentages_WithValidDataAndNonNumericKeys() {
		// Test calculating cumulative percentages for valid data with non-numeric keys.
		DefaultKeyedValues testKeyValues = new DefaultKeyedValues();

		testKeyValues.addValue("A", 5);
		testKeyValues.addValue("B", 9);
		testKeyValues.addValue("C", 2);

		KeyedValues dataValues = DataUtilities.getCumulativePercentages(testKeyValues);

		assertEquals("Valid data with non-numeric keys: Expected cumulative percentage of 1.0.", 1.0,
				(double) dataValues.getValue(2), 0.000000001d);
	}

	@Test
	public void testGetCumulativePercentages_WithValidDataValues() {
		// Test calculating cumulative percentages for valid data values.
		DefaultKeyedValues expectedOutput = new DefaultKeyedValues();

		expectedOutput.addValue((Comparable<?>) 0, 0.3125);
		expectedOutput.addValue((Comparable<?>) 1, 0.6875);
		expectedOutput.addValue((Comparable<?>) 2, 0.9375);
		expectedOutput.addValue((Comparable<?>) 3, 1.0);

		assertEquals("Valid data values supplied: Expected cumulative percentages.", expectedOutput, dataValues);
	}

	@Test
	public void testGetCumulativePercentages_WithEmptyDataValues() {
		// Test calculating cumulative percentages for empty data values.
		DefaultKeyedValues testEmpty = new DefaultKeyedValues();

		dataValues = DataUtilities.getCumulativePercentages(testEmpty);

		DefaultKeyedValues expectedOutput = new DefaultKeyedValues();

		assertEquals("Empty data values supplied: Expected empty cumulative percentages.", expectedOutput, dataValues);
	}

	@Test
	public void testGetCumulativePercentages_WithNullDataValues() {
		// Test calculating cumulative percentages for null data values.
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("Expected IllegalArgumentException for null data values.");
		} catch (Exception e) {
			assertTrue("IllegalArgumentException should be thrown for null data values.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
}