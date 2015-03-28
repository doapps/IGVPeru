package me.doapps.model;

/**
 * Created by jonathan on 28/03/2015.
 */
public class History_DTO {
    private String companyName;
    private String rucNumber;
    private String period;
    private String date;

    public History_DTO(){}

    public History_DTO(String companyName, String rucNumber, String period, String date) {
        this.companyName = companyName;
        this.rucNumber = rucNumber;
        this.period = period;
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRucNumber() {
        return rucNumber;
    }

    public void setRucNumber(String rucNumber) {
        this.rucNumber = rucNumber;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
