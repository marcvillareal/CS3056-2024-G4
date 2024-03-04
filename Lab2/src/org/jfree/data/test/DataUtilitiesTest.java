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
}