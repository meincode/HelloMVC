package com.example.hellomvc.model;

import java.util.ArrayList; 
import java.util.List; 
import java.util.Observable; 

public class Model extends Observable{ 
    private List<Integer> mList; 
         
    public Model(){ 
        mList = new ArrayList<Integer>(2); 
        mList.add(0); 
        mList.add(0); 
    }   
         
    public int getDataAtIndex(int index) throws IndexOutOfBoundsException{ 
        return mList.get(index); 
    }   
         
    public void setDataAtIndex(int index) throws IndexOutOfBoundsException{ 
        mList.set(index, mList.get(index) + 1); 
        setChanged(); 
        notifyObservers(); 
    }   
}
