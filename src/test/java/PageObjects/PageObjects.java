package PageObjects;

import ObjectIdentifiers.PageObjectIdentifiers;

public class PageObjects extends PageObjectIdentifiers {

    public void flipkartLogin () throws Exception {

        userId.sendKeys(prop.getProperty("Username"));
        password.sendKeys(prop.getProperty("Password"));
        ReportResult(true,  "LoginPage" );
        LogInButton.click();

    }

    public void flipkartHomePage () throws Exception {

        DynamicWait();
        setExcelFile(TESTDATA_SHEET_PATH, "Sheet1");
        System.out.println("value passes " + getCellData(1, 1));
        SearchBox.sendKeys(getCellData(1, 1));
        SearchButton.click();
        Thread.sleep(20000);
        ReportResult(true, "SearchResult");
        prepareWebElementWithDynamicXpath(SpecificItemXpath, "ItemNo", n1).click();
        Thread.sleep(10000);
        switchWindow();

    }


    public void flipkartProuctPage () throws Exception {

        ReportResult(AddToCart.isDisplayed(), "ProductPage");
        retryingFindClick(AddToCart);

    }

    public void flipkartCart () throws Exception {
        ReportResult(PlaceOrder.isDisplayed(), "CartPage");
        retryingFindClick(PlaceOrder);

    }

    public void flipkartOrderPage () throws Exception {
        ReportResult(ContinueButton.isDisplayed(),  "OrderSummary" );
        ContinueButton.click();
        ReportResult(true,  "PaymentDetails" );

       }

}
