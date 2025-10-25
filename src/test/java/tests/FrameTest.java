package tests;

import frontend.pages.AlertFrameWindowPage;
import frontend.pages.FramesPage;
import frontend.pages.IndexPage;
import frontend.sharedData.SharedData;
import org.testng.annotations.Test;
import suite.Suite;

public class FrameTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.SANITY_SUITE,Suite.ALERTWINDOWFRAME_SUITE})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithFrameSubmenu();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();
    }
}
