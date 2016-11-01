package com.tenx.ms.retail.service;

import com.tenx.ms.retail.domain.Store;
import com.tenx.ms.retail.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public Iterable<Store> listAllStores(){
        return storeRepository.findAll();
    }

    public Store findByID(Long store_id){
        return storeRepository.findOne(store_id);

    }

    public Store findByName(String name){
        List<Store> stores = storeRepository.findByName(name);
        return (stores.size() == 0)? null:stores.get(0);

    }

    public Store save(Store store){
        return  storeRepository.save(store);
    }

    public void delete(Long store_id){
        storeRepository.delete(store_id);
    }
}
