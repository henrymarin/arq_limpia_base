package com.xxxxxxxxx.zzzzzzzzz.technical.excel;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class ExcelModel {

	
	private String id;
	private String name;
	private String timestamp;
	private String application;
	private String service;
	private String message;
	private String stacktrace;

    public ExcelModel(String message, String application, String service, String name) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.application = application;
        this.service = service;
        this.name = name;
    }

    public ExcelModel(String application, String service, String name, Exception ex) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().toString();
        this.message = ex.getMessage();
        this.application = application;
        this.service = service;
        this.stacktrace = Arrays.toString(ex.getStackTrace());
        this.name = name;
    }
    
	public void setService(String service) {
		this.service = service;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	
	public String getId() {
		return id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public String getName() {
		return name;
	}

	public String getTimestamp() {
		return timestamp;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getService() {
		return service;
	}



	public String getMessage() {
		return message;
	}


    
    
}
