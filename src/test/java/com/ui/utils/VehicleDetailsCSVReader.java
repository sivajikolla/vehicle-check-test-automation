package com.ui.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.ui.dto.VehicleDetailsDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class VehicleDetailsCSVReader {

    public static List<VehicleDetailsDTO> readOutputTestData(String filePath) throws IOException {

        File expectedDataCSVFile = new File(filePath);
        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                .typedSchemaFor(VehicleDetailsDTO.class)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        MappingIterator<VehicleDetailsDTO> vehicleDetailsDTOMappingIterator = csvMapper
                .readerWithTypedSchemaFor(VehicleDetailsDTO.class)
                .with(csvSchema)
                .readValues(expectedDataCSVFile);

        List<VehicleDetailsDTO> vehicleDetailsDTOS = vehicleDetailsDTOMappingIterator.readAll();
        System.out.println(vehicleDetailsDTOS.get(0).getRegistration());
        System.out.println(vehicleDetailsDTOS.get(1).getRegistration());
        System.out.println(vehicleDetailsDTOS.get(2).getRegistration());
        System.out.println(vehicleDetailsDTOS.get(3).getRegistration());
        vehicleDetailsDTOS.forEach(System.out::println);
        return vehicleDetailsDTOS;
    }
}
