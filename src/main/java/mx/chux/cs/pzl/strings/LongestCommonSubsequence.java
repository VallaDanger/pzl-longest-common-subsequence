package mx.chux.cs.pzl.strings;

import java.util.function.ToIntFunction;

public class LongestCommonSubsequence implements ToIntFunction<String> {

	final String first;

	public LongestCommonSubsequence(final String first) {
		this.first = first;
	}

	public int apply(final String second) {
		return applyAsInt(second);
	}

	@Override
	public int applyAsInt(final String second) {

		if ((second == null) || second.isEmpty()) {
			return 0;
		}

		final int[][] matrix = buildMatrix(second);

		return lcss(matrix, second);
	}

	/*
	 * Will find the longest common subsequence
	 * repeated chars count as 1
	 */
	private int lcss(final int[][] matrix, final String second) {

		final int sizeOfFirst = matrix.length;
		final int sizeOfSecond = matrix[0].length;

		for (int i = 1; i < sizeOfFirst; i++) {
			for (int j = 1; j < sizeOfSecond; j++) {
				if (this.first.charAt(i-1) == second.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1] + 1;
				} else {
					matrix[i][j] = max(matrix, i, j);
				}
			}
		}

		// LCSS value will always be in the bottom-right corner
		// LCSS is carried over on every iteration
		return matrix[sizeOfFirst-1][sizeOfSecond-1];
	}

	private int max(final int[][] matrix, final int i, final int j) {
		final int leftCell = matrix[i][j-1];
		final int aboveCell = matrix[i-1][j];
		return (leftCell >= aboveCell) ? leftCell : aboveCell;
	}

	private final int[][] buildMatrix(final String second) {

		// add 1 row on top and 1 column to the left
		// makes it simpler to avoid out-of-bound exceptions
		final int sizeOfRows = this.first.length() + 1;
		final int sizeOfCols = second.length() + 1;

		final int[][] matrix = new int[sizeOfRows][sizeOfCols];

		return initializeMatrix(matrix, sizeOfRows, sizeOfCols);
	}

	private int[][] initializeMatrix(final int[][] matrix, int r, int c) {
		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++) {
				matrix[row][col] = 0;
			}
		}
		return matrix;
	}

}
