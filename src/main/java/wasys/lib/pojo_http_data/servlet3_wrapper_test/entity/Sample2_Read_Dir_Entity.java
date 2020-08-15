/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample2_Read_Dir_Entity.java
Created on: May 27, 2020 4:35:15 AM
    @author https://github.com/911992
 
History:
    0.2.5 (20200813)
        • Updated the path Field_Definition annotation to follow changes of WAsys_pojo_http_data:0.2.5
        • Changed max_len_val, and min_len_val to max_val_or_len, min_val_or_len

    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.entity;

import wasys.lib.pojo_http_data.api.Fillable_Object_Adapter;
import wasys.lib.pojo_http_data.api.annotations.Field_Definition;


/**
 * 
 * @author https://github.com/911992
 */
public class Sample2_Read_Dir_Entity extends Fillable_Object_Adapter{
    @Field_Definition(nullable = true,min_val_or_len = 1,max_val_or_len = 255)
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean generate_result_err_msg() {
        return true;
    }

    @Override
    protected void child_reset_state() {
        setPath(null);
    }
    
}
