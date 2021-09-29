/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.UserAction;

import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.BookDao;
import java.sql.SQLException;
import java.util.List;
import model.book;

/**
 *
 * @author sonthanhnguyen
 */
public class index extends ActionSupport {

    private List<book> bookList;
    private String keyword;
    private final StaticVariables staticVariables = new StaticVariables();

    public String execute() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        bookList = bookDao.getAllBook();
        for (book b : bookList) {
            b.setImage(staticVariables.getUploadPath() + staticVariables.getBookImageUploadPath() + b.getImage());
        }
        return "success";
    }

    public index() {
    }

    public String searchBook() throws SQLException, ClassNotFoundException {
        BookDao bookDao = new BookDao();
        bookList = bookDao.searchBook(keyword);
        for (book b : bookList) {
            b.setImage(staticVariables.getUploadPath() + staticVariables.getBookImageUploadPath() + b.getImage());
        }
        return "success";
    }

    public List<book> getBookList() {
        return bookList;
    }

    public void setBookList(List<book> bookList) {
        this.bookList = bookList;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
