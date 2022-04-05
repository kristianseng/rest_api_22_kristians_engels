package ClickUpApi.stepdefinitions;

import ClickUpApi.domain.Folder;
import ClickUpApi.domain.List;
import ClickUpApi.domain.Task;
import ClickUpApi.helpers.TestCaseContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static ClickUpApi.clients.ClickUpClient.*;


public class ClickUpSteps {

    String randomMustangModel = "Mustang" + Math.round(Math.random()*100);

    @Given("ClickUp Space exists")
    public void checkThatSpaceExists(){
            Response response = getSpaceInfo();
    }

    @When("I create a new folder with name {string}")
    public void createFolderInTheList(String name){
        Map<String,String> body = new HashMap<>();
        body.put("name", name);
        Response response = createFolder(body);
        Folder folder = response.as(Folder.class);
        TestCaseContext.setTestFolder(folder);
    }

    @Then("I verify that folder name is updated to {string}")
    public void checkFolderName(String name){
        Folder testBoard = TestCaseContext.getTestFolder();

        Assertions.assertThat(testBoard.getName())
                .as("Checking if the Folder name was updated!")
                .isEqualTo(name);
    }

    @Then("I add new List to the folder with name {string}")
    public void addNewList(String name){
        Folder testFolder = TestCaseContext.getTestFolder();
        Map<String,String> body = new HashMap<>();
        body.put("name", name);

        Response response = createList(body);
        List list = response.as(List.class);
        TestCaseContext.setTestList(list);
    }


    @When("I check that List name is {string} and it is added to correct folder")
    public void checkNameAndFolder(String name){
        Response response = getList();
        List list = response.as(List.class);

        List testList = TestCaseContext.getTestList();

        Assertions.assertThat(testList.getName())
                .as("I check that the list name is correct")
                .isEqualTo(name);
        Assertions.assertThat(testList.getFolderId())
                .as("I check that folder Id is correct")
                .isEqualTo(list.getFolderId());

    }

    @Then("I add a new task to the list")
    public void addTask(){
        Map<String,String> body = new HashMap<>();
        body.put("name", randomMustangModel);

        Response response = createTask(body);
        Task task = response.as(Task.class);
        TestCaseContext.setTestTask(task);
    }

    @Then("I verify that task name is correct")
    public void verifyTaskName(){
        Task task = TestCaseContext.getTestTask();

        Assertions.assertThat(task.getName())
                .as("Checking if the task name is correct!")
                .isEqualTo(randomMustangModel);
    }

    @Then("I remove Task created in the list")
    public void removeTask(){
        deleteTask();
    }

    @Then("I check that task is successfully removed")
    public void verifyTaskRemoved(){
        List list = TestCaseContext.getTestList();
        Assertions.assertThat(list.getTaskCount())
                .as("Checking if task is removed from list")
                .isEqualTo(null);
    }
}
