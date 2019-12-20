package com.baeldung.ignite.spring.converter;

import com.baeldung.ignite.spring.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JolConverter {

    @Autowired
    private ConversionService conversionService;

    private JolConverter() {
    }

    public List<String[]> readFromFile(String filepath) {
        filepath = filepath.replace("\\", "/");
        String[] splitFilePath = filepath.split("/");
        String fileName = splitFilePath[splitFilePath.length - 2];
        List<String[]> splittedLineList = new ArrayList<>();
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(
                    filepath));
            long iterations = 0;
            String line = reader.readLine();
            LocalDateTime startOfConversion = LocalDateTime.now();
            while (line != null) {
                iterations++;
                String[] splittedLine = line.split("\\|", -1);
//                conversionService.streamToCache(line, fileName, iterations);
//				dumpSplittedLine(splittedLine);
//				createDatasetWrapper(splittedLine);
                splittedLineList.add(splittedLine);
                line = reader.readLine();
            }
            Duration durationOfSave = Duration.between(startOfConversion, LocalDateTime.now());
            System.out.println("duration of read: " + durationOfSave);
//			reader.reset();
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
