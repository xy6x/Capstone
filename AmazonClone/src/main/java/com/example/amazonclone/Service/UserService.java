package com.example.amazonclone.Service;

import com.example.amazonclone.modelLayer.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CategoryService categoryService;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public boolean updateUser(String id, User user) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }

        return false;
    }

    public boolean deleteUser(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                users.remove(u);
                return true;

            }
        }
        return false;
    }
    public boolean check(String merchid, String idProduct){
        for (int i = 0; i <merchantStockService.merchantStocks.size() ; i++) {
            if (merchantStockService.merchantStocks.get(i).getMerchantID().equals(merchid)&&
                    merchantStockService.merchantStocks.get(i).getProductID().equals(idProduct)&&
                    merchantStockService.merchantStocks.get(i).getStock()>0) {
                return true;
            }


        }
        return false;
    }
public void addStock(String idUser,String idStock ,int sto){
    for (int j = 0; j <users.size() ; j++) {
        if (users.get(j).getId().equals(idUser)&&users.get(j).getRole().equals("Admin")) {

    for (int i = 0; i <merchantStockService.merchantStocks.size() ; i++) {
        if (merchantStockService.merchantStocks.get(i).getId().equals(idStock)) {
            int stock = merchantStockService.merchantStocks.get(i).getStock();
            merchantStockService.merchantStocks.get(i).setStock(stock + sto);
        }
    }
        }
    }
}
    public boolean buying(String merchid, String idProduct) {


        for (int j = 0; j < merchantStockService.merchantStocks.size(); j++) {
            if (merchantStockService.merchantStocks.get(j).getMerchantID().equals(merchid) &&
                    merchantStockService.merchantStocks.get(j).getProductID().equals(idProduct)) {
                if (merchantStockService.merchantStocks.get(j).getStock() > 0) {
                    merchantStockService.merchantStocks.get(j).setStock(merchantStockService.merchantStocks.get(j).getStock() - 1);


                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getBalance() >= productService.products.get(i).getPrice()) {

                            double num = productService.products.get(i).getPrice() - users.get(i).getBalance();
                            users.get(i).setBalance(num);
                            return true;
                        }
                    }
                }


            }
        }
        return false;
    }
}