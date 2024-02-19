package org.ismailkarakayax.entity;

public abstract class HomeType {

    private int area;
    private int roomCount;
    private int livingRoomCount;
    private int price;

    public HomeType(int area, int roomCount,int livingRoomCount, int price) {
        this.area = area;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "HomeType{" +
                "area=" + area +
                ", roomCount=" + roomCount +
                ", livingRoomCount=" + livingRoomCount +
                ", price=" + price +
                '}';
    }
}
