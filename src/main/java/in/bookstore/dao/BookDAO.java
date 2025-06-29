package in.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.bookstore.model.Book;
import in.bookstore.util.ConnectionFactory;

public class BookDAO {

	public boolean insertBook(Book book) {

		String insert = "insert into books (title,author,price) values(?,?,?)";

		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setString(1, book.getTitle());
			pstm.setString(2, book.getAuthor());
			pstm.setFloat(3, book.getPrice());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public List<Book> listAllBook() {
		List<Book> listBook = new ArrayList<>();
		String sql = "select * from books";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");

				Book book = new Book(id, title, author, price);
				listBook.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBook;
	}

	public boolean deleteBook(Book book) {
		String delete = "delete from books where book_id=?";
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstm = con.prepareStatement(delete);
			pstm.setInt(1, book.getId());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateBook(Book book) {

		String update = "update books set title=?,author=?,price=? where book_id=?";

		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstm = con.prepareStatement(update);
			pstm.setString(1, book.getTitle());
			pstm.setString(2, book.getAuthor());
			pstm.setFloat(3, book.getPrice());
			pstm.setInt(4, book.getId());

			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Book getBook(int id) {
		Book book = null;
		String select = "select * from books where book_id = ?";
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstm = con.prepareStatement(select);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");

				book = new Book(id, title, author, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
