/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Sample1_Calc_Entity_Pooled.java
Created on: May 27, 2020 3:07:05 AM
    @author https://github.com/911992
 
History:
    0.2.5 (20200813)
        • Updated the val0(a), and val1(b) Field_Definition annotations to follow changes of WAsys_pojo_http_data:0.2.5
        • Changed max_len_val, and min_len_val to max_val_or_len, min_val_or_len

    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.entity;

import wasys.lib.generic_object_pool.Generic_Object_Pool_Policy;
import wasys.lib.generic_object_pool.Object_Pool;
import wasys.lib.generic_object_pool.Pool_Context;
import wasys.lib.generic_object_pool.api.Object_Factory;
import wasys.lib.generic_object_pool.api.Poolable_Object;
import wasys.lib.pojo_http_data.api.Poolable_Fillable_Object_Adapter;
import wasys.lib.pojo_http_data.api.annotations.Field_Definition;
import wasys.lib.pojo_http_data.api.annotations.No_Param;


/**
 * 
 * @author https://github.com/911992
 */
public class Sample1_Calc_Entity_Pooled extends Poolable_Fillable_Object_Adapter{

    @Field_Definition(param_name = "a",min_val_or_len = 0,max_val_or_len = 127)
    private int val0;

    @Field_Definition(param_name = "b",min_val_or_len = 0,max_val_or_len = 256)
    private int val1;

    @Override
    public boolean generate_result_err_msg() {
        return true;
    }
    
    
    
    private static final class Factory implements Object_Factory{
        @Override
        public Poolable_Object create_object() {
            return new Sample1_Calc_Entity_Pooled();
        }
    }
    
    @No_Param
    public static final Object_Pool def_pool=Pool_Context.get_insatcne().get_pool_registered_synced(new Factory(), Generic_Object_Pool_Policy.DEF_INS);

    public static Sample1_Calc_Entity_Pooled instance(){
        return (Sample1_Calc_Entity_Pooled)def_pool.get_an_instance();
    }
    
    private Sample1_Calc_Entity_Pooled() {
    }

    
            
    public int getVal0() {
        return val0;
    }

    public void setVal0(int val0) {
        this.val0 = val0;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    @Override
    protected void child_reset_state() {
        val0=0;
        val1=0;
    }
    
    

}
