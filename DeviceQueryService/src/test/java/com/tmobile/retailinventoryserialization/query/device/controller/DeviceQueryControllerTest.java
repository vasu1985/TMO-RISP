
package com.tmobile.retailinventoryserialization.query.device.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;

import com.tmobile.magenta.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.query.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.query.device.service.DeviceQueryService;
import com.tmobile.test.core.base.BaseTest;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS DeviceQueryControllerTest
 * </p>
 * .
 *
 * @author SS00443175
 * @project device-query-service
 * @updated DateTime: Apr 4, 2017 5:14:38 PM Author: SS00443175
 */
public class DeviceQueryControllerTest extends BaseTest {

    /** The device query controller. */
    @InjectMocks
    private DeviceQueryController deviceQueryController;

    /** The device query service mock. */
    @Mock
    DeviceQueryService            deviceQueryServiceMock;

    /**
     * Test get devices.
     */
    @SuppressWarnings( { "rawtypes", "unchecked" })
    @Test
    public void testGetDevices() {
        Answer<List<Device>> answer = setupAnyListTypeAnswer(new Device(), new Device());
        when(deviceQueryServiceMock.getDevices()).thenAnswer(answer);

        BaseServiceResponse actual = deviceQueryController.getDevices();
        verify(deviceQueryServiceMock, times(1)).getDevices();
        int actualSize = ((List<Device>) actual.getResult()).size();
        assertEquals(2, actualSize);
    }
}
