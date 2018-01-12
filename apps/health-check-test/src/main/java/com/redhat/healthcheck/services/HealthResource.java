package com.redhat.healthcheck.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.healthcheck.HealthCheckDelegate;
import com.redhat.healthcheck.models.Health;

@RestController
@RequestMapping(path = "/health")
public class HealthResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HealthResource.class);
	private static final String LIVENESS_MESSAGE = "Executing liveness check ";
	private static final String READINESS_MESSAGE = "Executing readiness check ";

	@Autowired
	private Health health;

	@Autowired
	private HealthCheckDelegate healthCheckDelegate;

	public HealthResource() {
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ready")
	public Health ready() {
		healthCheckDelegate.checkMaxReadyRequests();
		LOGGER.info(READINESS_MESSAGE + healthCheckDelegate.getReadyRequests() + " requests");
		return health;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/live")
	public Health live() {
		healthCheckDelegate.checkMaxLiveRequests();
		LOGGER.info(LIVENESS_MESSAGE + healthCheckDelegate.getLiveRequests() + " requests");
		return health;
	}

}
