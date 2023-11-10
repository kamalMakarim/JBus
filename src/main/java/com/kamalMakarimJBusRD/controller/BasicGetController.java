package com.kamalMakarimJBusRD.controller;


import com.kamalMakarimJBusRD.Algorithm;
import com.kamalMakarimJBusRD.dbjson.JsonTable;
import com.kamalMakarimJBusRD.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * This interface is used to get the data from the json file
 * @param <T> The type of the data
 */
public interface BasicGetController<T extends Serializable> {
    JsonTable<T> getJsonTable();
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam (value = "page") int page,
            @RequestParam (value =  "size") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, t -> true);
    }

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }
}