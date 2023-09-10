package nl.svb.lease.carservice.model;

// TODO make entity
public class Car {
    private int id;
    private String make;
    private String model;
    private String version;
    private int numberOfDoors;
    private String coO2Emission;
    private String grossPrice;
    private String nettPrice;
    private int horsePower;

    public Car(String make, String model, String version, int numberOfDoors, String grossPrice, String nettPrice, int horsePower) {
        this.make = make;
        this.model = model;
        this.version = version;
        this.numberOfDoors = numberOfDoors;
        this.grossPrice = grossPrice;
        this.nettPrice = nettPrice;
        this.horsePower = horsePower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getCoO2Emission() {
        return coO2Emission;
    }

    public void setCoO2Emission(String coO2Emission) {
        this.coO2Emission = coO2Emission;
    }

    public String getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(String grossPrice) {
        this.grossPrice = grossPrice;
    }

    public String getNettPrice() {
        return nettPrice;
    }

    public void setNettPrice(String nettPrice) {
        this.nettPrice = nettPrice;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
