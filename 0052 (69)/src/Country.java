/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saras
 */
public class Country extends EastAsiaCountries {

    private String countryTerrain;

    public Country() {
    }

    public Country(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public Country(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-25s\n", countryTerrain);
    }

}
