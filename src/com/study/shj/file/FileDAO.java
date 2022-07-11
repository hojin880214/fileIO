package com.study.shj.file;

import java.util.Map;

public interface FileDAO {

    int addFile(Map<String,String> hashMap);
    void readFile();
//    void addFileList(FileVO fileVO);
//    void printFileList();
//    void makeTextFileList();
//    int textFileMaxIndex();
//    void showTextFileList();
//    void readTextFileList(int selectedNumber);

}
