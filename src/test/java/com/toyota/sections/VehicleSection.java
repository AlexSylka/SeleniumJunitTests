package com.toyota.sections;

import com.toyota.CustomSelect;
import com.toyota.entities.VehicleDetails;
import org.openqa.selenium.WebDriver;

public class VehicleSection extends BaseSection {

    private CustomSelect vehicleSeriesSelect;
    private CustomSelect vehicleModelSelect;

    public VehicleSection(WebDriver webDriver) {
        this.webDriver = webDriver;
        vehicleSeriesSelect = new CustomSelect(webDriver, "seriesName");
        vehicleModelSelect = new CustomSelect(webDriver, "modelName");
    }

    public void selectVehicle(VehicleDetails vehicleDetails) {
        vehicleSeriesSelect.selectByVisibleText(vehicleDetails.getSeriesName());
        vehicleModelSelect.selectByVisibleText(vehicleDetails.getModelName());
    }

}
