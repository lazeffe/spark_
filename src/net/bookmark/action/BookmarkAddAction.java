package net.bookmark.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bookmark.db.BookmarkDAO;
import net.bookmark.db.BookmarkDTO;
import net.park.db.BoardDAO;
import net.park.db.BoardDTO;

public class BookmarkAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkDAO bmdao = new BookmarkDAO();
		ActionForward forward=new ActionForward();
		HttpSession session = request.getSession();
		String email =(String)session.getAttribute("email");
		String code = request.getParameter("PARKING_CODE");
		
		System.out.println(code);
		
		BoardDAO boarddao = new BoardDAO();
		BoardDTO boarddto = new BoardDTO();
		
		System.out.println("info start");
		boarddto = boarddao.getInfo(code);
		System.out.println("info end");
		
		/*if(email == null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
		}*/

		forward.setRedirect(true);
		forward.setPath("/Home.Lo");
		return forward;
	}

}
