// https://adventofcode.com/2021/day/1

import java.util.*;
import java.util.stream.*;
import java.io.*;

class SonarSweep {
	public static void main(String args[]) {
		String filename = new String("data.txt");
		ArrayList<Double> report = readReport(filename);
		long deeper_count = IntStream
		.range(1, report.size())
		.filter(index -> report.get(index) > report.get(index - 1 ))
		.count();

		System.out.println(deeper_count);

	}


	public static ArrayList<Double> readReport(String filename) {
		ArrayList<Double> result = new ArrayList<>();

		try (FileReader f = new FileReader(filename)) {
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					result.add(Double.parseDouble(sb.toString()));
					sb = new StringBuffer();
				} else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				result.add(Double.parseDouble(sb.toString()));
			}
		} catch(IOException e) { }       
		return result;
	}
}
