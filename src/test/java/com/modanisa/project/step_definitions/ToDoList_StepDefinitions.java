package com.modanisa.project.step_definitions;

import com.modanisa.project.pages.BasePage;
import com.modanisa.project.utilities.ConfigurationReader;
import com.modanisa.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ToDoList_StepDefinitions {

    BasePage basePage=new BasePage();

    @Given("Empty ToDo list")
    public void emptyToDoList() {
        Driver.getDriver().get(ConfigurationReader.getProperty("baseURL"));
    }

    @When("I write {string} to <text box> and press <enter>")
    public void i_write_to_text_box_and_press_enter(String keyword) {
       basePage.inputBox.sendKeys(keyword+ Keys.ENTER);
    }
    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_to_do_list(String expectedInput) {
        Assert.assertEquals(expectedInput,basePage.toDoLabel.getText());
    }


}
