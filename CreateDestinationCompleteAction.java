package com.internousdev.i1810c.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810c.dao.DestinationInfoDAO;
import com.internousdev.i1810c.dao.MCategoryDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		String result = LOGIN;
		if (!(session.containsKey("mCategoryDtoList"))) {
			session.put("mCategoryDtoList", (new MCategoryDAO()).getMCategoryList());
		}
		if (session.containsKey("logined")) {
			result = ERROR;
			DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
			int count = destinationInfoDao.insert(String.valueOf(session.get("loginId")),
					String.valueOf(session.get("familyName")), String.valueOf(session.get("firstName")),
					String.valueOf(session.get("familyNameKana")), String.valueOf(session.get("firstNameKana")),
					String.valueOf(session.get("email")), String.valueOf(session.get("telNumber")),
					String.valueOf(session.get("userAddress")));
			if (count > 0) {
				result = SUCCESS;
			}
			session.remove("familyNameErrorMessageList");
			session.remove("firstNameErrorMessageList");
			session.remove("familyNameKanaErrorMessageList");
			session.remove("firstNameKanaErrorMessageList");
			session.remove("emailErrorMessageList");
			session.remove("telNumberErrorMessageList");
			session.remove("userAddressErrorMessageList");
		}
		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
