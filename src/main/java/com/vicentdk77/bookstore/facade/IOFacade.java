package com.vicentdk77.bookstore.facade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URL;

public class IOFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // /bookstore
        String path1 = request.getContextPath();
        //  /io.do
        String path2 = request.getServletPath();
        // D:\JavaRelation\Workpaces\myproject\bookstoreStruts1\target\bookstoreStruts1\1.txt
        String path3 = request.getServletContext().getRealPath("1.txt");
        // /D:/JavaRelation/Workpaces/myproject/bookstoreStruts1/target/bookstoreStruts1/WEB-INF/classes/
        String path4 = IOFacade.class.getClassLoader().getResource("").getPath();//与当前项目类文件根目录平级的目录，即classes目录下
        // /D:/JavaRelation/Workpaces/myproject/bookstoreStruts1/target/bookstoreStruts1/WEB-INF/classes/com/vicentdk77/bookstore/facade/
        String path5 = IOFacade.class.getResource("").getPath();//与当前class文件平级的目录

        File file = new File(path5+File.separator+"4.txt");
        file.createNewFile();
        return mapping.findForward("success");
    }
}
