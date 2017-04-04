
package com.tmobile.retailinventoryserialization.query.device.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@PrepareForTest( { LoggerFactory.class })
public class DeviceQueryControllerTest extends BaseTest {

    /** The device query controller. */
    @InjectMocks
    private DeviceQueryController deviceQueryController;

    /** The logger. */
    private static Logger         logger;

    /** The device query service mock. */
    @Mock
    DeviceQueryService            deviceQueryServiceMock;

    /**
     * Setup.
     */
    @BeforeClass
    public static void setup() {
        mockStatic(LoggerFactory.class);
        logger = mock(Logger.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);
    }

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
