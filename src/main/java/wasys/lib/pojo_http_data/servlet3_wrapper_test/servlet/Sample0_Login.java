/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample0_Login.java
Created on: May 26, 2020 5:45:01 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler;
import wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.Sample0_Login_Entity;

/**
 *
 * @author https://github.com/911992
 */
public class Sample0_Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
//            Sample0_Login_Entity _ent=new Sample0_Login_Entity();
//            Servlet_Request_Data_Handler.fill(req,_ent); 
            Sample0_Login_Entity _ent=Servlet_Request_Data_Handler.fill(req, new Sample0_Login_Entity());
            PrintWriter _out=resp.getWriter();
            String _enc=req.getCharacterEncoding();
            if(_ent.was_object_filling_success()){
                _out.printf("Login was success! email:%s , pass:%s\n",_ent.getEmail(),_ent.getPassword());
            }else{
                _out.printf("Login was failed! err:%s", _ent.get_fields_fill_msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./sample0_login.xhtml").forward(req, resp);
    }

}
