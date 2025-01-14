package com.exel_to_db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StateInIndia {
    @Id
    private int sr_no;
    private String state;
    private String  iso;
    private String capital;
    private String largestCity;
    private String statehood;
    private Long population_2011;
    private Long area_km2;
    private String officialLanguages;
    private String additionalOfficialLanguages;
    private String vehicleCode;

    public StateInIndia(int sr_no, String state, String iso, String capital,
                        String largestCity, String statehood, Long population_2011, Long area_km2, String officialLanguages, String additionalOfficialLanguages, String vehicleCode) {
        this.sr_no = sr_no;
        this.state = state;
        this.iso = iso;
        this.capital = capital;
        this.largestCity = largestCity;
        this.statehood = statehood;
        this.population_2011 = population_2011;
        this.area_km2 = area_km2;
        this.officialLanguages = officialLanguages;
        this.additionalOfficialLanguages = additionalOfficialLanguages;
        this.vehicleCode = vehicleCode;
    }

    public StateInIndia() {
    }

    public int getSr_no() {
        return sr_no;
    }

    public void setSr_no(int sr_no) {
        this.sr_no = sr_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public void setLargestCity(String largestCity) {
        this.largestCity = largestCity;
    }

    public String getStatehood() {
        return statehood;
    }

    public void setStatehood(String statehood) {
        this.statehood = statehood;
    }

    public Long getPopulation_2011() {
        return population_2011;
    }

    public void setPopulation_2011(Long population_2011) {
        this.population_2011 = population_2011;
    }

    public Long getArea_km2() {
        return area_km2;
    }

    public void setArea_km2(Long area_km2) {
        this.area_km2 = area_km2;
    }

    public String getOfficialLanguages() {
        return officialLanguages;
    }

    public void setOfficialLanguages(String officialLanguages) {
        this.officialLanguages = officialLanguages;
    }

    public String getAdditionalOfficialLanguages() {
        return additionalOfficialLanguages;
    }

    public void setAdditionalOfficialLanguages(String additionalOfficialLanguages) {
        this.additionalOfficialLanguages = additionalOfficialLanguages;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }
}
