package com.example.amazonclone.Service;

import com.example.amazonclone.modelLayer.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@RequiredArgsConstructor
@Service
public class MerchantStockService {
    private final ProductService productService;
    private final MerchantService merchantService;
    ArrayList<MerchantStock> merchantStocks =new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }
    //هنا راح اعدل في اخطاء بسيطه
    public boolean  addMerchantStock(MerchantStock merchantStock) {
        for (int i = 0; i <productService.products.size() ; i++) {
                if (productService.products.get(i).getId().equals(merchantStock.getMerchantID())) {
                    merchantStocks.add(merchantStock);
                    return true;
                }
            for (int j = 0; j <merchantService.merchants.size(); j++) {
                if (merchantService.merchants.get(j).getId().equals(merchantStock.getMerchantID())) {
                    return true;
                }

            }
            }
return false;
        }

    public boolean updateMerchantStock(MerchantStock merchantStock){
        for (int i = 0; i <productService.products.size() ; i++) {
            if (productService.products.get(i).getId().equals(merchantStock.getMerchantID())) {
                merchantStocks.add(merchantStock);
                return true;
            }
            for (int j = 0; j <merchantService.merchants.size(); j++) {
                if (merchantService.merchants.get(j).getId().equals(merchantStock.getMerchantID())) {
                    return true;
                }

            }
        }
        return false;
    }
    public boolean deleteMerchantStock(String id){
        for (MerchantStock m:merchantStocks
             ) {
            if (m.getId().equals(id)) {
                merchantStocks.remove(id);
                return true;
            }
        }
        return false;

    }
}

