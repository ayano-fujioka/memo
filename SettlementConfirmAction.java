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
			�@�@(containsKey���w�肵���L�[�����݂��邩�F�����s���A���݂���ꍇ��true��Ԃ��B)

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
								(new�������ŃC���X�^���X������DestinationInfoDAO���g����悤�ɂ����B)
								
			List<DestinationInfoDTO> destinationInfoDtoList=new ArrayList<DestinationInfoDTO>();
			(��DestinationInfoDTO���������f�[�^��destinationInfoDtoList�Ƃ������O�Ń��X�g�ɂ��܂��A�̈ӁB)

			destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
			(��destinationInfoDtoList�������ňꎞ�I�Ƀf�[�^��ێ����郊�X�g)

			Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
			(��Iterator�C���^�t�F�[�X�́AList��Map�Ȃǂ̃R���N�V�����̗v�f���A���Ԃɏ�������ꍇ�Ɏg�p���܂��B)

			if (!(iterator.hasNext())) {
			(��hasNext���\�b�h�c�Ō�̗v�f�ɓ��B���Ă����� false�A����ȊO�� true��Ԃ��܂��B)
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
