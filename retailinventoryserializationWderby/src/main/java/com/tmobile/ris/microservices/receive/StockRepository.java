package com.tmobile.ris.microservices.receive;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {

}
