
package com.tmobile.retailinventoryserialization.query.device.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.query.device.domain.shared.Label;
import com.tmobile.retailinventoryserialization.query.device.service.DeviceQueryService;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS LabelController
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:30:01 PM Author: SS00443175
 */
@CrossOrigin( "*")
@RestController
@RequestMapping( "${label.service.mapping}")
public class LabelQueryController {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(LabelQueryController.class);

    /** The device service. */
    @Autowired
    private DeviceQueryService deviceQueryService;

    /**
     * Gets the label details.
     *
     * @param imei
     *            the imei
     * @return the device details
     */
    @RequestMapping( value = "${retailInventoryQueryService.labelDetails.mapping}", method = RequestMethod.GET)
    public BaseServiceResponse<Label> getLabelDetails( @PathVariable String imei) {
//        return deviceQueryService.getDeviceDetails(imei);
    	return null;
    }
}
