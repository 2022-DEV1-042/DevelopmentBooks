package com.store.developmentbooks.object;

public class Order {
    private int cleanCode;
    private int cleanCoder;
    private int cleanArchitecture;
    private int testDriverDevelopment;
    private int workingEffectivelyWithLegacyCode;

    public Order(){

    }

    public Order(int cleanCode, int cleanCoder, int cleanArchitecture, int testDriverDevelopment, int workingEffectivelyWithLegacyCode){
        this.cleanCode = cleanCode;
        this.cleanCoder = cleanCoder;
        this.cleanArchitecture = cleanArchitecture;
        this.testDriverDevelopment = testDriverDevelopment;
        this.workingEffectivelyWithLegacyCode = workingEffectivelyWithLegacyCode;
    }

    public int getCleanCode() {
        return cleanCode;
    }

    public void setCleanCode(int cleanCode) {
        this.cleanCode = cleanCode;
    }

    public int getCleanCoder() {
        return cleanCoder;
    }

    public void setCleanCoder(int cleanCoder) {
        this.cleanCoder = cleanCoder;
    }

    public int getCleanArchitecture() {
        return cleanArchitecture;
    }

    public void setCleanArchitecture(int cleanArchitecture) {
        this.cleanArchitecture = cleanArchitecture;
    }

    public int getTestDriverDevelopment() {
        return testDriverDevelopment;
    }

    public void setTestDriverDevelopment(int testDriverDevelopment) {
        this.testDriverDevelopment = testDriverDevelopment;
    }

    public int getWorkingEffectivelyWithLegacyCode() {
        return workingEffectivelyWithLegacyCode;
    }

    public void setWorkingEffectivelyWithLegacyCode(int workingEffectivelyWithLegacyCode) {
        this.workingEffectivelyWithLegacyCode = workingEffectivelyWithLegacyCode;
    }
}
