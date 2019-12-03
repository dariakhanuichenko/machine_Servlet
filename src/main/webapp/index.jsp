<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <%--    <link href="${pageContext.request.contextPath}/static/style.css" rel="stylesheet">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="static/styles2.min.css">
    <link rel="stylesheet" href="static/style.css">
</head>
<body>
<div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="#"><span
                style="color: red; font-size:20pt; font-family: 'Arial Black'">My</span> machine</a>

            <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                    class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                 id="navcol-1">

                <span class="navbar-text actions"> <a href="${pageContext.request.contextPath}/app/login" class="login">
                    <fmt:message
                            key="message.login"/></a>
                    <a class="btn btn-light action-button" role="button"
                       href="${pageContext.request.contextPath}/app/registration"
                       style="background-color: #FF3C40;"> <fmt:message key="message.registration"/></a></a>
                </span>
                <a class="btn" id="locales"
                   href="?sessionLocale=en"><img src="static/United-Kingdom-flag-icon.png" height="30px"/></a>
                <a class="btn"
                   href="?sessionLocale=ua"><img src="static/Ukraine-Flag-icon.png" height="30px"/> </a>


            </div>
        </div>
    </nav>
</div>
<!--<div data-bs-parallax-bg="true"-->
<!--     style="height: 500px;background-image: url(&quot;/assets/img/background.png&quot;);background-position: center;background-size: cover;"></div>-->

<div id="line"></div>
<div style="margin-left:40%; margin-right: 15%; margin-top: 2%" class="row">
    <div class="col">
        <div class="table-responsive">
            <table class="table table-borderless">
                <thead>
                <tr>
                    <th> product name</th>
                    <th> price</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td style="width: 70px; valign:middle;"><c:out value="${product.name}"/></td>

                        <td style="width: 30px; valign:middle;"><c:out value="${product.price}"/></td>
                        <td style="width: 30px;">
                            <a id="buttonBuy" href="/app/local/buy-product?id=${product.id}" type="submit"
                               style="${product.currentLoad == 0 ? 'pointer-events: none;' : 'pointer-events: auto;'}">
                                Buy
                            </a>
                        </td>
                        <td>
                            <c:if test="${product.currentLoad == 0}">
                                <button style="background-color: red;padding: 20px;
                                                                text-align: center;
                                                                text-decoration: none;
                                                                display: inline-block;
                                                                font-size: 16px;
                                                                margin: 4px 2px;
                                                                border-radius: 50%;
                                                                border: none;"
                                ></button>
                            </c:if>
                            <c:if test="${product.currentLoad != 0}">
                                <button style="background-color: green;
                                                padding: 20px;
                                        text-align: center;
                                        text-decoration: none;
                                        display: inline-block;
                                        font-size: 16px;
                                        margin: 4px 2px;
                                        border-radius: 50%;
                                        border: none;"
                                        class="button5"></button>
                            </c:if>
                                <%--                            <button style="${product.currentLoad} == 0 ? background-color: red;' : 'background-color: green;"--%>
                                <%--                                    class="button button5"></button>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<c:if test="${param.error == true}">
    <div class="alert alert-danger"
         role="alert">
        Put enought money
    </div>
</c:if>


<div style="margin-left: 35%">
    <form action="/app/local/pay"
          method="post">
        <span>Put</span>
        <span><c:out value="${payment}"/></span>
        <span>money</span>
        <input name="money1" pattern="[0-9]+">
        <button id="buttonPay" type="submit">
            <span>Pay</span></button>
    </form>
    <a id="buttonCansel" href="/app/local/cancel" onclick="makeCanceled()" type="submit">
        <span>Cancel</span>
    </a>
</div>
<c:if test="${not empty param.return_}">
    <div id="cancel" class="alert alert-primary" role="alert">
        Returned
        <span><c:out value="${param.return_}"/></span>
        money
    </div>
</c:if>

<%--<script>--%>
<%--    // return_ != 'null';--%>
<%--    if (return_ != null) {--%>
<%--        document.getElementById('cancel').style.display = 'block';--%>
<%--    } else {--%>
<%--        document.getElementById('cancel').style.display = 'none';--%>
<%--    }--%>
<%--</script>--%>
<script>
    function makeCanceled() {
        document.getElementById("cancel").style.display = "block";
    }
</script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/script2.min.js"></script>
</body>
</html>
