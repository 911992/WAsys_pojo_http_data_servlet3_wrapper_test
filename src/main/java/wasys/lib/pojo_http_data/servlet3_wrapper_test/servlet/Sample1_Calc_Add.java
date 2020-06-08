/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample1_Calc_Add.java
Created on: May 27, 2020 3:17:27 AM
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
import wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.Sample1_Calc_Entity_Pooled;

/**
 *
 * @author https://github.com/911992
 */
public class Sample1_Calc_Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Sample1_Calc_Entity_Pooled _ent = Sample1_Calc_Entity_Pooled.instance()){
            Servlet_Request_Data_Handler.fill(req, _ent);
            PrintWriter _out=resp.getWriter();
            if(_ent.was_object_filling_success()){
                _out.printf("Success data: first number(a) + second number(b): %d (how interesting!)",_ent.getVal0()+_ent.getVal1());
            }else{
                _out.printf("Op was failed! err message(s):\n%s\n", _ent.get_fields_fill_msg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./sample1_calc.xhtml").forward(req, resp);
    }
   

}
