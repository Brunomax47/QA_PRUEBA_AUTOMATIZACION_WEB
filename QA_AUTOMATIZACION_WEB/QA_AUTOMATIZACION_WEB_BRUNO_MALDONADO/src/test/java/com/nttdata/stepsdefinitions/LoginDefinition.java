package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDefinition {

    private WebDriver driver;
    private Scenario scenario;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        //driver.quit();
    }

    @Dado("que me encuentro en la página de login de Juntoz")
    public void que_me_encuentro_en_la_página_de_login_de_Juntoz() {
        driver.get("https://juntoz.com/account/login");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales correo: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String correo, String contraseña) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(correo);
        loginSteps.typePassword(contraseña);
        loginSteps.login();
        screenShot();
    }


    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
