/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample4_File_Upload_Save_Entity.java
Created on: May 30, 2020 11:42:13 PM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.entity;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import wasys.lib.pojo_http_data.api.Fillable_Object_Adapter;
import wasys.lib.pojo_http_data.api.Part_Field_Stream_Mode;
import wasys.lib.pojo_http_data.api.annotations.Field_Definition;
import wasys.lib.pojo_http_data.api.annotations.No_Param;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler;


/**
 * 
 * @author https://github.com/911992
 */
public class Sample4_File_Upload_Save_Entity extends Fillable_Object_Adapter{
    
    @No_Param
    private static final String FILE_PARAM = "file";
    
    @Field_Definition(min_len_val = 1)
    private String dir;
    
    @Field_Definition(min_len_val = 1,param_name = FILE_PARAM)
    private FileOutputStream file;
    
    @No_Param
    private String saved_file_path;
    
    @No_Param
    private boolean folder_found;

    public boolean isFolder_found() {
        return folder_found;
    }
    
    

    public String getSaved_file_path() {
        return saved_file_path;
    }

    public void setSaved_file_path(String saved_file_path) {
        this.saved_file_path = saved_file_path;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public FileOutputStream getFile() {
        return file;
    }

    @Override
    public boolean generate_result_err_msg() {
        return true;
    }

    public void setFile(FileOutputStream file) {
        this.file = file;
    }
    
    public void fill(HttpServletRequest arg_req){
        Servlet_Request_Data_Handler.fill(arg_req, this);
    }

    @Override
    public Part_Field_Stream_Mode part_io_stream_mode() {
        return Part_Field_Stream_Mode.Stream_To_Field;
    }

    @Override
    public boolean prepare_for_part(String arg_param_name, int arg_param_idx, String arg_part_filename, long arg_part_size, String arg_part_mime) {
        if(FILE_PARAM.equals(arg_param_name)==false || arg_param_idx!=0){
            return false;
        }
        String _dir = getDir();
        if(_dir==null || _dir.trim().isEmpty()){
            return false;
        }
        File _dirf = new File(_dir);
        folder_found=_dirf.isDirectory();
        if(folder_found==false){
            return false;
        }
        String _fname;
        if(arg_part_filename!=null){
            _fname=arg_part_filename;
        }else{
            _fname="unknown";
        }
        _fname=String.format("%x_%s",System.nanoTime(), _fname);
        File _f=new File(_dirf,_fname);
        try {
            if(_f.createNewFile()==false){
                //System.out.println("Wow!, wt?");
                return false;
            }
            setFile(new FileOutputStream(_f));
            setSaved_file_path(_fname);
        } catch (Exception e) {e.printStackTrace();
            setSaved_file_path(null);
            return false;
        }
        return true;
    }

    @Override
    public void part_streaming_done(String arg_param_name, int arg_param_idx, boolean arg_success_op) {
        if(FILE_PARAM.equals(arg_param_name) && arg_param_idx==0 && file!=null){
            try {
                file.close();
            } catch (Exception e) {
            }
        }
    }
    
    

    @Override
    protected void child_reset_state() {
        dir= null;
        saved_file_path=null;
        folder_found = false;
        try {
            file.close();
        } catch (Exception e) {
        }
        file =null;
    }
    
}
