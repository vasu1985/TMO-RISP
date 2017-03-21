
package com.tmobile.retailinventoryserialization.command.device.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.retailinventoryserialization.command.device.domain.shared.Transaction;
import com.tmobile.retailinventoryserialization.command.device.repository.TransactionsCommandRepository;

/**
 * <p>
 * MISSING COMMENTS FOR CLASS DeviceService
 * </p>
 * .
 *
 * @author SS00443175
 * @project RetailInventoryService
 * @updated DateTime: Mar 9, 2017 2:29:15 PM Author: SS00443175
 */
@Service
public class TransactionsCommandService {

    /** The log. */
    private static Logger                 log = LoggerFactory.getLogger(TransactionsCommandService.class);

    /** The device repository. */
    @Autowired
    private TransactionsCommandRepository transactionCommandRepository;

    /**
     * Adds the device.
     *
     * @param Transaction
     *            the Transaction
     * @return the string
     */
    public String addTransaction( Transaction transaction) {
        transactionCommandRepository.save(transaction);
        log.info("addDevice IMEI->" + transaction.getmImei());
        return "IMEI->" + transaction.getmImei() + " added sucessfully";
    }

    // TODO addDevices()

    /**
     * Delete Transaction
     *
     * @param imei
     *            the imei
     * @return the string
     */
    public String deleteTransaction( String imei) {
        transactionCommandRepository.delete(imei);
        log.info("deleteDevice IMEI->" + imei);
        return "device with imei-> " + imei + "deleted successfully";
    }

    public Transaction getTransactionDetails( String imei) {
        return transactionCommandRepository.findOne(imei);
    }

    /**
     * Update Transaction.
     *
     * @param imei
     *            the imei
     * @param updatedTransaction
     *            the updated Transaction
     * @return the string
     */
    public String updateTransaction( Transaction transaction) {
        transactionCommandRepository.save(transaction);
        log.info("updatedDevice IMEI->" + transaction.getmImei());
        return transaction.getmImei() + " updated sucessfully";

    }

}
