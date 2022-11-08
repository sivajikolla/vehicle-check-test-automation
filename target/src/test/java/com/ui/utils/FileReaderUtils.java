package com.ui.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.ui.steps.SharedData.TEST_DATA_PATH;

public class FileReaderUtils {
    public static List<String> readAndFindCarRegValueFromTextFile(String inputDataFile) throws IOException {
        BufferedReader carRegInputFileReader = new BufferedReader(new FileReader(TEST_DATA_PATH + inputDataFile));
        ArrayList<String> listOfCarRegNumbers = new ArrayList<>();
        List<String> uniqueCarRegNumbers = null;
        String lineFromInputText = carRegInputFileReader.readLine();
        while (lineFromInputText != null ) {
            String data = lineFromInputText;
            Pattern carRegPattern = Pattern.compile("([a-zA-Z])+(\\d{2})([a-zA-Z]|\\s)([a-zA-Z]+)\\*?");
            Matcher matcher=carRegPattern.matcher(data);
            while(matcher.find())
            {
                listOfCarRegNumbers.add(matcher.group().replaceAll("\\s",""));
            }

            lineFromInputText = carRegInputFileReader.readLine();
        }
        carRegInputFileReader.close();
        return listOfCarRegNumbers;
    }
}
