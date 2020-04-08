package com.company;

import com.company.dao.Parser.CsvParser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        LoggingController logging = new LoggingController();
//        logging.init();
        System.out.println("Hello World!");

        CsvParser csvParser = new CsvParser("src/main/resources/users.csv");
        System.out.println("List of lists from file = " + csvParser.getUpdatedList());
        System.out.println("size = " + csvParser.getUpdatedList().size());

//        System.out.println(csvParser.getList());

        String[] recordToAdd = {"5we4", "Awqsdzx23weasdqwe", "asd3"};
        csvParser.addNewRecord(recordToAdd);
//
        System.out.println("list = " + csvParser.getListOfLines());
        System.out.println("list from file = " + csvParser.getUpdatedList());

        //
        System.out.println("------------");
//        FileParser fileParser = new FileParser("src/main/resources/users.csv");
//        System.out.println(fileParser.getList());
//        System.out.println(fileParser.getList().size());
////        fileParser.addNewRecord(recordToAdd);
////        System.out.println(fileParser.getList());
////        System.out.println(fileParser.getList().size());
    }
}
