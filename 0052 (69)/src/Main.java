
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saras
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Nice", "IDN", "Indonesia", 1860360));
        countryList.add(new Country("Nice", "USA", "United States", 331698));
        countryList.add(new Country("Nice", "VN", "Viet Nam", 331698));

        while (true) {
            //Display menu
            Display.displayMenu();
            //Ask user choice
            int choice = GetData.inputInteger("\u001B[0m" + "Enter your choice : ", 1, 5);
            //Do function base on user choice
            switch (choice) {
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(countryList);
                    break;
                case 2:
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(countryList);
                    break;
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(countryList);
                    break;
                case 4:
                    ManageEastAsiaCountries.sortInformationByAscendingOrder(countryList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
