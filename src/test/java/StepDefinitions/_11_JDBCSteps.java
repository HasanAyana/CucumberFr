package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {
    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {

        ArrayList<ArrayList<String>> dbList= DBUtility.getListData(sorgu);
        System.out.println(dbList);

        DialogContent dc=new DialogContent();
        List<WebElement> uilist=dc.nameList;
        for(WebElement e: uilist)
            System.out.println(e.getText());


        for (int i = 0; i < dbList.size(); i++) {
            System.out.println("->"+dbList.get(i).get(1).trim()+"<-");
            System.out.println("->"+uilist.get(i).getText().trim()+"<-");

            Assert.assertEquals(dbList.get(i).get(1).trim(),uilist.get(i).getText().trim(),"Hatali mesaj");

        }

    }
}
