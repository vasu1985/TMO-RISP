
package com.tmobile.test.core.base;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * This is a base class for all the test classes. It contains the basic declarations which can be extended by any sub class.
 * </p>
 * 
 * @author SS00443175
 * @project MagentaTestCore
 * @updated DateTime: Mar 21, 2017 5:14:29 PM Author: SS00443175
 */
@RunWith( PowerMockRunner.class)
@PrepareForTest( { LoggerFactory.class })
public class BaseTest {

    /** The logger. */
    protected static Logger logger;

    /**
     * Inits the Mock Engine.
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
     * Setup any list type answer.
     *
     * @param <T>
     *            the generic type
     * @param values
     *            the up any list type answer
     * @return the answer< list< t>>
     */
    protected <T extends Object> Answer<List<T>> setupAnyListTypeAnswer( T ... values) {
        final List<T> someList = new ArrayList<T>();
        someList.addAll(Arrays.asList(values));
        Answer<List<T>> answer = new Answer<List<T>>() {

            public List<T> answer( InvocationOnMock invocation) throws Throwable {
                return someList;
            }
        };
        return answer;
    }
}
