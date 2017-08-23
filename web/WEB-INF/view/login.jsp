<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div>&nbsp</div>
    <div>
    <form action="frontController?command=login" method="post">
        <table align="center" cellpadding="10" cellspacing="10">
            <tr>
                <td width="85" style="text-align: left"><b>Логин<br>&nbsp</b></td>
                <td><input type="text" name="login" maxlength="30"/><br>&nbsp</td>
            </tr>
            <tr>
                <td style="text-align: left"><b>Пароль</b></td>
                <td><input type="password" name="password" maxlength="20"/></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Войти">
        <br>
        <br>
        <div>У вас нет учетной записи?</div>
        <div><a href="${pageContext.request.contextPath}/frontController?command=register">Регистрация</a></div>
    </form>
    </div>
</div>
