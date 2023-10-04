package com.example.droidfoodapp.helper;

import android.content.ClipData;
import android.content.Context;
import android.widget.Toast;

import com.example.droidfoodapp.domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }
    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listData=getListCart();
        boolean existAlready = false;
        int n=0;
        for (int i=0;i < listData.size(); i++){
            if (listData.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if (existAlready){
            listData.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listData.add(item);
        }

        tinyDB.putListObject("CardList",listData);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void  minusNumberFood(ArrayList<FoodDomain> listdata,int position, ChangeNumberItemListener changeNumberItemListener){
        if (listdata.get(position).getNumberInCart() == 1){
            listdata.remove(position);
        }else{
            listdata.get(position).setNumberInCart(listdata.get(position).getNumberInCart() -1);
        }
        tinyDB.putListObject("CardList",listdata);
        changeNumberItemListener.changed();
    }
    public void  plusNumberFood(ArrayList<FoodDomain> listdata,int position, ChangeNumberItemListener changeNumberItemListener){
        listdata.get(position).setNumberInCart(listdata.get(position).getNumberInCart() +1);
        tinyDB.putListObject("CardList",listdata);
        changeNumberItemListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> lisdata=getListCart();
        double fee =0;
        for (int i=0;i < lisdata.size();i++){
            fee = fee+(lisdata.get(i).getFee()*lisdata.get(i).getNumberInCart());
        }
        return fee;
    }
}
