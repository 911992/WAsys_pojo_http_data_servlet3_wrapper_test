/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample3_File_Upload_Handle_Image_Pass_Stream.java
Created on: May 27, 2020 11:27:47 PM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler;
import wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.Sample3_Image_File_Process_Entity;

/**
 *
 * @author https://github.com/911992
 */
@MultipartConfig
public class Sample3_File_Upload_Handle_Image_Pass_Stream extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Sample3_Image_File_Process_Entity _ent=new Sample3_Image_File_Process_Entity();
            Servlet_Request_Data_Handler.fill(req, _ent);
            BufferedImage _img=_ent.getOut_img();
            if(_img!=null){
                resp.setContentType(_ent.getImg_mime());
                ImageIO.write(_img, _ent.get_image_write_format(), resp.getOutputStream());
            }else{
                PrintWriter _out=resp.getWriter();
                if(!_ent.was_object_filling_success()){
                    _out.printf("Probably missed provided image file(or invalid/bad file)! err:\n%s",_ent.get_fields_fill_msg());
                }else{
                    _out.print("unexpected exception while processing your image file! try again!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./sample3_file_upload_handle_image_pass_stream.xhtml").forward(req, resp);
    }
   
}
