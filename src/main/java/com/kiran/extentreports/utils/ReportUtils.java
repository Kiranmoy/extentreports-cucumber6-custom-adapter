package com.kiran.extentreports.utils;

import java.io.File;
import java.util.*;

public class ReportUtils {

    public static final String logFolderPath = System.getProperty("output.report.log.base.folder");

    private ReportUtils(){}

    public static void deleteExistingLogBeforeExecution(){

        File file = new File(logFolderPath);
        if(file.exists() && file.isDirectory()) {
            CommonUtils.deleteFolderContents(logFolderPath,false);
        }else{
            file.mkdir();
        }
    }

    public static String getScenarioLogFileName(String scenarioName){
        File[] files = new File(logFolderPath).listFiles();
        String scenarioLogFileName="";
        if(files!=null){
            for(File file : files){
                if(file.getName().startsWith(scenarioName))
                    scenarioLogFileName = file.getName();
            }
        }
        return scenarioLogFileName;
    }

    public static List<String> filterTestCaseTags(List<String> scenarioTags){
        Set<String> testCaseIdList = new HashSet<>();
        for(String test : scenarioTags){
            if(test.startsWith("@TCID")){
                String testId = test.split("-")[1];
                testCaseIdList.add(testId);
            }
        }
        List<String> testCaseIdSortedList = new ArrayList<>(testCaseIdList);
        Collections.sort(testCaseIdSortedList);
        return testCaseIdSortedList;
    }

    public static void executeTestCaseInRally(String testCase, String status){
        if(status.equalsIgnoreCase("PASSED")){
            // PASSED THE TEST CASE IN RALLY
        }else{
            // FAILED THE TEST CASE IN RALLY
        }
    }

}
