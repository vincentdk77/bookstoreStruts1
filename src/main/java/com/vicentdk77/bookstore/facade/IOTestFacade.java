package com.vicentdk77.bookstore.facade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class IOTestFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BufferedReaderWriter();
        String url = request.getServletContext().getRealPath("1.txt");
        File file = new File(url);
        file.createNewFile();
        String url1 = request.getContextPath();
        String url3 = IOTestFacade.class.getResource("dbcp.txt").getPath();
        return mapping.findForward("success");
    }
    public void BufferedReaderWriter() throws IOException {
        File file = new File("dbcp.txt");
        String url = file.getAbsolutePath();
        FileReader reader = new FileReader(file);
        Writer writer = new FileWriter("dbcp3.txt");
        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(writer);
        //BufferedReader br = new BufferedReader(new FileReader("dbcp.txt"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("dbcp1.txt"));
        String str = null;
        while((str = br.readLine())!= null){
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
    //实现文件（文本文件、图片、视频等等）的复制
    public void copyFile(String src ,String des){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(src));
            fos = new FileOutputStream(new File(des));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
