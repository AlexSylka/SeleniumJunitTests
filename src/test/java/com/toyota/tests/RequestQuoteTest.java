package com.toyota.tests;

import com.toyota.pages.RequestQuotePage;
import com.toyota.pages.ShoppingToolsPage;
import org.junit.Test;

public class RequestQuoteTest extends BaseTest {

    private ShoppingToolsPage shoppingToolsPage;
    private RequestQuotePage requestQuotePage;

    @Test
    public void testRequestQuote() {
        shoppingToolsPage = new ShoppingToolsPage(driver);
        shoppingToolsPage.clickShoppingToolsLinkLink();
        shoppingToolsPage.clickRequestQuoteLinkLink();
    }
}
