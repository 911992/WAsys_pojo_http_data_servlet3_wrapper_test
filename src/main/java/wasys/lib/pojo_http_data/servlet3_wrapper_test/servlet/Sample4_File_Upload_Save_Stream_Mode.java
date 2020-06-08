/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample4_File_Upload_Save_Stream_Mode.java
Created on: May 31, 2020 12:46:02 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.Sample4_File_Upload_Save_Entity;

/**
 *
 * @author https://github.com/911992
 */
@MultipartConfig
public class Sample4_File_Upload_Save_Stream_Mode extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sample4_File_Upload_Save_Entity _ent=new Sample4_File_Upload_Save_Entity();
        _ent.fill(req);
        PrintWriter _out=resp.getWriter();
        if(_ent.was_object_filling_success() == false){
            _out.printf("Error while processing the request, msg:\n%s",_ent.get_fields_fill_msg());
        }else{
            String _fname = _ent.getSaved_file_path();
            if(_fname!=null){
                _out.printf("File saved on %s",_fname);
            }else{
                if(_ent.isFolder_found() == false){
                    _out.printf("Folder could not be found!(or it's a file path)");
                }else{
                    _out.printf("File could not be saved on %s",_fname);
                }
            }
        }
        _ent.reset_fill_state();
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./sample4_file_upload_save_stream_mode.xhtml").forward(req, resp);
    }
   

    
}
