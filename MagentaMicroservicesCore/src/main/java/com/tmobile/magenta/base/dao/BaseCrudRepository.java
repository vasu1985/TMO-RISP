package com.tmobile.magenta.base.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface BaseCrudRepository<O, I extends Serializable> extends CrudRepository<O, I> {

}
