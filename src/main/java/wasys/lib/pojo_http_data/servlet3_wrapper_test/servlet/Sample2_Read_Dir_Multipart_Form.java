/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample2_Read_Dir_Multipart_Form.java
Created on: May 27, 2020 4:37:43 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler;
import wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.Sample2_Read_Dir_Entity;

/**
 *
 * @author https://github.com/911992
 */
@MultipartConfig()
public class Sample2_Read_Dir_Multipart_Form extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Servlet_Request_Data_Handler _reqh = Servlet_Request_Data_Handler.new_pooled_instance(req);) {
            PrintWriter _out=resp.getWriter();
            if(_reqh.is_multipart_request()==false){
                _out.printf("Multipart form data expected!");
                return;
            }
            Sample2_Read_Dir_Entity _ent=new Sample2_Read_Dir_Entity();
            _reqh.fill_object(_ent);
            if(_ent.was_object_filling_success()==false){
                _out.printf("Error, unexped/bad data for path, info:\n%s", _ent.get_fields_fill_msg());
                return;
            }
            String _path = _ent.getPath();
            if(_path==null){
                _path="./";
                _out.printf("Null/missed path, using default %s\n", _path);
            }
            File _f=new File(_path);
            if(_f.exists()==false){
                _out.printf("Err! requested path(%s) is not exist\n",_path);
                return;
            }
            if(_f.isDirectory()){
                String[] _child_ls=_f.list();
                _out.printf("Path is a dir, num of childs:%d\n", _child_ls.length);
                int _idx = 0;
                for(String _fn:_child_ls){
                    _out.printf("%d - %s\n", _idx++,_fn);
                }
            }else{
                _out.printf("Err, requested path is a file, not a folder!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./sample2_read_dir_multipart_form.xhtml").forward(req, resp);
    }
   
}
