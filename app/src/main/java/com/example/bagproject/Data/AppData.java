package com.example.bagproject.Data;

import android.app.Application;
import android.content.Context;

import com.example.bagproject.Constants.MyConstants;
import com.example.bagproject.Database.RoomDB;
import com.example.bagproject.Models.Items;
import com.example.bagproject.Dao.ItemsDao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {
    RoomDB database;
    String category;
    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 3;

/*    public AppData(RoomDB database) {
        this.database = database;
    }*/

    public AppData(RoomDB database) {
        this.database = database;
        this.context = context;
    }




    public List <Items> getBasicData(){
        category = "Basic Needs";
        List <Items> basicItem = new ArrayList<Items>();
        basicItem.clear();
        basicItem.add(new Items("Visa", category, false));
        basicItem.add(new Items("Passport", category, false));
        basicItem.add(new Items("Tickets", category, false));
        basicItem.add(new Items("Wallet", category, false));
        basicItem.add(new Items("Driving License", category, false));
        basicItem.add(new Items("Currency", category, false));
        basicItem.add(new Items("House Key", category, false));
        basicItem.add(new Items("Book", category, false));
        basicItem.add(new Items("Travel Pillow", category, false));
        basicItem.add(new Items("Eye Patch", category, false));
        basicItem.add(new Items("Umbrella", category, false));
        basicItem.add(new Items("NoteBook", category, false));

        return basicItem;
    }

    public List <Items> getPersonalCareData(){
        String [] data = {"Tooth-brush", "Tooth-Paste", "Floss", "Mouth-wash", "Shaving Cream" ,"Razor Blade",
        "Soap", "Fiber", "Shampoo", "Hair Conditioner"

        };

        return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE, data);
    }


    public List <Items> getClothingData () {
        String [] data = {"Stockings", "Underwear", "Pajamas", "T-Shirts", "Casual Dress", "Evening Dress",
                "Shirt", "Vest", "Shkirt", "Trousers", "Jeans", "Shorts"

        };

        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE, data);
    }

    public List <Items> getBabyNeedsData(){
        String [] data = {"SnapSuit", "Outfit", "JumpSuit", "Baby Socks", "Baby Hat", "Baby Pyjamas", "Baby Bath Towel",

        };
        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE, data);
    }


    public List <Items> getHealthData(){
        String [] data = {"Aspirin", "Vitamins", "Fever Reducer"};
        return  prepareItemsList(MyConstants.HEALTH_CAMEL_CASE, data);
    }

    public List <Items> getTechnologyData() {
        String [] data = {"Mobile Phone", "Phone Cover", "E-book reader", "Camera Charger", "Phone-Charger", "Headphones"};
        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE, data);
    }

    public List <Items> getFoodData(){
        String [] data = {"Snack", "Sandwich", "Juice", "Coffee", "Water", "Termos", "Baby Food"};
        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE, data);
    }

    public List <Items> getBeachSuppliesData(){
        String [] data ={"Sea Glasses", "Sea Bed", "Beach Umbrella", "Beach Bag", "Beach Towel", "Beach Slippers"};
        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE, data);
    }

    public List <Items> getCarSuppliesData(){
        String [] data = {"Pump", "Car Jack", "sparke Car Key", "Car Charger"};
        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE, data);
    }


    public List <Items> getNeedsData() {
        String [] data = {"Backpack", "Daily Bags", "Laundry Bag", "Travel Lock"};
        return prepareItemsList(MyConstants.NEEDS_CAMEL_CASE, data);
    }



    public List <Items> prepareItemsList(String category, String [] data) {
        List<String> list = Arrays.asList(data);
        List<Items> dataList = new ArrayList<>();

        dataList.clear();

        for (int i = 0; i < list.size(); i++) {
            dataList.add(new Items(list.get(i), category, false));
        }
        return dataList;
    }

    public List < List <Items>> getAllData(){
        List < List < Items>> listOfAllItems = new ArrayList<>();
        listOfAllItems.clear();
        listOfAllItems.add(getBasicData());
        listOfAllItems.add(getClothingData());
        listOfAllItems.add(getPersonalCareData());
        listOfAllItems.add(getBabyNeedsData());
        listOfAllItems.add(getHealthData());
        listOfAllItems.add(getTechnologyData());
        listOfAllItems.add(getFoodData());
        listOfAllItems.add(getBeachSuppliesData());
        listOfAllItems.add(getCarSuppliesData());
        listOfAllItems.add(getNeedsData());

        return listOfAllItems;
    }

    public void persistAllData() {


        List <List <Items>> listOfAllItems = getAllData();

        for(List <Items> list : listOfAllItems){
            for(Items items : list){
                database.itemsDao().saveItem(items);
            }
            System.out.println("Data added");
        }
    }
}
