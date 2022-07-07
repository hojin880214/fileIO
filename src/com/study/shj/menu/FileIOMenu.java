package com.study.shj.menu;

import com.study.shj.annotation.FileAnnotationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileIOMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileIOMenu.class);
    FileAnnotationHandler fileAnnotationHandler = new FileAnnotationHandler();

    public void printFileIOMenu() {

        LOGGER.info("");
        LOGGER.info("-----------------------FileIO-------------------------");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("1. 새 파일");
        LOGGER.info("2. 파일 열기");
        LOGGER.info("3. 나가기");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("콘솔창에 해당하는 숫자를 입력해주세요.");

    }

    private int selectScannerNumber() {

        int selectedNumber = 0;
        try {
            Scanner sc = new Scanner(System.in);
            selectedNumber = sc.nextInt();
        } catch (InputMismatchException E) {
            LOGGER.error("잘못 입력하셨습니다. 아라비안 숫자를 올바르게 입력해주세요.");
        } finally {
            if (selectedNumber == 0) selectScannerNumber();
        }

        return selectedNumber;

    }

    private boolean isValidFileIOMenuNumber(int number){

        boolean bool = number < 4;
        if(!bool) LOGGER.error("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");

        return bool;

    }

    public int selectFileIOMenuNumber(){

        int selectedNumber = selectScannerNumber();
        if(!isValidFileIOMenuNumber(selectedNumber)) {
            return selectFileIOMenuNumber();
        }
        return selectedNumber;

    }


    public boolean selectFileIOMenu(int selectedNumber) {

        switch (selectedNumber) {
            case 1:
                LOGGER.info("1. 새 파일 선택하셨습니다.");
                break;
            case 2:
                LOGGER.info("2. 파일 열기 선택하셨습니다.");
                break;
            case 3:
                LOGGER.info("3. 나가기 선택하셨습니다. 종료합니다.");
                return true;
        }

        fileAnnotationHandler.handleFileAnnotation(selectedNumber);

        return false;

    }
}
