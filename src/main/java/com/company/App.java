package com.company;

import com.company.dao.ManagerDAO;
import com.company.dao.Parser.CsvParser;
import com.company.dao.StudentDAO;
import com.company.models.users.User;
import com.company.models.users.employees.Manager;
import com.company.models.users.students.Student;

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

        User manager = new ManagerDAO().readManager();
        String managerName = manager.getName();
        System.out.println(managerName);

        System.out.println("------------");
        // update try! works!
        //        CsvParser csvParser2 = new CsvParser("src/main/resources/grades.csv");
//        csvParser.updateFile(csvParser2.getUpdatedList(), "trala");
//        System.out.println("updated list with new list = " + csvParser.getUpdatedList());


        User student = new StudentDAO().readUserByUsernameAndPassword("bartoszmal", "password1");
        System.out.println(student.getName());
        //        users.csv
//                id,username,password,name,surname,role,
//                1,bartoszmal,password1,bartosz,maleta,student
//                2,johny,password2,john,smith,manager,
//                3,stevo,password3,steve,williams,employee,
//                4,tommy,password4,tom,thompson,mentor,
//                5,lizhenli,password5,li,zhen,student,

    }
}
