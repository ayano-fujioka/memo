<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css" href="./css/i1810c.css">
<link rel="stylesheet" type="text/css" href="./css/settlementConfirm.css">
<title>決済確認</title>
<script>
function goCreateDestinationAction(){
	document.getElementById("form").action="CreateDestinationAction";
}
function goSettlementCompleteAction(){
	document.getElementById("form").action="SettlementCompleteAction";
}
</script>
</head>
<body>
	<s:include value="header.jsp" />
	<s:form id="form" name="form">
	<div id="SettlementConfirm-contents">
		<h1	id="SettlementConfirm-contents-h1">決済確認</h1>
			<p class="select-address">送り先情報を選択してください</p>

	<div id="address-box">
		<s:iterator value="#session.destinationInfoDtoList" status="st" >
			<div id="address-select">
				<s:if test="#st.index==0">
					<input type="radio" name="id" class="address-select-radio" checked="checked" value="<s:property value='id'/>"/>お届け先住所
				</s:if>
				<s:else>
					<input type="radio" name="id" class="address-select-radio" value="<s:property value='id'/>"/>お届け先住所
				</s:else>
			</div>

			<table class="address-list-table">
				<tr>
					<td><s:label value="名前" /></td>
						<th><s:property value="familyName" />　<s:property value="firstName" /></th>
				</tr>
				<tr>
					<td><s:label value="ふりがな" /></td>
						<th><s:property value="familyNameKana" />　<s:property value="firstNameKana" /></th>
				</tr>
				<tr>
					<td><s:label value="住所" /></td>
						<th><s:property value="userAddress" /></th>
				</tr>
				<tr>
					<td><s:label value="電話番号" /></td>
						<th><s:property value="telNumber" /></th>
				</tr>
				<tr>
					<td><s:label value="メールアドレス" /></td>
						<th><s:property value="email" /></th>
				</tr>
			</table>
		</s:iterator>

		<div class="settle-btn-wrap">
			<s:if test="!#session.destinationInfoDtoList.isEmpty()">
				<s:submit value="決済"  class="settle-btn1" onclick="this.form.action='SettlementCompleteAction';"/>
			</s:if>

			<s:submit value="宛先情報の新規登録"  class="settle-btn2" onclick="this.form.action='CreateDestinationAction';"/>
		</div>
	</div>
	</div>
	</s:form>

	<s:include value="footer.jsp" />

</body>
</html>