
package com.tmobile.retailinventoryserialization.base.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;

/**
 * <p>
 * This is a test class to check functionality of BaseController class
 * </p>
 * .
 *
 * @author SS00443175
 * @project retail-inventory-serialization-microservices-core
 * @updated DateTime: Mar 29, 2017 1:44:57 PM Author: SS00443175
 */
@RunWith( PowerMockRunner.class)
@PrepareForTest( { BaseController.class, LoggerFactory.class })
public class BaseControllerTest {

    /** The base controller. */
    private BaseController baseController = new BaseController();

    /** The logger. */
    private static Logger  logger;

    /** The rabbit template mock. */
    @Mock
    RabbitTemplate         rabbitTemplateMock;

    /**
     * Initialized the mock objects.
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

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
     * Test convert and send.
     */
    @Test
    public void testConvertAndSend() {
        ApplicationContext applicationContextMock = mock(ApplicationContext.class);
        when(applicationContextMock.getBean(RabbitTemplate.class)).thenReturn(rabbitTemplateMock);
        doNothing().when(rabbitTemplateMock).setQueue(any(String.class));
        doNothing().when(rabbitTemplateMock).convertAndSend(any(String.class), any(Object.class));
        baseController.convertAndSend(applicationContextMock, new String(), new Object());
        verify(logger, times(0)).error(anyString());
    }

    /**
     * Test convert and send if application context is null.
     */
    @Test( expected = NullPointerException.class)
    public void testConvertAndSendIfApplicationContextIsNull() {
        baseController.convertAndSend((ApplicationContext) isNull(), new String(), new Object());
        verifyZeroInteractions(rabbitTemplateMock);
    }
}
