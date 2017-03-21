
package com.tmobile.retailinventoryserialization.query.device.repository;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;

import com.tmobile.retailinventoryserialization.query.device.domain.shared.Device;

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
@Region("queryDevice")
public interface DeviceQueryRepository extends CrudRepository<Device, String> {
/*TODO*/
	Device findBymImei(String mImei);
}
