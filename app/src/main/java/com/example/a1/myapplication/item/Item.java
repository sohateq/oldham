package com.example.a1.myapplication.item;

import android.content.Context;

import com.example.a1.myapplication.R;

/**
 * Created by kamek on 09.07.2018.
 */

public class Item {

    private String name = "test";
    private int number;
    Context context;
    private int picId;

//    private String description;
//    private int picId;
//
////    static final Item[] items = {
////
////            new Item("","v",2);
////    }
//
//    public Item(String name, String description, int picId){
//        this.name = name;
//        this.description = description;
//        this.picId = picId;
//    }


    public String getName(){
        String[] array = context.getResources().getStringArray(R.array.allItems);

        return array[number];
    }

    public int getPicId() {
        picId = context.getResources().getIdentifier("pic"+Integer.toString(number),"drawable", context.getPackageName());
        //picId = context.getResources().getIdentifier("ic_pic0","drawable", context.getPackageName());
        return picId;
    }
    //    public Item(String name) {
//        this.name = name;
//    }


    public String getDescription() {
        try {
            String[] array = context.getResources().getStringArray(R.array.allDescriptions);
            return array[number];
        } catch (Exception e){
            return "";
        }
    }

    public Item(int number, Context context) {
        this.number = number;
        this.context = context;
    }
}
