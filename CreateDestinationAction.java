package com.internousdev.i1810c.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810c.dao.MCategoryDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private List<String> sexList = new ArrayList<String>();

	public String execute() {
		String result = LOGIN;
		if (!(session.containsKey("mCategoryDtoList"))) {
			session.put("mCategoryDtoList", (new MCategoryDAO()).getMCategoryList());
		}
		if(session.containsKey("logined")){
			result = ERROR;
			sexList.add(MALE);
			sexList.add(FEMALE);
			session.remove("familyNameErrorMessageList");
			session.remove("firstNameErrorMessageList");
			session.remove("familyNameKanaErrorMessageList");
			session.remove("firstNameKanaErrorMessageList");
			session.remove("emailErrorMessageList");
			session.remove("telNumberErrorMessageList");
			session.remove("userAddressErrorMessageList");
			result = SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession() {
	    return session;
	}

	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}

	public String getDefaultSexValue() {
	    return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
	    this.defaultSexValue = defaultSexValue;
	}

	public List<String> getSexList() {
	    return sexList;
	}

	public void setSexList(List<String> sexList) {
	    this.sexList = sexList;
	}
}
