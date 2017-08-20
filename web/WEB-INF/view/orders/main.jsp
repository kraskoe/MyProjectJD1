<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>№</th>
        <th>Order Id</th>
        <th>User id</th>
        <th>Sum</th>
    </tr>

    <c:forEach var="orderDto" items="${orders}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${orderDto.id}</td>
            <td>${orderDto.country}</td>
            <td>${orderDto.city}</td>
            <td>${orderDto.hotel}</td>
            <td>${orderDto.board}</td>
            <td>${orderDto.departure}</td>
            <td>${orderDto.arrival}</td>
            <td>${orderDto.duration}</td>
            <td>${orderDto.quantity}</td>
            <td>${orderDto.fullCost}</td>
            <td>${orderDto.orderDate}</td>
        </tr>
    </c:forEach>
</TABLE>
