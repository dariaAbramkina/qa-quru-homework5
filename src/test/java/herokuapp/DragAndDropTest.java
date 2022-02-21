package herokuapp;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
    @Test
    void SoftAssertionsPageIsExistOnWikiTab() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("[id='column-a']").dragAndDropTo($("[id='column-b']"));
        $$("[id='columns']").first().shouldHave(Condition.text("B"));

       /*
         DragAndDrop by actions isn't working
         WebElement elementOne = $("[id='column-a']");
         WebElement elementTwo = $("[id='column-b']");

         actions()
                .clickAndHold(elementOne)
                .moveByOffset(elementTwo.getLocation().x, elementTwo.getLocation().y)
                .release()
                .perform();
        */
    }
}
