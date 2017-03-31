
package com.tmobile.test.core.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS PowerMockitoBase
 * </p>
 * 
 * @author SS00443175
 * @project ServiceDependencies
 * @updated DateTime: Mar 21, 2017 5:14:29 PM Author: SS00443175
 */
@RunWith( PowerMockRunner.class)
public class BaseTest {

    /**
     * Inits the Mock Engine.
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
