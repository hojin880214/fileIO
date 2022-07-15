package com.study.shj.file;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    private final FileDAO fileDAO;

    private final String projectPath = System.getProperty("user.dir");
    private final String fileDirectory = projectPath + "\\file\\";
    Scanner scanner = new Scanner(System.in);
    // final 인데 List clear 하고 데이터 넣어도 되는 이유 궁금
    private final List<String> textFileList = new ArrayList<>();

    public static final String RESET = "\u001B[0m";
    public static final String FONT_BLACK = "\u001B[30m";
    public static final String BACKGROUND_GREEN = "\u001B[42m";

    @Override
    public void addFile(){

        String fileName = getScannerFileName();
        String fileFullPath = fileDirectory + fileName + ".txt";
        String fileContent = getFileContent(fileFullPath);
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("fileName",fileName);
        hashMap.put("fileFullPath",fileFullPath);
        hashMap.put("fileContent",fileContent);
        int resultIntVal = fileDAO.addFile(hashMap);
        if( resultIntVal != 1 ){
            try {
                Files.delete(Paths.get(fileFullPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
            LOGGER.info("파일 내용을 입력해주세요.(입력 종료는 개행 후 :wq! 입력해주세요)" + System.lineSeparator());
            while (true) {
                System.out.print(" " + ++lineNumber + " ");
                String line = scanner.nextLine();
                if((line.equals(":wq!"))) break;
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

    @Override
    public void makeTextFileList() {

        File dir = new File(fileDirectory);
        if(dir.mkdirs()){
            LOGGER.info(fileDirectory + "폴더 생성완료");
        }
        FilenameFilter filter = (f, name) -> name.contains("txt");
        File[] files = dir.listFiles(filter);
        textFileList.clear();
        for (File file : Objects.requireNonNull(files)) {
            textFileList.add(file.toString());
        }

    }

    @Override
    public void showTextFileList() {

        System.out.println(System.lineSeparator() + "----------------------파일목록-------------------------");
        textFileList.forEach(String -> System.out.println((textFileList.indexOf(String)) + 1 + ". " + String.substring(String.lastIndexOf("\\") + 1)));
        System.out.println("------------------------------------------------------");

    }

    @Override
    public int textFileMaxIndex() {
        return textFileList.size();
    }

    @Override
    public void readTextFileList(int selectedNumber) {

        int lineNumber = 0;
        try {
            Path path = Paths.get(textFileList.get(selectedNumber - 1));
            List<String> allLines = Files.readAllLines(path);
            System.out.println(System.lineSeparator() + path);
            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
            for (String line : allLines) {
                System.out.println(RESET + " " + ++lineNumber + " " + BACKGROUND_GREEN + FONT_BLACK + " " + line);
            }
            System.out.println(RESET + "------------------------------------------------------");
            System.out.println("------------------------------------------------------" + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void selectTextFile(){

        int textFileMaxIndex = textFileMaxIndex();
        System.out.print("읽을 파일 번호를 입력해주세요 : ");
        while (true) {
            int selectedNumber = scanner.nextInt();
            if(textFileMaxIndex >= selectedNumber){
                readTextFileList(selectedNumber);
                break;
            }
            System.err.print("해당하는 번호가 없습니다. 읽을 파일 번호를 다시 입력해주세요 : ");
        }

    }
}
