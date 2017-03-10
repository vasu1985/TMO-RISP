
package com.tmobile.retailinventorycommandservice.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;

import com.tmobile.retailinventorycommandservice.domain.UserInfo;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS UserRepository
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:29:00 PM Author: SS00443175
 */
@Region("devices")
public interface UserCommandRepository extends CrudRepository<UserInfo, String> {
    /*TODO*/
}
