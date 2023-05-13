package com.kiran.extentreports.utils;

import java.io.File;
import java.util.Objects;

public class CommonUtils {

    private CommonUtils(){}

    public static void deleteFolderContents(String folderPath, boolean isRecursive){
        File directory = new File(folderPath);
        for(File file : Objects.requireNonNull(directory.listFiles())){
            if(isRecursive){
                if(file.isFile())
                    file.delete();
                else
                    deleteFolderContents(file.getPath(),isRecursive);
            }else {
                file.delete();
            }
        }
    }
}
