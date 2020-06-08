/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample0_Login_Entity.java
Created on: May 26, 2020 4:55:51 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.entity;

import wasys.lib.pojo_http_data.api.Fillable_Object_Adapter;
import wasys.lib.pojo_http_data.api.annotations.Field_Definition;


/**
 * 
 * @author https://github.com/911992
 */
public class Sample0_Login_Entity extends Fillable_Object_Adapter{
    @Field_Definition(max_len_val = 320)
    private String email;
    
    @Field_Definition(param_name = "pass",min_len_val = 4)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean generate_result_err_msg() {
        return true;
    }
    
    
    @Override
    protected void child_reset_state() {
        super.child_reset_state(); 
        setEmail(null);
        setPassword(null);
    }
    
    
}
