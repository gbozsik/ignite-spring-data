package com.baeldung.ignite.spring.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JolConverter {

    private JolConverter() {
    }

    public static List<String[]> readFromFile() {
        List<String[]> splittedLineList = new ArrayList<>();
        BufferedReader reader;
//		LocalDateTime startTime = LocalDateTime.now();
		try {

			reader = new BufferedReader(new FileReader(
					"/home/gbozsik/Documents/Artisjus/DeezerWorldwidePremiumPlusStandalone_20160301_20160331_HU_matched.jol"));
			String line = reader.readLine();
			while (line != null) {
				String[] splittedLine = line.split("\\|", -1);
//				dumpSplittedLine(splittedLine);
//				createDatasetWrapper(splittedLine);
				splittedLineList.add(splittedLine);
				line = reader.readLine();
			}
//			Duration duration = Duration.between(startTime, LocalDateTime.now());
//			System.out.println("File read Time: " + duration);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return splittedLineList;
    }

	private static void createDatasetWrapper(String[] splittedLine) {

	}

	private static void dumpSplittedLine(String[] splittedLine) {
		for (String word : splittedLine) {
			System.out.print(word + " ");
		}
		System.out.println();
	}

}
