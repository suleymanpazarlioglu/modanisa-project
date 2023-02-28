package com.modanisa.project.pages;

import com.modanisa.project.utilities.ConfigurationReader;
import com.modanisa.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='new-todo']")
    public WebElement inputBox;

    @FindBy(xpath = "(//label)[2]")
    public WebElement toDoList1;

    @FindBy(xpath = "(//label)[3]")
    public WebElement toDoList2;

    @FindBy(xpath = "//input[@class='toggle']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@class='destroy']")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[@class='todo-count']/strong")
    public WebElement todoCount;

    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("baseURL"));
    }




}
