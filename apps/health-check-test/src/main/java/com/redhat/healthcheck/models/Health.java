package com.redhat.healthcheck.models;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Health implements Serializable {

	private static final long serialVersionUID = 1L;

	@Value("${app.version}")
	private String appVersion;

	public Health() {

	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

}
