<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"></jsp:include>

<h3>Service Registration</h3>
<br>
<form action='/createService' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Name</b></td> 
            <td><input type='text' name='name' class='form-control'  required/></td>
        </tr>
 
        <tr>
            <td><b>URL</b></td>
            <td><input type='text' name='url' class='form-control' required /></td>
        </tr>  
        <tr>
            <td><b>UserID</b></td>
            <td><input type='text' name='userId' class='form-control' required /></td>
        </tr> 
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Register</button>
            </td>
        </tr>
 
    </table>
    <b><c:out value="${danger}"></c:out></b>
</form>



<h3>List Of Services</h3>
<br>
<table class="table table-hover">

    <thead>
      <tr>
        <th><b>Service Name</b></th>
        <th><b>URL</b></th>
        <th><b>Status</b></th>
        <th><b>Last Updated</b></th>
        <th><b>UserID</b></th>
        <th><b>Created On</b></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="serv">
      <tr>
        <td><c:out value="${serv.name}"></c:out></td>
        <td><c:out value="${serv.url}"></c:out></td>
        <td><c:out value="${serv.status}"></c:out></td>
        <td><c:out value="${serv.dateUpdated}"></c:out></td>
        <td><c:out value="${serv.userId}"></c:out></td>
        <td><c:out value="${serv.dateCreated}"></c:out></td>
         <td>
             <a href="/${serv.pollerId}/edit">
                <button type="submit" class="btn btn-primary">Edit Service</button>
                </a>
            </td>
            <td>
             <a href="/${serv.pollerId}/delete">
                <button type="submit" class="btn btn-primary">Delete Service</button>
                </a>
            </td>
      </tr>

          </c:forEach>
    </tbody>
  </table>
</div>

<jsp:include page="footer.jsp"></jsp:include>