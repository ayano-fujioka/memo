package com.internousdev.i1810c.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.i1810c.dao.CartInfoDAO;
import com.internousdev.i1810c.dao.MCategoryDAO;
import com.internousdev.i1810c.dao.PurchaseHistoryInfoDAO;
import com.internousdev.i1810c.dto.CartInfoDTO;
import com.internousdev.i1810c.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int id;

	public String execute() {
		String result = LOGIN;
		if (!(session.containsKey("mCategoryDtoList"))) {
			session.put("mCategoryDtoList", (new MCategoryDAO()).getMCategoryList());
		}
		if (session.containsKey("logined")) {
			result = ERROR;
			if (session.containsKey("isSettlement")) {
				session.remove("isSettlement");
					CartInfoDAO cartInfoDAO=new CartInfoDAO();
					List<CartInfoDTO> cartInfoDtoList=new ArrayList<CartInfoDTO>();
					cartInfoDtoList=cartInfoDAO.getCartInfoDtoList(String.valueOf(session.get("loginId")));
					List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList=new ArrayList<PurchaseHistoryInfoDTO>();
					for(int i=0;i<cartInfoDtoList.size();i++){
						PurchaseHistoryInfoDTO purchaseHistoryInfoDTO=new PurchaseHistoryInfoDTO();
						purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
						purchaseHistoryInfoDTO.setProductId(cartInfoDtoList.get(i).getProductId());
						purchaseHistoryInfoDTO.setProductName(cartInfoDtoList.get(i).getProductName());
						purchaseHistoryInfoDTO.setProductNameKana(cartInfoDtoList.get(i).getProductNameKana());
						purchaseHistoryInfoDTO.setImageFilePath(cartInfoDtoList.get(i).getImageFilePath());
						purchaseHistoryInfoDTO.setImageFileName(cartInfoDtoList.get(i).getImageFileName());
						purchaseHistoryInfoDTO.setPrice(cartInfoDtoList.get(i).getPrice());
						purchaseHistoryInfoDTO.setReleaseCompany(cartInfoDtoList.get(i).getReleaseCompany());
						purchaseHistoryInfoDTO.setReleaseDate(cartInfoDtoList.get(i).getReleaseDate());
						purchaseHistoryInfoDTO.setProductCount(cartInfoDtoList.get(i).getProductCount());
						purchaseHistoryInfoDTO.setSubtotal(cartInfoDtoList.get(i).getSubtotal());
						purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDTO);
					}
					PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
					int count = 0;
					for (int i = 0; i < purchaseHistoryInfoDtoList.size(); i++) {
						count += purchaseHistoryInfoDAO.regist(String.valueOf(session.get("loginId")),
								purchaseHistoryInfoDtoList.get(i).getProductId(),
								purchaseHistoryInfoDtoList.get(i).getProductCount(),
								id,
								purchaseHistoryInfoDtoList.get(i).getSubtotal());
					if (count > 0) {
						count = cartInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
						if (count > 0) {
							session.remove("cartInfoDtoList");
							session.remove("destinationInfoDtoList");
							result = SUCCESS;
						}
					}
				}
			}
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
