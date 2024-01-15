package homework3;

import com.beust.jcommander.IVariableArity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class Part1 {
    private static final String Mail_URL= "https://mail.ru/";

    private WebDriver driver;

    @BeforeEach
    void SetUp() throws InterruptedException {
        driver= new ChromeDriver();
        driver.navigate().to(Mail_URL);
        var loginButton = driver.findElement(By.xpath("//*[contains(@class,'qrdeeap__de8k2m')]"));
        loginButton.click();
//        TimeUnit.MILLISECONDS.sleep(2000);
        var frameElement = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
        driver = driver.switchTo().frame(frameElement);

        var usernameTextField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameTextField.sendKeys("логин");
        var usernameButton = driver.findElement(By.xpath("//*[@data-test-id='next-button']"));
        usernameButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var passwordTextField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextField.sendKeys("пароль");
        var passwordButton = driver.findElement(By.xpath("//*[@data-test-id='submit-button']"));
        passwordButton.click();
    }

    @Test
    void testCreateMail() throws InterruptedException {
        driver.switchTo().defaultContent();
        TimeUnit.MILLISECONDS.sleep(2000);
        var inputMessages = driver.findElement(By.xpath("//*[contains(@class,'ph-project__link svelte-1sxvb4v ph-project__link_current')]"));
        assertThat(inputMessages.getText()).contains("Почта");
        var sendMailButton = driver.findElement(By.xpath("//*[contains(@class, 'sidebar__header')]//*[contains(@class, 'compose-button__wrapper')]"));
        sendMailButton.click();
//        var sentElement = driver.findElement(By.xpath("//input[@class='container--zU301']"));
//        driver = driver.switchTo().frame(sentElement);
        TimeUnit.MILLISECONDS.sleep(2000);
        var recipientTextField = driver.findElement(By.xpath("//*[contains(@class, 'container--zU301')]//input[contains(@class, 'container--H9L5q size_s--3_M-_ dark--7GF6F')]"));
        recipientTextField.sendKeys("degtyark@mail.ru");
        var subjectTextField = driver.findElement(By.xpath("//input[@name='Subject']"));
        subjectTextField.sendKeys("Sendmail");
        var letterTextField = driver.findElement(By.cssSelector(".cke_contents_true"));
        letterTextField.sendKeys("Первое письмо");
        var saveButton = driver.findElement(By.xpath("//*[@data-test-id='save']"));
        saveButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var closeButton = driver.findElement(By.xpath("//*[contains(@class, 'controls_container--17SRg dark--1HAzM')]//*[@title='Закрыть']"));
        closeButton.click();
        driver.switchTo().defaultContent();
        TimeUnit.MILLISECONDS.sleep(2000);
        var draftMailButton = driver.findElement(By.xpath("//*[contains(@id, 'sideBarContent')]//*[@title='Черновики']"));
//                .findElement(By.xpath("//*[contains(@class, 'hH8M4se js-shortcut hH8M4se_hH8M4YR hH8M4YX_hH8M4IN')]"));
        draftMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        assertThat(driver.getTitle())
                .as("Проверка, что открыта вкладка Черновики")
                .isEqualTo("Черновики - Почта Mail.ru");
        var letterMailLine = driver.findElement(By.cssSelector("[data-id='0:17051790571192571849:500001']"));
        letterMailLine.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var sendButton = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        sendButton.click();
        TimeUnit.MILLISECONDS.sleep(5000);
        driver.switchTo().defaultContent();
        var sentMessages = driver.findElement(By.xpath("//*[contains(@id, 'sideBarContent')]//*[@title='Отправленные']"));
        sentMessages.click();
        driver.switchTo().defaultContent();
        TimeUnit.MILLISECONDS.sleep(2000);
        assertThat(driver.getTitle())
                .as("Проверка, что открыта вкладка Отправленные")
                .isEqualTo("Отправленные - Почта Mail.ru");
        var letterSentMailLine = driver.findElement(By.cssSelector("[data-id='0:17051826301873561092:500000']"));
        letterSentMailLine.click();
    }

    @Test
    void testSendMail() throws InterruptedException {
        driver.switchTo().defaultContent();
        TimeUnit.MILLISECONDS.sleep(2000);
        var inputMessages = driver.findElement(By.xpath("//*[contains(@class,'ph-project__link svelte-1sxvb4v ph-project__link_current')]"));
        assertThat(inputMessages.getText()).contains("Почта");
        var sendMailButton = driver.findElement(By.xpath("//*[contains(@class, 'sidebar__header')]//*[contains(@class, 'compose-button__wrapper')]"));
        sendMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var recipientTextField = driver.findElement(By.xpath("//*[contains(@class, 'container--zU301')]//input[contains(@class, 'container--H9L5q size_s--3_M-_ dark--7GF6F')]"));
        recipientTextField.sendKeys("degtyark@mail.ru");
        var subjectTextField = driver.findElement(By.xpath("//input[@name='Subject']"));
        subjectTextField.sendKeys("Тест");
        var letterTextField = driver.findElement(By.cssSelector(".cke_contents_true"));
        letterTextField.sendKeys("Тестовое письмо для папки тест");
        var sendButton = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        sendButton.click();
        var draftMailButton = driver.findElement(By.xpath("//*[contains(@id, 'sideBarContent')]//*[@title='Тест']"));
        draftMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        assertThat(driver.getTitle())
                .as("Проверка, что открыта папка Тест")
                .isEqualTo("Тест - Почта Mail.ru");
        var letterMailLine = driver.findElement(By.cssSelector("[data-id='0:17051790561192571849:500000']"));
        letterMailLine.click();
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    @Test
    void testDeleteMail() throws InterruptedException {
        driver.switchTo().defaultContent();
        TimeUnit.MILLISECONDS.sleep(2000);
        var inputMessages = driver.findElement(By.xpath("//*[contains(@class,'ph-project__link svelte-1sxvb4v ph-project__link_current')]"));
        assertThat(inputMessages.getText()).contains("Почта");
        var sendMailButton = driver.findElement(By.xpath("//*[contains(@class, 'sidebar__header')]//*[contains(@class, 'compose-button__wrapper')]"));
        sendMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var recipientTextField = driver.findElement(By.xpath("//*[contains(@class, 'container--zU301')]//input[contains(@class, 'container--H9L5q size_s--3_M-_ dark--7GF6F')]"));
        recipientTextField.sendKeys("degtyark@mail.ru");
        var subjectTextField = driver.findElement(By.xpath("//input[@name='Subject']"));
        subjectTextField.sendKeys("Письмо для удаления");
        var letterTextField = driver.findElement(By.cssSelector(".cke_contents_true"));
        letterTextField.sendKeys("Тестовое письмо для удаления");
        var sendButton = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        sendButton.click();
        var draftMailButton = driver.findElement(By.xpath("//*[contains(@id, 'sideBarContent')]//*[@title='Тест']"));
        draftMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        assertThat(driver.getTitle())
                .as("Проверка, что открыта папка Тест")
                .isEqualTo("Тест - Почта Mail.ru");
        var letterMailLine = driver.findElement(By.cssSelector("[data-id='0:170517905711925717249:5000002']"));
        letterMailLine.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var deleteMailButton = driver.findElement(By.xpath("//*[contains(@class, 'only-new-toolbar new-menu content-header')]//*[@title='Удалить']"));
        deleteMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        var trashMailButton = driver.findElement(By.xpath("//*[contains(@id, 'sideBarContent')]//*[@title='Корзина']"));
        trashMailButton.click();
        TimeUnit.MILLISECONDS.sleep(2000);
        assertThat(driver.getTitle())
                .as("Проверка, что открыта Корзина")
                .isEqualTo("Корзина - Почта Mail.ru");
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

