package com.study.shj.file;

import com.study.shj.annotation.Controller;
import com.study.shj.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    private final FileDAO fileDAO;

    private final String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addFile(){

        String fileName = getScannerFileName();
        String fileFullPath = projectPath + "\\file\\" + fileName + ".txt";
        String fileContent = getFileContent(fileFullPath);
        FileVO fileVO = new FileVO(fileFullPath,fileName,fileContent);
        fileDAO.addFile(fileVO);

    }

    @Override
    public void readFile(){

        System.out.println("readFile");
        fileDAO.readFile();

    }

    private String getScannerFileName() {

        LOGGER.info("파일 이름을 적어주세요.");

        return scanner.nextLine();

    }

    private String getFileContent(String fileFullPath) {

        String fileContent = "";
        int lineNumber = 0;
        try (
                FileWriter fw = new FileWriter(fileFullPath, false);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            LOGGER.info(fileFullPath + " 이 생성되었습니다.");
            LOGGER.info("파일 내용을 입력해주세요.(입력 종료는 개행 후 :q 입력해주세요)" + System.lineSeparator());
            while (true) {
                System.out.print(" " + ++lineNumber + " ");
                String line = scanner.nextLine();
                if((line.equals(":q"))) break;
                fileContent = fileContent.concat(line + System.lineSeparator());
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info(System.lineSeparator() + fileFullPath + "의 내용 입력을 완료하였습니다." + System.lineSeparator());

        return fileContent;

    }

}
