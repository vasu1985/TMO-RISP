
package com.tmobile.retailinventoryserialization.query.device.repository;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;

import com.tmobile.retailinventoryserialization.query.device.domain.UserInfo;

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
@Region("queryDevice")
public interface UserQueryRepository extends CrudRepository<UserInfo, String> {
    /*TODO*/
}
