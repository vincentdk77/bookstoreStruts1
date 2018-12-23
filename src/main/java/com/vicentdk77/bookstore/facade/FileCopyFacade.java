package com.vicentdk77.bookstore.facade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

public class FileCopyFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
//        String path = FileCopyFacade.class.getResource("").getPath();
        String path = FileCopyFacade.class.getResource("").getPath()+File.separator+"����.jpg";
        String pathCopy = FileCopyFacade.class.getResource("").getPath()+File.separator+"����_copy1.jpg";
        File file = new File(path);
        File fileCopy = new File(pathCopy);
        long starttime = new Date().getTime();
        if("byte".equals(id)){
            copyByByteStream(file,fileCopy);
        }else if("buffered".equals(id)){
            copyByBufferedStream(file,fileCopy);
        }else if("character".equals(id)){
            copyByCharacterStream(file,fileCopy);//�޷�ʹ���ַ���copyͼƬ��Ƶ��"�Ǵ��ı�"�ļ�,��Ϊ��Щ�ļ���ͨ���ֽ����洢��
        }
        long endtime = new Date().getTime();
        System.err.println("��ʱ��"+(endtime-starttime)/1000+"�룡");
//        response.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        response.getWriter().println("������ɣ���ʱ��"+(endtime-starttime)/1000+"�룡");
        return mapping.findForward("sccess");
    }

    public void copyByCharacterStream(File file,File fileCopy) throws IOException{
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(fileCopy);
        char[] read = new char[1024];
        int len = 0;
        while((len = fr.read(read))!=-1){
            fw.write(read,0,len);
        }
        fw.close();
        fr.close();
    }
    public void copyByByteStream(File file,File fileCopy) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileCopy);
        byte[] read = new byte[1024];
        int len = 0;
        while((len=fis.read(read))!= -1){
            fos.write(read,0,len);
        }
        fis.close();
        fos.close();
    }
    public void copyByBufferedStream(File file,File fileCopy) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileCopy);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] read = new byte[1024];
        int len = 0;
        while((len=bis.read(read))!= -1){
            bos.write(read,0,len);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

}
