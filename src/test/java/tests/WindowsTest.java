package tests;

import pages.AlertFrameWindowPage;
import pages.IndexPage;
import pages.WindowsPage;
import sharedData.SharedData;
import org.testng.annotations.Test;
import suite.Suite;

public class WindowsTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.SANITY_SUITE,Suite.ALERTWINDOWFRAME_SUITE})
    public void testMethod(){

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithWindowsSubmenu();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.dealWithNewTab();
        windowsPage.dealWithNewWindow();

    }
}
