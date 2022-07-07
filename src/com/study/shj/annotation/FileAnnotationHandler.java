package com.study.shj.annotation;

import com.study.shj.file.FileDAOImpl;
import com.study.shj.file.FileServiceImpl;
import com.study.shj.myBatis.MyBatisConnectionFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class FileAnnotationHandler {

        public void handleFileAnnotation(int num){

        try{
            Class clazz = Class.forName("com.study.shj.file.FileController");
            Class[] constructorParameterTypes = {com.study.shj.file.FileService.class};
            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation annotation : annotations) {
                if (!(annotation instanceof Controller)) continue;
                for (Method method : clazz.getDeclaredMethods()) {
                    if (!method.isAnnotationPresent(FileMapping.class)) continue;
                    FileMapping fileMapping = method.getDeclaredAnnotation(FileMapping.class);
                    if(!(num == fileMapping.menuNumber())) return;
                    Constructor constructor = clazz.getConstructor(constructorParameterTypes);
                    FileDAOImpl fileDAOImpl = new FileDAOImpl(MyBatisConnectionFactory.getSqlSessionFactory());
                    FileServiceImpl fileServiceImpl = new FileServiceImpl(fileDAOImpl);
                    method.invoke(constructor.newInstance(fileServiceImpl));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

//    public void handleFileAnnotation(int num) {
//
//        try {
//            Class<?> clazz = Class.forName("com.study.shj.file.FileController");
//            Annotation[] annotations = clazz.getAnnotations();
//            for (Annotation annotation : annotations) {
//                if (!(annotation instanceof Controller)) continue;
//                getFileServiceMethod(num, clazz);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private void getFileServiceMethod(int num, Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        for (Method method : clazz.getDeclaredMethods()) {
//            checkFileMappingAnnotation(num, clazz, method);
//        }
//    }
//
//    private void checkFileMappingAnnotation(int num, Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        if (method.isAnnotationPresent(RequestMapping.class)) {
//            getFileMappingMenuNumber(num, clazz, method);
//        }
//    }
//
//    private void getFileMappingMenuNumber(int num, Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
//        checkMenuNumber(num, clazz, method, requestMapping);
//    }
//
//    private void checkMenuNumber(int num, Class<?> clazz, Method method, RequestMapping requestMapping) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        if (!(num == requestMapping.menuNumber())) return;
//        invokeMethod(clazz, method);
//    }
//
//    private void invokeMethod(Class<?> clazz, Method method) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Class<?>[] constructorParameterTypes = {com.study.shj.file.FileDAO.class};
//        Constructor<?> constructor = clazz.getConstructor(constructorParameterTypes);
//        FileDAOImpl fileDAOImpl = new FileDAOImpl(MyBatisConnectionFactory.getSqlSessionFactory());
//        method.invoke(constructor.newInstance(fileDAOImpl));
//    }