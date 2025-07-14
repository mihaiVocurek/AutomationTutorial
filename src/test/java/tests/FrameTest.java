package tests;

import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.IndexPage;
import sharedData.SharedData;
import org.testng.annotations.Test;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithFrameSubmenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();
    }
}
