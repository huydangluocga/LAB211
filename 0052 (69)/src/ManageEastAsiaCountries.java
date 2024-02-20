
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saras
 */
public class ManageEastAsiaCountries {

    public static void addCountryInformation(ArrayList<Country> countryList) {
        //Check if user was input 11 countries
        if (countryList.size() >= 11) {
            System.out.println("You was add 11 countries before!");
            return;
        }

        String countryCode;
        String countryName;
        while (true) {
            countryCode = GetData.inputString("\u001B[0m" + "Enter code of country: " + "\u001B[32m");
            //Check if country was existed 
            if (checkCountryExist(countryList, countryCode)) {
                System.out.println("\u001B[0m" + "Country code was existed! Try another!");
                continue;
            }
            countryName = GetData.inputString("\u001B[0m" + "Enter name of country: " + "\u001B[32m");
            if (checkCountry2Exist(countryList, countryName)) {
                System.out.println("\u001B[0m" + "Country name was existed! Try another!");
                continue;
            }
            break;
        }

        float totalArea = GetData.inputFloat("\u001B[0m" + "Enter total area: " + "\u001B[32m");
        String terrain = GetData.inputString("\u001B[0m" + "Enter terrain of country: " + "\u001B[32m");
        countryList.add(new Country(terrain, countryCode, countryName, totalArea));
        System.out.println("Success!");

    }

    public static boolean checkCountryExist(ArrayList<Country> countryList, String countryCode) {
        //Loop to access full element of country list
        for (Country o : countryList) {
            //Compare countryCode user input with countryCode existed in list
            if (o.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkCountry2Exist(ArrayList<Country> countryList, String countryName) {
        //Loop to access full element of country list
        for (Country o : countryList) {
            //Compare countryCode user input with countryCode existed in list
            if (o.getCountryName().equalsIgnoreCase(countryName)) {
                return true;
            }
        }
        return false;
    }

    public static void getRecentlyEnteredInformation(ArrayList<Country> countryList) {   
        

        int lastIndex = countryList.size() - 1;
        EastAsiaCountries country = countryList.get(lastIndex);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        country.display();

    }

    public static void searchInformationByName(ArrayList<Country> countryList) {
        if (countryList.isEmpty()) {
            System.out.println("No data to search! Add more to continue!");
            return;
        }
        String nameSearch = GetData.inputString("Enter name you want to search for:" + "\u001B[32m");
        boolean founded = false;
        //Loop to access full element of country in list 
        for (Country o : countryList) {
            //Compare name user input with name existed in country list
            if (o.getCountryName().toUpperCase().contains(nameSearch.toUpperCase())) {
                System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
                o.display();
                founded = true;
            } 
        }
        //Check if can't found anything
        if (!founded) {
            System.out.println("Can't find country!");
        }
    }

    public static void sortInformationByAscendingOrder(ArrayList<Country> countryList) {      
        ArrayList<Country> sortList = new ArrayList<>();
        sortList.addAll(countryList);
        Collections.sort(sortList, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                //Sort information by increasing with country name
                if (o1.getCountryName().compareTo(o2.getCountryName()) > 0) {
                    return 1;
                } else if (o1.getCountryName().compareTo(o2.getCountryName()) < 0) {
                    return -1;
                } else {
                    return 0;
                } 
            }
        });
        System.out.println("After sort by country name increasing: ");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        //Loop to access full element of country in list
        for (Country o : sortList) {
            o.display();
        }
    }

}
