<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${sessionScope.lang}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Manager</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="/assets/css/styles4.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#"><span
            style="color: red; font-size:20pt; font-family: 'Arial Black'">My</span> machine</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse">

         <span class="navbar-text actions"> <a class="login" href="${pageContext.request.contextPath}/app/logout" >
                 <fmt:message key="message.logout"/>
            </a></span>
            <a class="btn" id="locales"
               href="?sessionLocale=en"><img src="${pageContext.request.contextPath}/static/United-Kingdom-flag-icon.png" height="30px"/></a>
            <a class="btn"
               href="?sessionLocale=ua"><img src="${pageContext.request.contextPath}/static/Ukraine-Flag-icon.png" height="30px"/> </a>

        </div>
    </div>
</nav>
</div>
<!--<div data-bs-parallax-bg="true"-->
<!--     style="height: 500px;background-image: url(&quot;/assets/img/background.png&quot;);background-position: center;background-size: cover;"></div>-->

<div id="line"></div>
<%--<div th:if="${param.error}">--%>
<%--    <div class="alert alert-danger" th:text="#{empty.value}">--%>
<%--        <h2 name="${error}" th:text="#{empty.value}"></h2>--%>
<%--    </div>--%>
<%--    <div th:if="${param.logout}">--%>
<%--        <div class="alert alert-info">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <h2 th:if="${error}" th:text="${error}"></h2>--%>
<%--</div>--%>

<div style="margin-left:20%; margin-right: 15%; margin-top: 2%" class="row">
    <div class="col">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Product name</th>
                    <th> Total capasity</th>
                </tr>
                </thead>
                <tbody>

                <div >
                    <c:forEach items="${boxes}" var="box">
                    <tr>
                        <td><c:out value="${box.name}"/></td>
                        <td><c:out value="${box.totalCapasity}"/></td>

                        <td>
                            <form  action="/app/manager/add-product"
                                  method="post">
                                <input
                                        name="quantity"
                                        pattern="[0-9]+">
                                <input value="${box.id}" name="id" type="hidden"/>

                                <button type="submit" id="buttonCansel"><span>Add</span></button>
                            </form>

                        </td>
                    </tr>
                    </c:forEach>
                </div>


                </tbody>
            </table>
        </div>
    </div>
    <div>
        <a id="buttonBuy" href="/manager/get-revenue" onclick="getRevenue()" type="submit">
            <span>Get revenue</span></a>
    </div>
</div>

<div id="return" style="display:none;" class="alert alert-primary" role="alert">
    <span >Returnes</span>
<%--    <span th:text="${returnMoney}"></span>--%>
    <span>Money</span>
</div>
<script>
    function getRevenue() {
        document.getElementById("return").style.display = "block";
    }
</script>

<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/script.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales").click(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales2").click(function () {
            var selectedOption = $('#locales2').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
</body>

</html>