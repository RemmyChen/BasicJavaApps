<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<meta http-equiv="Cache-Control" content="no-cache"/>
<!DOCTYPE html>
<html>
<head>
    <title>Comments</title>
</head>
<body>
<p>Comments</p>
<form action="comment" method="post">
    <div>
        <p>Post a comment:</p>
        <input id="input" placeholder="请输入" autocomplete="off" maxlength="6" value="" type="text" >
    </div>
    <div>
        <div style="margin-top: 20px;"><input class="submit-btn" type="submit" value="Post"></div>
    </div>
</form>
</body>
</html>
