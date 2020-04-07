package com.company.dao.Parser;

import java.util.List;

public interface Parser {
    List<List<String>> getListOfLines();
    void fillList();
    void convertFileToString();
    void convertStringToList();
    void addNewRecord(String[] newRecord);
    void updateFile(List<List<String>> newList, String header);

}
