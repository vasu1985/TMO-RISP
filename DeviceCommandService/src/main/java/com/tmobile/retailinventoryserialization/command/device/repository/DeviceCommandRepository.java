
package com.tmobile.retailinventoryserialization.command.device.repository;

import org.springframework.data.gemfire.mapping.Region;

import com.tmobile.magenta.base.dao.BaseCrudRepository;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;

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
@Region( "devices")
public interface DeviceCommandRepository extends BaseCrudRepository<Device, String> {
    /* TODO */
}
