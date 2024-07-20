package webelements;

public class TMobileShoppingCartPageWebElements {
//    public static final String searchResultListWebEl = "//a[@class=\"srch-productCard__link\"]//div";
    public static final String searchResultListWebEl = "//h2[@class=\"phx:type-section-2 line-clamp clamp-count-2\"]";
//    public static final String colorListWebEl = "//span[@class=\"upf-skuSelector__oos\"]";
    public static final String colorListWebEl = "//fieldset//span[@class=\"phx:hide-visually\"]";
    public static final String productNotForSaleWebEl = "//span[@class=\"upf-productInventory__stock\"]";
    public static final String storageSizesListWebEl = "//span[contains(text(), 'GB')]";
    public static final String newCustomerButtonWebEl = "//span[normalize-space()='New customer']";
    public static final String newNumberButtonWebEl = "(//button[@data-analytics-widget-click=\"Button Click|Get a new number\"])[1]";
    public static final String skipTradeInButtonWebEl = "(//button[@data-analytics-widget-click=\"Button Click|Skip trade-in\"])[1]";
    public static final String paymentOptionWebEl = "//div[@x-show]//strong";
    public static final String addToCartButtonWebEl = "(//button[@data-analytics-click=\"Button Click|Add to cart\"])[1]";
    public static final String cartButtonWebEl = "//span[normalize-space()='Cart']";
//    public static final String numberOfItemInCartWebEl = "//*[@x-data=\"unavCart()\"]//span[2]";
//    public static final String numberOfItemInCartWebEl = "//span[@class='unav-headerTool__linkBadge']";
    public static final String numberOfItemInCartWebEl = "//a[@x-data=\"unavCart()\"]";
    public static final String planNamesListWebEl = "//h3[@class=\"upf-planCard__plan-name\"]";
    public static final String planButtonListWebEl = "//div[@class=\"upf-planCard__footer\"]//button";
    public static final String zipCodeInputWebEl = "upf-editZipCode__input";
    public static final String submitButtonWebEl = "//button[@class=\"tdds-button tdds-button--primary upf-editZipCode__submit\"]";
    public static final String popWindowsForProtectionWebEl = "//h1[contains(text(),\"Decline device protection?\")]";
    public static final String continueButtonWebEl = "//*[@id=\"btn-continue\"]";
    public static final String noDeviceProtectionWebEl = "//*[@id=\"none\"]";
    public static final String yesDeclineProtectionWebEl = "button-61eb2cb8dd";
    public static final String skipAccessoriesWebEl = "//button[@data-testid=\"skip-accessories-link\"]";
    public static final String nextButtonAccessoriesWebEl = "//button[@aria-label=\"accessories details add to cart\"]";
//    public static final String nextButtonAccessoriesWebEl = "//span[contains(text(),\" Skip accessories \")]";
    public static final String beginCheckoutWebEl = "//button[@data-testid=\"sticky-footer-checkout-cta\"]//span";
}
