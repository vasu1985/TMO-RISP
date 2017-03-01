package com.tmobile.returns.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tmobile.returns.repository.UserRepository;
import com.tmobile.returns.utils.Constants;

/**
 * The Class ReturnService.
 */
@Service
public class ReturnsService {
	@Autowired
	private UserRepository userRepository;

	private static Logger log = LoggerFactory.getLogger(ReturnsService.class);

	public static final String GET_SCAN_IMEI_DETAILS = "getScanIMEIDetails";

	public static final String GET_LABEL_DETAILS = "getLabelDetails";

	public static final String GET_USER_AUTHENTICATION = "authenticateUser";

	public static final String GET_CONFIRM_STATUS = "confirmStatus";

	@Value("${returnService.scanIMEI.sampleJson}")
	private String SampleJson_1;

	@Value("${returnService.labelDetails.sampleJson}")
	private String SampleJson_2;

	@Value("${returnService.authenticateUser.sampleJson}")
	private String SampleJson_3;

	@Value("${returnService.confirm.sampleJson}")
	private String SampleJson_4;

	@Value("${returnService.authenticateUser1.sampleJson}")
	private String SampleJson_5;

	@Value("${returnService.authenticateUser2.sampleJson}")
	private String SampleJson_6;

	public String getScanIMEIDetails() {
		log.info(GET_LABEL_DETAILS + Constants.LOG_INFO_VALUE);
		return SampleJson_1;
	}

	public String getLabelDetails() {
		log.info(GET_SCAN_IMEI_DETAILS + Constants.LOG_INFO_VALUE);
		return SampleJson_2;
	}

	public String getConfirmation() {
		log.info(GET_CONFIRM_STATUS + Constants.LOG_INFO_VALUE);
		return SampleJson_4;
	}
}
