/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AdminAction.BookAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import config.StaticVariables;
import dao.BookDao;
import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import model.book;
import model.user;

/**
 *
 * @author sonthanhnguyen
 */
public class BookListAction extends ActionSupport {

    private List<book> bookList;
    private String logedIn;
    private StaticVariables staticVariables = new StaticVariables();

    public String execute() throws SQLException, ClassNotFoundException {

        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("loggedIn")) {
            BookDao bookDao = new BookDao();
            this.bookList = (List<book>) bookDao.getAllBook();
            for (book b : bookList) {
                b.setImage(staticVariables.getUploadPath() + staticVariables.getBookImageUploadPath()+ b.getImage());
            }
            return "success";
        }
        return "error";
    }

    public List<book> getBookList() {
        return bookList;
    }

    public void setBookList(List<book> bookList) {
        this.bookList = bookList;
    }

    public String getLogedIn() {
        return logedIn;
    }

    public void setLogedIn(String logedIn) {
        this.logedIn = logedIn;
    }

    public BookListAction() {
    }

}
