package com.redhat.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class HealthCheckDelegate {

	private static final String MAX_LIVE_REQUESTS_REACHED = "Reached maximum number of live requests";
	private static final String MAX_READY_REQUESTS_REACHED = "Reached maximum number of ready requests";
	private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckDelegate.class);

	private int liveRequests = 0;
	private int readyRequests = 0;

	@Value("${max.live.requests ?: 3}")
	private int maxLiveRequests;

	@Value("${max.ready.requests ?: 3}")
	private int maxReadyRequests;

	public HealthCheckDelegate() {

	}

	public void checkMaxLiveRequests() {
		liveRequests++;
		int total = liveRequests / maxLiveRequests;
		if (total == 1) {
			LOGGER.error(MAX_LIVE_REQUESTS_REACHED);
			throw new RuntimeException(MAX_LIVE_REQUESTS_REACHED);
		}
	}

	public void checkMaxReadyRequests() {
		readyRequests++;
		int total = readyRequests / maxReadyRequests;
		if (total == 1) {
			LOGGER.error(MAX_READY_REQUESTS_REACHED);
			throw new RuntimeException(MAX_READY_REQUESTS_REACHED);
		}
	}

	public int getLiveRequests() {
		return liveRequests;
	}

	public int getReadyRequests() {
		return readyRequests;
	}

}
