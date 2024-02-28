package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {


    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        try {
            System.out.println("Vai clicar no elemento " + element);
            waitElementBeClickable(element, 10000);
            getDriver().findElement(element).click();
            System.out.println("clicou no elemento" + element);

        } catch (Exception error) {
            System.out.println("Aconteceu algum erro ao tentar clicar no " + element);

            new Exception(error);


        }


    }

    public static void fillField(By element, String value) {
        try {
            System.out.println("Vai preencher o campo  " + element);
            waitElementBeVisible(element, 10000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("clicou no elemento" + element);

        } catch (Exception error) {
            System.out.println("Aconteceu algum erro ao tentar preencher o campo" + element);

            new Exception(error);


        }

    }

    public static void checkMessage(By element, String expectedmessage) {
        String actualMessage = "";


        waitElementBeVisible(element, 10000);
        actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals(expectedmessage, actualMessage);


        System.out.println("Aconteceu algum erro ao validar a mensagem");
        System.out.println("mensagem esperada" + expectedmessage);
        System.out.println("mensagem atual" + actualMessage);


    }
}