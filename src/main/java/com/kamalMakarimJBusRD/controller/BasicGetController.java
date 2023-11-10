package com.kamalMakarimJBusRD.controller;


import com.kamalMakarimJBusRD.Algorithm;
import com.kamalMakarimJBusRD.Predicate;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import com.kamalMakarimJBusRD.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface BasicGetController<T extends Serializable> {
    public abstract <T extends Serializable> JsonTable<T> getJsonTable();
    @GetMapping("/page")
    public default <T extends Serializable> List<T> getPage(int page, int pageSize){
        return Algorithm.paginate(getJsonTable(), page, pageSize, t -> true);
    }

    @GetMapping("/{id}")
    public default <T extends Serializable> T getById(int id){
        Predicate<T> pred = t -> t.id == id;
        return Algorithm.find(getJsonTable(), pred);
    }
}