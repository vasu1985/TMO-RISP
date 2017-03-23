package com.tmobile.retailinventoryserialization.base.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<O, I extends Serializable> extends CrudRepository<O, I> {

}
