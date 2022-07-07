package com.study.shj.file;

import com.study.shj.annotation.Controller;
import com.study.shj.annotation.FileMapping;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileController {

    private final FileService fileService;

    @FileMapping(menuNumber = 1)
    public void addFile(){
        fileService.addFile();
    }

}
