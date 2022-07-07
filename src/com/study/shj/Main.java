package com.study.shj;

import com.study.shj.menu.FileIOMenu;

/**
 *  파일 입출력 메인클래스
 *
 * @version : 1.0.0
 * @author : SHJ
 */
public class Main {

    /**
     *  <p>파일 입출력 메인함수</p>
     *  <p>파일 메뉴를 보여주고 사용할 메뉴 번호를 입력하여 작동</p>
     *  <p>while 문으로 계속 반복하고 나가기 선택했을 때 break 로 종료</p>
     *
     * @version : 1.0.0
     * @author : SHJ
     * @param args 문자배열
     */
    public static void main(String[] args) {

        FileIOMenu fileIOMenu = new FileIOMenu();

        while(true){

            fileIOMenu.printFileIOMenu();
            if(fileIOMenu.selectFileIOMenu(fileIOMenu.selectFileIOMenuNumber())) break;

        }
    }
}
