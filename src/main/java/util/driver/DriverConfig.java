package util.driver;

import util.config.ConfigManager;

public class DriverConfig extends ConfigManager {

    public DriverConfig() {
        super();
        baseUrlValue = prop.getProperty(baseUrl);
        inventoryUrlValue = prop.getProperty(inventoryUrl);
        checkoutCompleteUrlValue  = prop.getProperty(checkoutCompleteUrl);
        browserValue = prop.getProperty(browser);
    }

    public String getBaseUrlValue(){ return baseUrlValue; }

    public String getInventoryUrlValue(){ return inventoryUrlValue; }

    public String getBrowserValue(){
        return browserValue;
    }

    public String checkoutCompleteUrlValue(){ return checkoutCompleteUrlValue;
    }

}
