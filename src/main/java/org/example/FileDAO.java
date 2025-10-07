package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

public class FileDAO {


    private Customer formatLine(String line){
        String[] fields = line.split(",");
        return new Customer(fields[0],fields[1]
                ,Integer.parseInt(fields[2]));
    }

    public List<Customer> fileToCustomerList(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)){
            return reader.lines().skip(1).
                    map(this::formatLine
                    ).toList();
        }
    }


    public void writeRapport(List<Customer> customerList, Map<String,Integer> cityValue) throws IOException {

        Path path = Paths.get("src//rapport.txt");

        Files.deleteIfExists(path);
        Files.createFile(path);


        Files.write(path,customerList.stream().map(
                c-> c.getName().toUpperCase() + "("+ c.getCity().toUpperCase() +") "+ c.getOrderValue() + " SEK"

        ).toList());

        Files.write(path,System.lineSeparator().getBytes(),StandardOpenOption.APPEND);

        Files.write(path,cityValue.entrySet().stream().map(
                set->set.getKey()+" "+set.getValue()+ " SEK").toList(), StandardOpenOption.APPEND);



    }


}
