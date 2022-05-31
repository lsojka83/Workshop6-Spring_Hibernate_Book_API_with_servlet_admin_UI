<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/jspf/header.jspf" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">BookCRUD</h1>
        <a href="/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Books list</a>
    </div>

    <form method="post" action="/edit">
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Edit book</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                        <tbody>
                        <tr>
                            <td>isbn</td>
                            <td><input value="${book.isbn}" name="isbn" type="text" required/>
                        </tr>
                        <tr>
                            <td>Title</td>
                            <td><input value="${book.title}" name="title" type="text" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>Author</td>
                            <td><input value="${book.author}" name="author" type="text" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>Publisher</td>
                            <td><input value="${book.publisher}" name="publisher" type="text"required/>
                            </td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td><input value="${book.type}" name="type" type="text" required
                            />
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <input type="hidden" name="id" value="${book.id}"/>

        <div class="text-center">
            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit" name="editConfirmButton"
                    value="yes">Save
            </button>
            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit" name="editConfirmButton"
                    value="no" formnovalidate>Cancel
            </button>
        </div>

    </form>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->

<%@ include file="/WEB-INF/jspf/footer.jspf" %>