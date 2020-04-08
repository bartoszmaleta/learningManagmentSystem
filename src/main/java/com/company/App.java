package com.company;

import com.company.dao.Parser.CsvParser;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        __________________________________________________________
//        LoggingController logging = new LoggingController();
//        logging.init();
//        __________________________________________________________

        System.out.println("Hello World!");

        CsvParser csvParser = new CsvParser("src/main/resources/users.csv");

        System.out.println("List of lists from file = " + csvParser.getUpdatedList());
        System.out.println("size = " + csvParser.getUpdatedList().size());


        String[] recordToAdd = {"5", "lizhenli", "password5", "li", "zhen", "student"};
        csvParser.addNewRecord(recordToAdd);
//
        System.out.println("list from file with added record = " + csvParser.getUpdatedList());
        System.out.println("new size = " + csvParser.getUpdatedList().size());

        //
        System.out.println("------------");

        //        users.csv
//                id,username,password,name,surname,role,
//                1,bartoszmal,password1,bartosz,maleta,student
//                2,johny,password2,john,smith,manager,
//                3,stevo,password3,steve,williams,employee,
//                4,tommy,password4,tom,thompson,mentor,
//                5,lizhenli,password5,li,zhen,student,

    }
}
