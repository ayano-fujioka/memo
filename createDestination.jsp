<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/i1810c.css">
<link rel="stylesheet" type="text/css" href="./css/form.css">
<title>宛先情報入力</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="contents">
		<h1>宛先情報入力画面</h1>
		  <p id="ceateDestination-contents-p">下記に必要事項を記入してください</p>

		<div class="error">
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>

			<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</s:if>
		</div>

		<div id="create-box">
			<s:form action="CreateDestinationConfirmAction">
				<span class="form-heading">姓</span>
					<s:textfield name="familyName" value="%{familyName}" class="form-txt"/>
				<span class="form-heading">名</span>
					<s:textfield name="firstName" value="%{firstName}" class="form-txt"/>
				<span class="form-heading">姓ふりがな</span>
					<s:textfield name="familyNameKana" value="%{familyNameKana}" class="form-txt"/>
				<span class="form-heading">名ふりがな</span>
					<s:textfield name="firstNameKana" value="%{firstNameKana}" class="form-txt"/>
				<span class="form-heading">性別</span>
				<s:if test="sex == null || sex.equals(0)">
					<input type="radio" name="sex" value="0" checked="checked">男性
					<input type="radio" name="sex" value="1">女性
				</s:if>
				<s:elseif test='sex.equals(1)'>
					<input type="radio" name="sex" value="0">男性
					<input type="radio" name="sex" value="1" checked="checked">女性
				</s:elseif><br><br>
				<span class="form-heading">住所</span>
					<s:textfield name="userAddress" value="%{userAddress}" class="form-txt"/>
				<span class="form-heading">電話番号</span>
					<s:textfield name="telNumber" value="%{telNumber}" class="form-txt"/>
				<span class="form-heading">メールアドレス</span>
					<s:textfield name="email" value="%{email}" class="form-txt"/>
				<s:submit class="form-submit" value="宛先情報確認"/>
			</s:form>
		</div>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>