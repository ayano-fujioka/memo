package com.internousdev.i1810c.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810c.dao.DestinationInfoDAO;
import com.internousdev.i1810c.dao.MCategoryDAO;
import com.internousdev.i1810c.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;
		if (!session.containsKey("mCategoryDtoList")) {
			　　(containsKey→指定したキーが存在するか認識を行い、存在する場合はtrueを返す。)

			session.put("mCategoryDtoList", (new MCategoryDAO()).getMCategoryList());
		}
		if(!session.containsKey("loginId")){
			session.put("isSettlement", true);
			session.remove("loginIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			result=LOGIN;
		}else{
			session.put("isSettlement", true);
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
								(new→ここでインスタンス化してDestinationInfoDAOを使えるようにした。)
								
			List<DestinationInfoDTO> destinationInfoDtoList=new ArrayList<DestinationInfoDTO>();
			(※DestinationInfoDTOから取ったデータをdestinationInfoDtoListという名前でリストにします、の意。)

			destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
			(※destinationInfoDtoList→ここで一時的にデータを保持するリスト)

			Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
			(※Iteratorインタフェースは、ListやMapなどのコレクションの要素を、順番に処理する場合に使用します。)

			if (!(iterator.hasNext())) {
			(※hasNextメソッド…最後の要素に到達していたら false、それ以外は trueを返します。)
				destinationInfoDtoList = null;
			}
			session.put("destinationInfoDtoList", destinationInfoDtoList);
			result = SUCCESS;
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
