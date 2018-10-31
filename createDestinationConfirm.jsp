<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/i1810c.css">
<link rel="stylesheet" type="text/css" href="./css/createDestinationConfirm.css">
<link rel="stylesheet" type="text/css" href="./css/form.css">
<title>宛先情報確認</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="contents">
		<h1>宛先情報確認画面</h1>
			<p id="createDestinationConfirm-p">以下の内容で登録します</p>

		<div id="createDestinationConfirm-box">
			<s:form action="CreateDestinationCompleteAction">
				<table class="inner-box">
					<tr>
           				<th>姓</th>
           					<td>：</td>
            				<td><s:property value="familyName"/></td>
            		</tr>

            		<tr>
           				<th>名</th>
           					<td>：</td>
            				<td><s:property value="firstName"/></td>
            		</tr>

            		<tr>
           				<th>姓ふりがな</th>
           					<td>：</td>
            				<td><s:property value="familyNameKana"/></td>
            		</tr>

            		<tr>
           				<th>名ふりがな</th>
           					<td>：</td>
            				<td><s:property value="firstNameKana"/></td>
            		</tr>

            		<tr>
           				<th>性別</th>
           					<td>：</td>
            				<td><s:property value="sexWord"/></td>
            		</tr>

               		<tr>
           				<th>住所</th>
           					<td>：</td>
            				<td><s:property value="userAddress"/></td>
            		</tr>

               		<tr>
           				<th>電話番号</th>
           					<td>：</td>
            				<td><s:property value="telNumber"/></td>
            		</tr>

            		<tr>
           				<th>メールアドレス</th>
           					<td>：</td>
            				<td><s:property value="email"/></td>
            		</tr>

				</table>

				<div class="register-btn-box">
						<s:submit value="登録情報を確定" class="form-submit" />
						<s:token />
				</div>
			</s:form>
		</div>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>