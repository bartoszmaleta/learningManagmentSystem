package com.company.mainsForTesting;

import com.company.dao.notUsedDao.MentorDao;
import com.company.dao.Parser.CsvParser;
import com.company.dao.notUsedDao.StudentDao;
import com.company.models.users.User;
import com.company.view.View;

import com.company.controllers.ManagerController;
import com.company.dao.notUsedDao.ManagerDao;
import com.company.models.users.notUsedModels.employees.Manager;

/**
 * Hello world!
 */
public class TestMain4 {
    public static void main(String[] args) {
//        __________________________________________________________
//        LoggingController logging = new LoggingController();
//        logging.init();
//        __________________________________________________________

//         System.out.println("Hello World!");

         CsvParser csvParser = new CsvParser("src/main/resources/users.csv");

//         System.out.println("List of lists from file = " + csvParser.getUpdatedList());
//         System.out.println("size = " + csvParser.getUpdatedList().size());


//        String[] recordToAdd = {"5", "lizhenli", "password5", "li", "zhen", "student"};
//        csvParser.addNewRecord(recordToAdd);
////        __________________________________________________________
////        LoggingController logging = new LoggingController();
////        logging.init();
////        __________________________________________________________
//
//
//        System.out.println("list from file with added record = " + csvParser.getUpdatedList());
//        System.out.println("new size = " + csvParser.getUpdatedList().size());

        //
        System.out.println("------------");
        StudentDao studentDAO = new StudentDao();
        MentorDao mentorDAO = new MentorDao();
        View view = new View();

        System.out.println("*****************");
//        view.viewAllStudents(studentDAO.extractUserFromList(csvParser.getListOfLines()));
//        System.out.println("*****************");
//        view.viewAllStudents(mentorDAO.extractUserFromList(csvParser.getListOfLines()));


        User manager = new ManagerDao().readManager();
        String managerName = manager.getName();
        System.out.println(managerName);

        System.out.println("------------");
        // update try! works!
        //        CsvParser csvParser2 = new CsvParser("src/main/resources/grades.csv");
//        csvParser.updateFile(csvParser2.getUpdatedList(), "trala");
//        System.out.println("updated list with new list = " + csvParser.getUpdatedList());


        User student = new StudentDao().readUserByUsernameAndPassword("bartoszmal", "password1");
        System.out.println(student.getName());
        //        users.csv
//                id,username,password,name,surname,role,
//                1,bartoszmal,password1,bartosz,maleta,student
//                2,johny,password2,john,smith,manager,
//                3,stevo,password3,steve,williams,employee,
//                4,tommy,password4,tom,thompson,mentor,
//                5,lizhenli,password5,li,zhen,student,
        ManagerController managerController = new ManagerController(new Manager(1, "2", "3", "4", "5", "6"));

    }
}
