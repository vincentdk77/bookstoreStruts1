package com.vicentdk77.bookstore.facade;

import com.vicentdk77.bookstore.bean.MyBooksDto;
import com.vicentdk77.bookstore.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

public class ShoppingCarFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String type= request.getParameter("type");
        String id= request.getParameter("id");
        if("add".equals(type)){
            add(id,request);
            response.getWriter().write("success");
            return null;
        }
        return mapping.findForward("success");
    }
    public void add(String id,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        Connection connection = JDBCUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = " select * from mybooks a where a.id="+id;
        MyBooksDto myBooksDto = queryRunner.query(connection,sql,new BeanHandler<MyBooksDto>(MyBooksDto.class));
        ArrayList<MyBooksDto> myBooksDtos = (ArrayList<MyBooksDto>)session.getAttribute("shoppingCarList");
        boolean haveId =false;
        if(myBooksDtos != null){//已使用过"加入购物车"按钮
            for(MyBooksDto book: myBooksDtos){
                String  id1 = book.getId()+"";
                if(id1.equals(id)){//购物车中已有这本书
                    book.setCount(book.getCount()+1);
                    haveId = true;
                    session.setAttribute("shoppingCarList",myBooksDtos);
                    return;
                }
            }
            if(!haveId){//购物车中没有这本书
                myBooksDto.setCount(1);
            }
        }else{//第一次使用"加入购物车"
            myBooksDtos = new ArrayList<>();
            myBooksDto.setCount(1);
        }
        myBooksDtos.add(myBooksDto);
        session.setAttribute("shoppingCarList",myBooksDtos);

    }
}
