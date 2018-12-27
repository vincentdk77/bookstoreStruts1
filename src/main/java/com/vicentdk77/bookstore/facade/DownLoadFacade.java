package com.vicentdk77.bookstore.facade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadFacade extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileUrl ="http://e.hiphotos.baidu.com/image/pic/item/a686c9177f3e6709b52f456437c79f3df8dc5579.jpg";
        String format = fileUrl.substring(fileUrl.lastIndexOf("."));
        String fileLocal ="D:\\fileinfo" +File.separator+"报案号"+File.separator+"事故认定书号"+File.separator+"ID";
        File file=new File(fileLocal);
        //判断文件夹是否存在
        if (!file.exists())
        {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        fileLocal += File.separator+"举证通知书1"+format;
        downloadFile(fileUrl,fileLocal);
        return mapping.findForward("success");
    }
    public boolean downloadFile(String fileUrl,String fileLocal) throws Exception {
         boolean flag=false;
         URL url = new URL(fileUrl);
         HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
         urlCon.setConnectTimeout(6000);
         urlCon.setReadTimeout(6000);
         int code = urlCon.getResponseCode();
         if (code != HttpURLConnection.HTTP_OK) {
          throw new Exception("文件读取失败");
         }
         //读文件流
         DataInputStream in = new DataInputStream(urlCon.getInputStream());
         DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
         byte[] buffer = new byte[2048];
         int count = 0;
         while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
         }
         try {
                if(out!=null) {
                    out.close();
                }
                if(in!=null) {
                    in.close();
                }

          } catch (Exception e) {
                e.printStackTrace();
                return flag;
          }
         flag=true;
         return flag;
    }
}
