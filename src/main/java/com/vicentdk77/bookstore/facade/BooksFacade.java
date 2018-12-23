package com.vicentdk77.bookstore.facade;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.vicentdk77.bookstore.bean.MyBooksDto;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class BooksFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection connection = getConnection();
        String sql = " select * from mybooks order by id";
        QueryRunner queryRunner = new QueryRunner();
        List<MyBooksDto> mybooksList = queryRunner.query(connection,sql, new BeanListHandler<>(MyBooksDto.class));
        request.setAttribute("mybooksList",mybooksList);
        return mapping.findForward("success");
    }

    public Connection getConnection() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource("javawebapp");
        return dataSource.getConnection();
    }
}
