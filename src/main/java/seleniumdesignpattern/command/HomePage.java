package seleniumdesignpattern.command;

import driver.Driver;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private By btnInfoMsg = By.xpath("//div[@class='button-box']/button[text()='Info Message']");
    private By btnWarnMsg = By.xpath("//div[@class='button-box']/button[text()='Warning Message']");
    private By btnSuccMsg = By.xpath("//div[@class='button-box']/button[text()='Success Message']");
    private By btnDangerMsg = By.xpath("//div[@class='button-box']/button[text()='Danger Message']");
    private By infoAlert = By.className("jq-icon-info");
    private By warnAlert = By.className("jq-icon-warning");
    private By successAlert = By.className("jq-icon-success");
    private By errorAlert = By.className("jq-icon-error");
    // dismissal Alert
    private By dismissalSuccessAlert = By.className("alert-success");
    private By dismissalDangerAlert = By.className("alert-danger");
    private By dismissalWarningAlert = By.className("alert-warning");
    private By dismissalInfoAlert = By.className("alert-info");


    public void goTo(){
        Driver.getDriver().get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidator(){
        return Arrays.asList(
                // notification
                new NotificationValidator(Driver.getDriver().findElement(btnInfoMsg),Driver.getDriver().findElement(infoAlert)),
                new NotificationValidator(Driver.getDriver().findElement(btnSuccMsg),Driver.getDriver().findElement(successAlert)),
                new NotificationValidator(Driver.getDriver().findElement(btnWarnMsg),Driver.getDriver().findElement(warnAlert)),
                new NotificationValidator(Driver.getDriver().findElement(btnDangerMsg),Driver.getDriver().findElement(errorAlert)),
                // dismiss
                new DismissalAlertValidator(Driver.getDriver().findElement(dismissalInfoAlert)),
                new DismissalAlertValidator(Driver.getDriver().findElement(dismissalSuccessAlert)),
                new DismissalAlertValidator(Driver.getDriver().findElement(dismissalWarningAlert)),
                new DismissalAlertValidator(Driver.getDriver().findElement(dismissalDangerAlert))
        );
    }
}
