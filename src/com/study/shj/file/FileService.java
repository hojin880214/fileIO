package com.study.shj.file;

public interface FileService {

    void addFile();
    void makeTextFileList();
    void showTextFileList();
    int textFileMaxIndex();
    void readTextFileList(int selectedNumber);

    void selectTextFile();
}
