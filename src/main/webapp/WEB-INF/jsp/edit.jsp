<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<<jsp:include page="header.jsp"></jsp:include>

<div class="container">

<h3>service Registration</h3>
<form action='/update' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Service Name</b></td>
            <td><input type='text' name='name' class='form-control' value="${service.name}" /></td>
        </tr>
 
        <tr>
            <td><b>URL</b></td>
            <td><input type='text' name='url' class='form-control' value="${service.url}" /></td>
        </tr>
 
 			<input type='hidden' id='id' rows='5' class='form-control' name='pollerId' value="${service.pollerId}"/>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Update service</button>
            </td>
        </tr>
 
    </table>
</form>


</div>

<jsp:include page="footer.jsp"></jsp:include>