package com.modanisa.project.step_definitions;

import com.modanisa.project.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }
}
