package org.ismailkarakayax.service;

import org.ismailkarakayax.entity.HomeType;

import java.util.List;

public interface HomeService {

        List<HomeType> getHouseList();

        List<HomeType> getMansionList();

        List<HomeType> getVacationHomeList();

        int getTotalPriceOfHomes();

        int getTotalPriceOfMansions();

        int getTotalPriceOfVacationHomes();

        int getTotalPriceOfAllHomeTypes();

        int getTotalAreaOfHomes();

        int getTotalAreaOfMansions();

        int getTotalAreaOfVacationHomes();

        int getTotalAreaOfAllHomeTypes();

        List<HomeType> filterHomesByRoomAndLivingRoomCount(int roomCount, int livingRoomCount);

}
