<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div>&nbsp</div>
    <div>
    <form action="frontController?command=register" method="post">
        <table align="center" cellpadding="10" cellspacing="10">
            <tr>
                <td width="155"><b>Логин<br>&nbsp</b></td>
                <td><input type="text" name="login" maxlength="30"/><br>&nbsp</td>
            </tr>
            <tr>
                <td><b>Пароль<br>&nbsp</b></td>
                <td><input type="password" name="password" maxlength="20"/><br>&nbsp</td>
            </tr>
            <tr>
                <td><b>Повторите пароль</b></td>
                <td><input type="password" name="passwordConfirmation" maxlength="20"/></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Регистрация">
        <br>
        <br>
        <div>У вас уже есть учетная запись?</div>
        <div><a href="${pageContext.request.contextPath}/frontController?command=login">Вход</a></div>
    </form>
    </div>
</div>
