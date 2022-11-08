package com.ui.steps;

import java.util.List;

public class SharedData {


    protected List<String> carRegs;
    public List<String> getCarRegs() {
        return this.carRegs;
    }
    public void setCarRegs(List<String> carRegs) {
        this.carRegs = carRegs;
    }
    public final static String TEST_DATA_PATH = "src/test/resources/test_data/";
}
