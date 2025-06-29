package in.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bookstore.dao.BookDAO;
import in.bookstore.model.Book;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

	private BookDAO bookDAO;

	@Override
	public void init() throws ServletException {
		bookDAO = new BookDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String idParam = req.getParameter("id");

		if ("delete".equals(action) && idParam != null) {
			int bookId = Integer.parseInt(idParam);
			boolean success = bookDAO.deleteBook(new Book(bookId));
			req.setAttribute("msg", success ? "Book deleted successfully." : "Failed to delete book.");
			resp.sendRedirect("book"); // Refresh list
			return;
		}

		if ("edit".equals(action) && idParam != null) {
			int bookId = Integer.parseInt(idParam);
			Book book = bookDAO.getBook(bookId);
			req.setAttribute("book", book);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}

		List<Book> list = bookDAO.listAllBook();
		req.setAttribute("listBook", list);
		req.getRequestDispatcher("/viewBook.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String priceStr = req.getParameter("price");

		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (NumberFormatException e) {
			req.setAttribute("msg", "Invalid price format.");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}

		Book book = new Book(title, author, price);
		boolean success;
		String msg;

		if (idStr != null && !idStr.isEmpty()) {
			book.setId(Integer.parseInt(idStr));
			success = bookDAO.updateBook(book);
			msg = success ? "Book updated successfully." : "Failed to update book.";
		} else {
			success = bookDAO.insertBook(book);
			msg = success ? "Book saved successfully." : "Failed to save book.";
		}

		req.setAttribute("msg", msg);
		req.setAttribute("book", null); // Reset form
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
