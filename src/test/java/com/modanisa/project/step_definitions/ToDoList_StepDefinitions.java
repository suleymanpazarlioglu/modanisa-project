package com.modanisa.project.step_definitions;

import com.modanisa.project.pages.BasePage;
import com.modanisa.project.utilities.ConfigurationReader;
import com.modanisa.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.NoSuchElementException;

public class ToDoList_StepDefinitions {

    BasePage basePage=new BasePage();

    @Given("Empty ToDo list")
    public void emptyToDoList() {
        basePage.setup();
    }

    @When("I write {string} to <text box> and press <enter>")
    public void i_write_to_text_box_and_press_enter(String keyword) {
       basePage.inputBox.sendKeys(keyword+ Keys.ENTER);
    }
    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_to_do_list(String expectedInput) {
        Assert.assertEquals(expectedInput,basePage.toDoList1.getText());
    }

    @Given("ToDo list with {string} item")
    public void to_do_list_with_item(String keyword) {
        basePage.setup();
        basePage.inputBox.sendKeys(keyword+ Keys.ENTER);

    }
    @Then("I should see {string} item insterted to ToDo list below {string} item")
    public void i_should_see_item_insterted_to_to_do_list_below_item(String list1, String list2) {
        Assert.assertTrue(basePage.toDoList1.getText().contains(list2));
        Assert.assertTrue(basePage.toDoList2.getText().contains(list1));

    }

    @When("I click on <checkbox> next to {string} item")
    public void i_click_on_checkbox_next_to_item(String string) {
        basePage.checkBox.click();
    }
    @Then("I should see {string} item mark as done")
    public void i_should_see_item_mark_as_done(String string) {
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//li[@class='todo completed']")).isDisplayed());
    }

    @Given("ToDo list with marked item")
    public void to_do_list_with_marked_item() {
        basePage.setup();
        basePage.inputBox.sendKeys("buy some milk"+ Keys.ENTER);
        basePage.checkBox.click();

    }
    @Then("I should see {string} item marked as UNDONE")
    public void i_should_see_item_marked_as_undone(String string) {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//li[@class='todo']")).isDisplayed());

    }
    @When("I click on <delete button> next to {string} item")
    public void i_click_on_delete_button_next_to_item(String string) {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(basePage.toDoList1).perform();
        basePage.deleteButton.click();
    }
    @Then("List should be empty")
    public void list_should_be_empty() {
        Assert.assertEquals("",basePage.todoCount.getText());

    }

    @Given("ToDo list with {string} and {string} item in order")
    public void to_do_list_with_and_item_in_order(String firstItem, String secondItem) {
        basePage.setup();
        basePage.inputBox.sendKeys(firstItem+ Keys.ENTER);
        basePage.inputBox.sendKeys(secondItem+ Keys.ENTER);
    }






}
