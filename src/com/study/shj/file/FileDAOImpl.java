package com.study.shj.file;


import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@RequiredArgsConstructor
public class FileDAOImpl implements FileDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileDAOImpl.class);

    private final SqlSessionFactory sqlSessionFactory;

    @Override
    public int addFile(Map<String,String> hashMap) {
        int resultIntVal = 0;
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            LOGGER.info(sqlSessionFactory.toString());
            resultIntVal = sqlSession.insert("File.insert", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultIntVal;

    }

    @Override
    public void readFile() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            LOGGER.info(sqlSessionFactory.toString());
            sqlSession.selectList("File.selectList");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//
//    private String getFileContent(String fileFullPath) {
//        String fileContent = "";
//        int lineNumber = 0;
//        try (
//                FileWriter fw = new FileWriter(fileFullPath, false);
//                BufferedWriter bw = new BufferedWriter(fw)
//        ) {
//            System.out.println(fileFullPath + " 이 생성되었습니다.");
//            System.out.println("파일 내용을 입력해주세요.(입력 종료는 개행 후 :q 입력해주세요)" + System.lineSeparator());
//            while (true) {
//                System.out.print(" " + ++lineNumber + " ");
//                String line = scanner.nextLine();
//                if((line.equals(":q"))) break;
//                fileContent = fileContent.concat(line + System.lineSeparator());
//                bw.write(line);
//                bw.newLine();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileContent;
//    }
//
//    private String getScannerFileName() {
//        LOGGER.info("파일 이름을 적어주세요.");
//        String fileName = scanner.nextLine();
//        return fileName;
//    }
//
//    @Override
//    public void addFileList(FileVO fileVO) {
////        fileList.add(fileVO);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        try{
//            sqlSession.insert("File.insert",fileVO);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            sqlSession.close();
//        }
//        sqlSession = sqlSessionFactory.openSession();
//        try{
//            fileList = sqlSession.selectList("File.selectList");
//            System.out.println("");
//        }finally {
//            sqlSession.close();
//        }
//    }
//
//    @Override
//    public void printFileList() {
//
//        System.out.println("----------------------파일목록-------------------------");
//        fileList.forEach(fileVO -> System.out.println((fileList.indexOf(fileVO)) + 1 + ". " + fileVO.toStringFileList()));
//        System.out.println("------------------------------------------------------" + System.lineSeparator());
//
//    }
//
//    @Override
//    public void makeTextFileList() {
//
//        File dir = new File(projectPath + "\\file\\");
//        FilenameFilter filter = (f, name) -> name.contains("txt");
//        File[] files = dir.listFiles(filter);
//        textFileList.clear();
//        for (File file : Objects.requireNonNull(files)) {
//            textFileList.add(file.toString());
//        }
//
//    }
//
//    @Override
//    public int textFileMaxIndex() {
//        return textFileList.size();
//    }
//
//    @Override
//    public void showTextFileList() {
//
//        System.out.println(System.lineSeparator() + "----------------------파일목록-------------------------");
//        textFileList.forEach(String -> System.out.println((textFileList.indexOf(String)) + 1 + ". " + String.substring(String.lastIndexOf("\\") + 1)));
//        System.out.println("------------------------------------------------------");
//
//    }
//
//    @Override
//    public void readTextFileList(int selectedNumber) {
//
//        int lineNumber = 0;
//        try {
//            Path path = Paths.get(textFileList.get(selectedNumber - 1));
//            List<String> allLines = Files.readAllLines(path);
//            System.out.println(System.lineSeparator() + path);
//            System.out.println("------------------------------------------------------");
//            System.out.println("------------------------------------------------------");
//            for (String line : allLines) {
//                System.out.println(RESET + " " + ++lineNumber + " " + BACKGROUND_GREEN + FONT_BLACK + " " + line);
//            }
//            System.out.println(RESET + "------------------------------------------------------");
//            System.out.println("------------------------------------------------------" + System.lineSeparator());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
