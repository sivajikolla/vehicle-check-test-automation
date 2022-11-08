package com.ui.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.ui.dto.VehicleDetailsDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class VehicleDetailsCSVReaderExplorer {

    public static void main(String[] args) throws IOException {

        // set correct path to csv file on your disc
        File csvFile = new File("src/test/resources/test_data/output.txt");

        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                .typedSchemaFor(VehicleDetailsDTO.class)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        MappingIterator<VehicleDetailsDTO> complexUsersIter = csvMapper
                .readerWithTypedSchemaFor(VehicleDetailsDTO.class)
                .with(csvSchema)
                .readValues(csvFile);

        List<VehicleDetailsDTO> complexUsers = complexUsersIter.readAll();
        System.out.println(complexUsers.get(0).getRegistration());
        System.out.println(complexUsers.get(1).getRegistration());
        System.out.println(complexUsers.get(2).getRegistration());
        System.out.println(complexUsers.get(3).getRegistration());
        complexUsers.forEach(System.out::println);
    }
}
