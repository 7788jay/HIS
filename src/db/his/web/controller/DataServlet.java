package db.his.web.controller;

import db.his.domain.Database;
import db.his.service.DataService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 林 on 2015/9/14.
 */
@WebServlet("/servlet/DataServlet")
public class DataServlet extends HttpServlet {
    DataService dataService = new DataService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if("query".equals(method)){
            query(request, response);
        }
        if("backup".equals(method)){
            backup(request,response);
        }if("restore".equals(method)){
            restore(request, response);
        }if("del".equals(method)){
            del(request, response);
        }

    }

    /**
     * 删除
     * @param request
     * @param response
     */
    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject();
        String no = request.getParameter("no");
        try {
            dataService.del(no);
            json.put("message","删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            json.put("message", "删除失败！");
        }

        response.getWriter().write(json.toString());
    }

    /**
     * 还原
     * @param request
     * @param response
     */
    private void restore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        JSONObject json = new JSONObject();
        try{
            String realpath = getServletContext().getRealPath("/");
            String fullfilename=realpath+"backup\\"+name;
            String command="cmd /c mysql -uroot -proot his<"+fullfilename;
            Runtime.getRuntime().exec(command);
            json.put("message", "还原成功！");
        }catch(Exception e){
            //throw new RuntimeException("恢复失败！！");
            json.put("message","还原失败！");

        }
        response.getWriter().write(json.toString());

    }

    /**
     * 查询
     * @param request
     * @param response
     */
    private void query(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Database> lists = dataService.getBackUpList();
            request.setAttribute("lists",lists);
            request.getRequestDispatcher("/manager/data/data.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 备份
     * @param request
     * @param response
     */
    private void backup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject();
        try {
            String realpath = getServletContext().getRealPath("/");
            dataService.backupDatabase(realpath);
            json.put("message","备份成功！");
        }catch (Exception e){
            e.printStackTrace();
            json.put("message", "备份失败！");
        }

        response.getWriter().write(json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
