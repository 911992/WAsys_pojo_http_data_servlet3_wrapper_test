/*
 * Copyright (c) 2020, https://github.com/911992 All rights reserved.
 * License BSD 3-Clause (https://opensource.org/licenses/BSD-3-Clause)
 */

/*
WAsys_pojo_http_data_servlet3_wrapper_test
File: Servlet_Ctx_Listener.java
Created on: May 26, 2020 6:08:35 AM
    @author https://github.com/911992
 
History:
    initial version: 0.1(20200526)
*/

package wasys.lib.pojo_http_data.servlet3_wrapper_test.delegate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler;
import wasys.lib.pojo_http_data.servlet3_wrapper.Servlet_Request_Data_Handler_Servlet_Ctx_Listener;


/**
 * Please use {@link Servlet_Request_Data_Handler_Servlet_Ctx_Listener} class instead.
 * @author https://github.com/911992
 */
public class Servlet_Ctx_Listener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.printf("Initializing default pool for Servlet_Request_Data_Handler\n");
        Servlet_Request_Data_Handler.init_default_pool();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.printf("Destroying the default pool for Servlet_Request_Data_Handler\n");
        Servlet_Request_Data_Handler.shutdown_default_pool();
    }
    
}
