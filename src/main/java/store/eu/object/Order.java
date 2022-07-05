package store.eu.object;

public class Order {
    private int cleanCode;
    private int cleanCoder;
    private int cleanArchitecture;
    private int testDriverDevelopment;
    private int workingEffectivelyWithLegacyCode;

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

    public int getCleanCoder() {
        return cleanCoder;
    }

    public int getCleanArchitecture() {
        return cleanArchitecture;
    }

    public int getTestDriverDevelopment() {
        return testDriverDevelopment;
    }

    public int getWorkingEffectivelyWithLegacyCode() {
        return workingEffectivelyWithLegacyCode;
    }
}
