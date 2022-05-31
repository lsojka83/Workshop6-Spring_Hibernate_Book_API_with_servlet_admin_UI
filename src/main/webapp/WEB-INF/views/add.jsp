<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">BookCRUD</h1>
        <a href="/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Book list</a>
    </div>

    <form method="post" action="/add">
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Add book</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                        <tbody>
                        <tr>
                            <td>Isbn</td>
                            <td><input type="text" name="isbn" required></td>
                        </tr>

                        <tr>
                            <td>Title</td>
                            <td><input type="text" name="title" required></td>
                        </tr>
                        <tr>
                            <td>Author</td>
                            <td><input type="text" name="author" required></td>
                        </tr>
                        <tr>
                            <td>Publisher</td>
                            <td><input type="text" name="publisher" required></td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td><input type="text" name="type" required></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>


        <div class="text-center">
            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit" name="addConfirmButton"
                    value="yes">Add</button>
            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit" name="addConfirmButton"
            value="no" formnovalidate>Cancel</button>
        </div>
    </form>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->

<%@ include file="/WEB-INF/jspf/footer.jspf" %>

