/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern 
 * on a given number of rows like this: (you may want to display 
 * this pattern in a fixed font for better legibility)
 *
 * P   A   H   N 
 * A P L S I I G
 * Y   I   R 
 *
 * And then read line by line: "PAHMAPLSIIGYIR"
 *
 * Write the cade that will take a string and make this conversion 
 * given a number of rows: 
 *
 * string convert(string text, int nRows);
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;

		char[] a  = s.toCharArray();
		int N = a.length;
		char[] b = new char[N];
		int p = 0;

		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < N; j += 2*(numRows-1)) {
				b[p++] = a[j];
				if (i > 0 && i < numRows -1 && j + 2*(numRows-1-i) < N) 
					b[p++] = a[j + 2*(numRows-1-i)];
			}
		}

		return new String(b);
	}
}