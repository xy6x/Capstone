package com.example.amazonclone.Service;

import com.example.amazonclone.modelLayer.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants =new ArrayList<>();
    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }
    public void  addMerchants(Merchant merchant){
        merchants.add(merchant);
    }
    public boolean updateMerchants(String id , Merchant merchant){
        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchants.set(i,merchant);
                return true;
            }

        }
        return  false;
    }
    public  boolean deleteMerchants(String id){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchants.remove(i);
                return true;

            }

        }
        return false;
    }
}
