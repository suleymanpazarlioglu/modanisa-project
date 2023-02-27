package com.modanisa.project.pages;

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

    @FindBy(xpath = "//label[.='buy some milk']")
    public WebElement toDoLabel;


}
