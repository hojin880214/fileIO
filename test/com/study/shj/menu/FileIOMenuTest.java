package com.study.shj.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileIOMenuTest {

    @Test
    void printFileIOMenu() {
        FileIOMenu fileIOMenu = new FileIOMenu();
        fileIOMenu.printFileIOMenu();
    }

    @Test
    void selectFileIOMenuNumber() {
        FileIOMenu fileIOMenu = new FileIOMenu();
        fileIOMenu.selectFileIOMenuNumber();
    }

    @Test
    void selectFileIOMenu() {
    }
}