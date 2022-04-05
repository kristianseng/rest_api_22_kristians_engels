package ClickUpApi.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ClickUpApi.helpers.TestCaseContext;

import static ClickUpApi.clients.ClickUpClient.deleteFolder;


public class Hooks {

    @Before
    public void beforeEveryScenario(){
        TestCaseContext.init();
        System.out.println("THE SCENARIO IS BEGINNING THE EXECUTION!");
    }

    @After
    public void afterEveryScenario(){
        deleteFolder();
        System.out.println("THE SCENARIO IS FINISHED!");
    }

}
