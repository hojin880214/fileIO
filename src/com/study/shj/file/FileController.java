package com.study.shj.file;

import com.study.shj.annotation.Controller;
import com.study.shj.annotation.FileMapping;
import lombok.RequiredArgsConstructor;

/**
 *  파일 컨트롤러 클래스
 *
 * @version : 1.0.0
 * @author : SHJ
 */
@RequiredArgsConstructor
@Controller
public class FileController {

    private final FileService fileService;

    @FileMapping(menuNumber = 1)
    public void addFile(){
        fileService.addFile();
    }

    @FileMapping(menuNumber = 2)
    public void readFile(){
        fileService.makeTextFileList();
        fileService.readFile();
    }

}
