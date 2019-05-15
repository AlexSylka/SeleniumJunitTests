package com.toyota.entities;

public class VehicleDetails {

    private String seriesName;
    private String modelName;

    public VehicleDetails(String seriesName, String modelName) {
        this.seriesName = seriesName;
        this.modelName = modelName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getModelName() {
        return modelName;
    }

}
