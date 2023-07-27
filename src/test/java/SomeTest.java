import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SomeTest {

    @BeforeMethod
    public void setUp() {

    }

    @Test
    // ვნიშნავ ჩეკბოქსს და ვამოწმებ რო ქონდეს  type 'checkbox' ორივეს
    public void testCheckbox() {
        Configuration.headless = true;
        open("http://the-internet.herokuapp.com/checkboxes");
        $("#checkboxes input[type='checkbox']:first-child").setSelected(true);
        $$("input[type='checkbox']").forEach(checkbox -> {
            checkbox.shouldHave(type("checkbox"));
        });

    }

    @Test
    //ვალიდაციას ვუკეთებ Please select an option მონიშნულია და option2 მონიშნულია
    public void testSelect() {
        open("http://the-internet.herokuapp.com/dropdown");
        $("#dropdown").shouldHave(text("Please select an option"));
        $("#dropdown").selectOption("Option 2");
        $("#dropdown").getSelectedOption().shouldHave(text("Option 2"), value("2"));

    }

    @Test
    // ვწვდები სხვადასხვა სელექტორებით, ვწერ ინფორმაციას და ვამოწმებ
    public void testCollectionAssertion() {
        open("https://demoqa.com/text-box ");
        $("input[autocomplete=off]").setValue("Shota Brokishvili");
        $("input[type=email]").setValue("shota.brokishvili@gmail.com");
        $(By.xpath("//textarea[@placeholder='Current Address']")).setValue("Tbilisi, tsereteli ave");
        $("#permanentAddress").setValue("Tbilisi, Didube");
//        $(byText("Submit")).click();
//
//        $$(By.xpath("//div[@class='border col-md-12 col-sm-12'] // p ")).shouldHave(exactTexts("Name:Shota Brokishvili", "Email:shota.brokishvili@gmail.com",
//                "Current Address :Tbilisi, tsereteli ave", "Permananet Address :Tbilisi, Didube"));
    }
}


