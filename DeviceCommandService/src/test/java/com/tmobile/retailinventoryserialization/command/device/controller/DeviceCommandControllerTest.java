
package com.tmobile.retailinventoryserialization.command.device.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceRequest;
import com.tmobile.retailinventoryserialization.base.domain.shared.BaseServiceResponse;
import com.tmobile.retailinventoryserialization.command.device.domain.shared.Device;
import com.tmobile.retailinventoryserialization.command.device.service.DeviceCommandService;
import com.tmobile.test.core.base.BaseTest;

/**
 * <p>
 * This is a test class to check functionality of DeviceCommandController class
 * </p>
 * .
 *
 * @author SS00443175
 * @project device-command-service
 * @updated DateTime: Mar 29, 2017 3:59:44 PM Author: SS00443175
 */

@PrepareForTest( { DeviceCommandController.class, LoggerFactory.class })
public class DeviceCommandControllerTest extends BaseTest {

    /** The base controller. */
    @InjectMocks
    private DeviceCommandController deviceCommandController;

    /** The logger. */
    private static Logger           logger;

    /** The device command service mock. */
    @Mock
    DeviceCommandService            deviceCommandServiceMock;

    /** The base service request mock. */
    @Mock
    BaseServiceRequest<Device>      baseServiceRequestMock;

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
     * Test add device.
     */
    @SuppressWarnings( { "rawtypes" })
    @Test
    public void testAddDevice() {
        Device deviceMock = mock(Device.class);
        when(baseServiceRequestMock.getRequest()).thenReturn(deviceMock);
        when(deviceCommandServiceMock.addDevice(deviceMock)).thenReturn("added sucessfully");
        BaseServiceResponse actual = deviceCommandController.addDevice(baseServiceRequestMock);
        assertEquals("added sucessfully", actual.getResult());
    }

    /**
     * Test add device if base service request is null.
     */
    @SuppressWarnings( { "rawtypes", "unchecked" })
    @Test
    public void testAddDeviceIfBaseServiceRequestIsNull() {
        BaseServiceResponse actual = deviceCommandController.addDevice((BaseServiceRequest<Device>) isNull());
        verifyZeroInteractions(baseServiceRequestMock);
        assertEquals(null, actual.getResult());
    }

    /**
     * Test get device details.
     */
    @SuppressWarnings( { "rawtypes" })
    @Test
    public void testGetDeviceDetails() {

        String expected = "TEST1234";
        Device deviceMock = mock(Device.class, RETURNS_DEEP_STUBS);

        when(deviceMock.getImei()).thenCallRealMethod();
        doCallRealMethod().when(deviceMock).setImei(any(String.class));

        deviceMock.setImei(expected);
        when(deviceCommandServiceMock.getDeviceDetails(expected)).thenReturn(deviceMock);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        BaseServiceResponse actual = deviceCommandController.getDeviceDetails(expected);
        verify(deviceCommandServiceMock).getDeviceDetails(argumentCaptor.capture());
        Device d = (Device) actual.getResult();
        assertEquals(argumentCaptor.getValue(), d.getImei());
    }
}
