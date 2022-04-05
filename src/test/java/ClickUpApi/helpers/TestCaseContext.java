package ClickUpApi.helpers;

import io.cucumber.java.Scenario;
import ClickUpApi.domain.Task;
import ClickUpApi.domain.List;
import ClickUpApi.domain.Folder;

public class TestCaseContext {
    private static Task testTask;
    private static List testList;
    private static Folder testFolder;
    private static Scenario scenario;

    public static void init(){
        testFolder = null;
        testList = null;
        testTask = null;
    }

    public static Task getTestTask() {
        return testTask;
    }

    public static void setTestTask(Task testTask) {
        TestCaseContext.testTask = testTask;
    }

    public static List getTestList() {
        return testList;
    }

    public static void setTestList(List testList) {
        TestCaseContext.testList = testList;
    }

    public static Folder getTestFolder() {
        return testFolder;
    }

    public static void setTestFolder(Folder testFolder) {
        TestCaseContext.testFolder = testFolder;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }
}
