/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample3_Image_File_Process_Entity.java
Created on: May 28, 2020 12:14:45 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.entity;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import wasys.lib.pojo_http_data.api.Fillable_Object_Adapter;
import wasys.lib.pojo_http_data.api.Part_Field_Stream_Mode;
import wasys.lib.pojo_http_data.api.annotations.Field_Definition;
import wasys.lib.pojo_http_data.api.annotations.No_Param;


/**
 * 
 * @author https://github.com/911992
 */
public class Sample3_Image_File_Process_Entity extends Fillable_Object_Adapter{

    @Override
    public boolean generate_result_err_msg() {
        return true;
    }
    
    
    
    @No_Param
    private static final String IMG_PARAM_NAME="img";
    
    @Field_Definition(param_name = IMG_PARAM_NAME,min_len_val = 1,max_len_val = 5242880 /*5 MB*/)
    private final OutputStream image_ref=null;

    @Override
    public Part_Field_Stream_Mode part_io_stream_mode() {
        return Part_Field_Stream_Mode.Pass_Stream;
    }
    
    @No_Param
    private BufferedImage out_img=null;
    
    @No_Param
    private String img_mime;

    public String getImg_mime() {
        if(img_mime==null){
            return "image/png";
        }
        return img_mime;
    }
    
    public String get_image_write_format(){
        try {
            return getImg_mime().split("\\/")[1];
        } catch (Exception e) {
            return "png";
        }
    }

    public BufferedImage getOut_img() {
        return out_img;
    }
    
    

    @Override
    public void part_stream(String arg_param_name, int arg_idx, InputStream arg_part_stream) {
        if(arg_param_name.equals(IMG_PARAM_NAME) && arg_idx==0){
             try {
                BufferedImage _img = ImageIO.read(arg_part_stream);
                int _w=_img.getWidth();
                int _h=_img.getHeight();
                int _arr[]=new int[_w];
                 Raster _imgr = _img.getData();
                for(int a=0;a<_h;a++){
                    //_imgr.getPixels(0, a, _w, 1, _arr);
                    _arr = _img.getRGB(0, a, _w, 1, _arr, 0, _arr.length);
                    for(int v=0;v<_arr.length;v++){
//                        if(v%2==0){
//                            continue;
//                        }
                        _arr[v] = _arr[v] ^ 0xffffffff;
                    }
                    _img.setRGB(0, a, _w, 1, _arr, 0, _arr.length);
                }
                out_img = _img;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void child_reset_state() {
        out_img=null;
    }
    
    @Override
    public boolean prepare_for_part(String arg_param_name, int arg_param_idx, String arg_part_filename, long arg_part_size, String arg_part_mime) {
        if(arg_param_name.equals(IMG_PARAM_NAME) && arg_param_idx==0){
            img_mime = arg_part_mime;
            return true;
        }
        return false;
    }

}
