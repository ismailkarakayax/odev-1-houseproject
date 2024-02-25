package org.ismailkarakayax;

import org.ismailkarakayax.entity.HomeType;
import org.ismailkarakayax.entity.House;
import org.ismailkarakayax.entity.Mansion;
import org.ismailkarakayax.entity.VacationHouse;
import org.ismailkarakayax.service.HomeService;
import org.ismailkarakayax.service.HomeServiceImpl;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Creating instances of different home types
        House house1 = new House(120, 3, 2, 150000);
        House house2 = new House(100, 2, 1, 120000);
        House house3 = new House(150, 4, 3, 200000);
        Mansion mansion1 = new Mansion(300, 5, 3, 500000);
        Mansion mansion2 = new Mansion(250, 4, 2, 400000);
        Mansion mansion3 = new Mansion(400, 6, 4, 600000);
        VacationHouse vacationHouse1 = new VacationHouse(80, 2, 1, 80000);
        VacationHouse vacationHouse2 = new VacationHouse(120, 3, 2, 120000);
        VacationHouse vacationHouse3 = new VacationHouse(180, 4, 3, 180000);

        // Creating a list of home types
        List<HomeType> homeList = new ArrayList<>();
        homeList.add(house1);
        homeList.add(house2);
        homeList.add(house3);
        homeList.add(mansion1);
        homeList.add(mansion2);
        homeList.add(mansion3);
        homeList.add(vacationHouse1);
        homeList.add(vacationHouse2);
        homeList.add(vacationHouse3);

        // Creating a HomeService instance with the list of home types
        HomeService homeService = new HomeServiceImpl(homeList);

        printTotalPrices(homeService);
        printTotalAreas(homeService);
        printFilteredHomes(homeService, 3, 2);
    }

    private static void printTotalPrices(HomeService homeService) {
        System.out.println("Total price of homes: " + homeService.getTotalPriceOfHomes());
        System.out.println("Total price of mansions: " + homeService.getTotalPriceOfMansions());
        System.out.println("Total price of vacation homes: " + homeService.getTotalPriceOfVacationHomes());
        System.out.println("Total price of all home types: " + homeService.getTotalPriceOfAllHomeTypes());
    }

    private static void printTotalAreas(HomeService homeService) {
        System.out.println("Total area of homes: " + homeService.getTotalAreaOfHomes());
        System.out.println("Total area of mansions: " + homeService.getTotalAreaOfMansions());
        System.out.println("Total area of vacation homes: " + homeService.getTotalAreaOfVacationHomes());
    }

    private static void printFilteredHomes(HomeService homeService, int roomCount, int livingRoomCount) {
        List<HomeType> filteredHomes = homeService.filterHomesByRoomAndLivingRoomCount(roomCount, livingRoomCount);
        System.out.println("Homes with " + roomCount + " rooms and " + livingRoomCount + " living rooms:");
        filteredHomes.forEach(homeType -> System.out.println(homeType.toString()));
    }

}