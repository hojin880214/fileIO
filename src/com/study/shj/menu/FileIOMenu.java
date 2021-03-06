package com.study.shj.menu;

import com.study.shj.annotation.FileAnnotationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  파일 입출력 메뉴 클래스
 *
 * @version : 1.0.0
 * @author : SHJ
 */
public class FileIOMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileIOMenu.class);
    FileAnnotationHandler fileAnnotationHandler = new FileAnnotationHandler();

    /**
     *  <p>파일 입출력 메뉴 출력 함수</p>
     *
     * @author : SHJ
     */
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

    /**
     *  <p>선택한 번호 유효성 체크하여 잘못된 번호 입력 시 번호 다시 입력 받도록 재귀</p>
     *
     * @author : SHJ
     * @exception : InputMismatchException
     * @return int
     */
    public int selectFileIOMenuNumber(){

        int selectedNumber = selectScannerNumber();
        if(!isValidFileIOMenuNumber(selectedNumber)) {
            return selectFileIOMenuNumber();
        }
        return selectedNumber;

    }

    /**
     *  <p>사용자가 선택한 번호로 메뉴 실행하는 함수</p>
     *  <p>어노테이션핸들러를 통해 해당 컨트롤러 호출</p>
r     *
     * @author : SHJ
     * @param selectedNumber 사용자가 선택한 번호
     * @return bool
     */
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

    /**
     *  <p>스캐너로 파일 입출력 메뉴 번호 선택</p>
     *  <p>숫자 외에 다른 것을 입력했을 때 숫자를 입력하도록 함수를 다시 실행 (재귀)<p/>
     *
     * @author : SHJ
     * @exception : InputMismatchException
     * @return int
     */
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

    /**
     *  <p>입력 받은 번호가 메뉴 번호에 있는지 bool 값으로 리턴</p>
     *
     * @author : SHJ
     * @param number 스캐너로 입력받은 메뉴번호
     * @return bool
     */
    private boolean isValidFileIOMenuNumber(int number){

        boolean bool = number < 4;
        if(!bool) LOGGER.error("잘못 입력하셨습니다. 해당하는 숫자를 다시 입력해주세요.");

        return bool;

    }

}
