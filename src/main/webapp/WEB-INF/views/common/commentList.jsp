<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<table class="table table-striped">
	<c:forEach items="${list}" var="dto" >
		<tr>
			<td id="contents${dto.num}">
				<textarea rows="2" cols="20" readonly>${dto.contents}</textarea>
			</td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>	
			<td>
			<c:if test="${member.id eq dto.writer}">
			<!--<button class="btn btn-info update" data-comment-num="${dto.num}">댓글수정하기</button> -->
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="댓글수정">댓글수정</button>
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">댓글수정하기</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <form>
			          <div class="mb-3">
			            <label for="${dto.writer}" class="col-form-label">작성자:</label>
			            <input type="text" class="form-control" id="${dto.writer}">
			          </div>
			          <div class="mb-3">
			            <label for="${dto.contents}" class="col-form-label">내용수정:</label>
			            <textarea class="form-control" id="${dto.contents}"></textarea>
			          </div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			        <button type="button" class="btn btn-primary update">수정하기</button>
			      </div>
			    </div>
			</div>
			</div>
			</c:if>
			</td>
			<td>
			<c:if test="${member.id eq dto.writer}">
			<button class="btn btn-danger del" data-comment-num="${dto.num}">댓글삭제하기</button>
			</c:if>
			</td>
			<td>
			
			  

			
			
			</td>
		</tr>
	</c:forEach>
</table>	
		<div class="row">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	 <li class="page-item">
					     <a class="page-link " href="#" aria-label="Previous" data-board-page="1">
					        <span aria-hidden="true">&laquo;</span>
					     </a>
					  	 </li>
					  	 
					  	<li class="page-item ${pager.before?'disabled':''}">
					      <a class="page-link " href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
					        <span aria-hidden="true">&lsaquo;</span>
					      </a>
					    </li>
					  	
					    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					    <li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a></li>
					    </c:forEach>
					    
					    <li class="page-item ${pager.after eq false ? 'disabled':'' }" >
					    									<%-- ${pager.after eq false ? 'disabled':'' --%>
					      <a class="page-link" href="#" data-board-page="${pager.lastNum+1}" aria-label="Next">
					        <span aria-hidden="true">&rsaquo;</span>
					      </a>
					    </li>
					 				    
					    <li class="page-item" ><%-- ${pager.after eq false ? 'disabled':''} --%> 
					      <a class="page-link" href="#" aria-label="Next" data-board-page="${pager.totalPage}">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
				</div>	
