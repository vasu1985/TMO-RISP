
package com.tmobile.error.base.repository;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmobile.error.base.domain.shared.ErrorMessage;

/**
 * <p>
 * This class represents the repository class defining methods to interact with database.
 * </p>
 * .
 *
 * @author vm00436370
 * @project ErrorCore
 * @updated DateTime: Mar 22, 2017 8:20:13 PM Author: vm00436370
 */
@Region( "errorRegion")
@Repository
public interface ErrorMessageRepository extends CrudRepository<ErrorMessage, String> {

    /**
     * Find by error code.
     *
     * @param errorCode
     *            the error code
     * @return the error message
     */
    ErrorMessage findByErrorCode( int errorCode);

    /**
     * Find by error message.
     *
     * @param errorMessage
     *            the error message
     * @return the iterable< error message>
     */
    Iterable<ErrorMessage> findByErrorMessage( String errorMessage);

}