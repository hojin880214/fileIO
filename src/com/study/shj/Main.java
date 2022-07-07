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
     *
     * @version : 1.0.0
     * @author : SHJ
     * @param : args
     */
    public static void main(String[] args) {

        FileIOMenu fileIOMenu = new FileIOMenu();

        while(true){

            fileIOMenu.printFileIOMenu();
            fileIOMenu.selectFileIOMenu(fileIOMenu.selectFileIOMenuNumber());

        }
    }
}
