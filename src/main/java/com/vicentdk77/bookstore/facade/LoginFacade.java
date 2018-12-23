package com.vicentdk77.bookstore.facade;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class LoginFacade extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        ComboPooledDataSource c3p0Pool = new ComboPooledDataSource("javawebapp");
        Connection connection = c3p0Pool.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT count(id) FROM mybooks WHERE price >= ? AND price <= ?";
        long sum = (Long) queryRunner.query(connection, sql, new ScalarHandler(), 1,55);
        System.err.println("sum="+sum);
        return mapping.findForward("failed");

    }
}
