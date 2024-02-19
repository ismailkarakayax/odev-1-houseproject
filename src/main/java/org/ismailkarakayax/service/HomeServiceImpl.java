package org.ismailkarakayax.service;



import org.ismailkarakayax.entity.HomeType;
import org.ismailkarakayax.entity.House;
import org.ismailkarakayax.entity.Mansion;
import org.ismailkarakayax.entity.VacationHouse;

import java.util.List;
import java.util.stream.Collectors;

public class HomeServiceImpl implements HomeService {

    private List<HomeType> homeList;


    public HomeServiceImpl(List<HomeType> homeList) {
        this.homeList = homeList;
    }

    @Override
    public List<HomeType> getHouseList() {
        return homeList.stream().filter(homeType -> homeType instanceof House).collect(Collectors.toList());
    }

    @Override
    public List<HomeType> getMansionList() {
        return homeList.stream().filter(homeType -> homeType instanceof Mansion).collect(Collectors.toList());
    }

    @Override
    public List<HomeType> getVacationHomeList() {
        return homeList.stream().filter(homeType -> homeType instanceof VacationHouse).collect(Collectors.toList());
    }



    //Returns the total price of homes
    @Override
    public int getTotalPriceOfHomes() {
        return getHouseList().stream().mapToInt(HomeType::getPrice).sum();
    }
    //Returns the total price of mansions
    @Override
    public int getTotalPriceOfMansions() {
        return getMansionList().stream().mapToInt(HomeType::getPrice).sum();
    }
    //Returns the total price of vacation homes
    @Override
    public int getTotalPriceOfVacationHomes() {
        return getVacationHomeList().stream().mapToInt(HomeType::getPrice).sum();
    }
    //Returns the total price of all home types
    @Override
    public int getTotalPriceOfAllHomeTypes() {
        return homeList.stream().mapToInt(HomeType::getPrice).sum();
    }

    //Returns the total area of homes
    @Override
    public int getTotalAreaOfHomes() {
        return getHouseList().stream().mapToInt(HomeType::getArea).sum();
    }

    //Returns the total area of mansions
    @Override
    public int getTotalAreaOfMansions() {
        return getMansionList().stream().mapToInt(HomeType::getArea).sum();
    }

    //Returns the total area of vacation homes
    @Override
    public int getTotalAreaOfVacationHomes() {
        return getVacationHomeList().stream().mapToInt(HomeType::getArea).sum();
    }

    //Returns the total area of all home types
    @Override
    public int getTotalAreaOfAllHomeTypes() {
        return homeList.stream().mapToInt(HomeType::getArea).sum();
    }

    //Returns a list of homes that match the given room count
    @Override
    public List<HomeType> filterHomesByRoomAndLivingRoomCount(int roomCount, int livingRoomCount) {
        return homeList.stream()
                .filter(homeType -> homeType.getRoomCount() == roomCount && homeType.getLivingRoomCount() == livingRoomCount)
                .collect(Collectors.toList());
    }

}
