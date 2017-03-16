
package com.tmobile.retailinventorycommandservice.repository;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;

import com.tmobile.retailinventorycommandservice.domain.Transaction;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS DeviceRepository
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:28:54 PM Author: SS00443175
 */
@Region("transactions")
public interface TransactionsCommandRepository extends CrudRepository<Transaction, String> {
/*TODO*/
}
