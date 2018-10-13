package net.bookmark.action;

import java.io.PrintWriter;
import java.util.List;

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
		ActionForward forward = null;
		List<BookmarkDTO> limit = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		BookmarkDAO bmdao = new BookmarkDAO();
		BookmarkDTO dto = new BookmarkDTO();

		BoardDAO bodao = new BoardDAO();
		BoardDTO bodto = new BoardDTO();

		String code = request.getParameter("PARKING_CODE");
		String name = request.getParameter("PARKING_NAME");

		System.out.println(code);
		System.out.println(name);

		/*String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");*/

		String email = (String) session.getAttribute("email");

		int result1 = bmdao.getlistchk(email, name);

		if (result1 == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 즐겨찾기에 주차한 주차장입니다.')");
			out.println("location.href='/Home.Lo'");
			out.println("</script>");
			out.close();

			return null;

		}

		boolean result2;

		/*result2 = bmdao.getaddlimit(email);

		if (result2) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('즐겨찾기에 추가되었습니다.')");
			out.println("location.href='/Home.Lo'");
			out.println("</script>");
			out.close();
			bmdao.bmkAdd(email, name);

		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('즐겨찾기 개수가 초과되었습니다.')");
			out.println("location.href='/Home.Lo'");
			out.println("</script>");
			out.close();
		}*/

		forward = new ActionForward();
		forward.setPath("/views/favorite.jsp");
		forward.setRedirect(false);

		return forward;

	}

}
