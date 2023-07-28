package com.example.ReWorld.mail;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.example.ReWorld.entities.User;


public class OnRegistrationCompleteEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appUrl;
    private Locale locale;
    private User user;
    private String[] params;
    
    public OnRegistrationCompleteEvent(
      User registered, Locale locale, String appUrl,String[] params) {
        super(registered);
        this.params = params;
        this.user = registered;
        this.locale = locale;
        this.appUrl = appUrl;
    }

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
    
    
}
