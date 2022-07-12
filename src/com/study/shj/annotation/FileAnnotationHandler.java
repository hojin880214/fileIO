package com.study.shj.annotation;

import com.study.shj.file.FileDAOImpl;
import com.study.shj.file.FileServiceImpl;
import com.study.shj.myBatis.MyBatisConnectionFactoryEnum;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FileAnnotationHandler {

    public void handleFileAnnotation(int num){

        try{
            Class<?> clazz = Class.forName("com.study.shj.file.FileController");
            Class<?>[] constructorParameterTypes = {com.study.shj.file.FileService.class};
            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation annotation : annotations) {
                if (!(annotation instanceof Controller)) continue;
                for (Method method : clazz.getDeclaredMethods()) {
                    if (!method.isAnnotationPresent(FileMapping.class)) continue;
                    FileMapping fileMapping = method.getDeclaredAnnotation(FileMapping.class);
                    if(!(num == fileMapping.menuNumber())) continue;
                    Constructor<?> constructor = clazz.getConstructor(constructorParameterTypes);
                    FileDAOImpl fileDAOImpl = new FileDAOImpl(MyBatisConnectionFactoryEnum.INSTANCE.getSqlSessionFactory());
                    FileServiceImpl fileServiceImpl = new FileServiceImpl(fileDAOImpl);
                    method.invoke(constructor.newInstance(fileServiceImpl));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}