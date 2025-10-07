package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Customer> customerList;

    public static void main(String[] args) throws IOException {

        FileDAO reader = new FileDAO();
        Path pathToFile = Paths.get("src//boilerroom.csv");

        customerList = reader.fileToCustomerList(pathToFile);



        Map<String,List<Customer>> cityGroups;
        cityGroups = customerList.stream().collect(groupingBy(Customer::getCity));


        Map<String,Integer> cityValue = new TreeMap<>();
        cityGroups.forEach((city,group)->
                cityValue.put(city,group.stream()
                        .mapToInt(Customer::getOrderValue)
                        .sum()));

        reader.writeRapport(top10(customerList),cityValue);

    }

    private static List<Customer> top10(List<Customer> customerList){
        return customerList.stream()
                .filter(c-> c.getOrderValue()>=1000)
                .sorted(Comparator.comparingInt(Customer::getOrderValue).reversed())
                .limit(10).toList();
    }


}

