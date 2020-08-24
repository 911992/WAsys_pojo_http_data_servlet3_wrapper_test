# WAsys_pojo_http_data_servlet3_wrapper_test Release Note

repo: https://github.com/911992/WAsys_pojo_http_data_servlet3_wrapper_test  
Author: [911992](https://github.com/911992)  
*(NOTE: following list carries mentionable(not all) changes. For detailed changes, check source code(s))*  

**0.3.1** (Aug 24, 2020)

0. `(－‸ლ)` <s>becasue of `WAsys_pojo_http_data` version `0.2.9`</s>
1. `Source_Code::Sample1_Calc_Entity_Pooled`
    * Integrated with `WAsys_simple_generic_object_pool 0.5.1` API change
    * Changed `wasys.lib.generic_object_pool.api.Object_Factory` to `wasys.lib.java_type_util.reflect.type_sig.Object_Factory`
    * Removed redundant `wasys.lib.generic_object_pool.api.Poolable_Object` import
2. Repo
    * Updated `README.md`
        * Updated the maven `WAsys_pojo_http_data_servlet3_wrapper` dependency to `0.3.1`
    * Updated `pom.xml` file
        * Artifact to version `0.3.1`
        * Updated the dependency of `WAsys_pojo_http_data_servlet3_wrapper` to `0.3.1`

<hr/>

**0.2.5** (Aug 13, 2020)
0. Applied changes to make it compatible to dependent `WAsys_pojo_http_data_servlet3_wrapper:0.2.5`, and `WAsys_pojo_http_data:0.2.5`
1. `Source_Code::all-entities` (`wasys.lib.pojo_http_data.servlet3_wrapper_test.entity.*`)
    * Updated all fields were annotated by Field_Definition annotation to follow changes of `WAsys_pojo_http_data:0.2.5`
    * Changed `max_len_val`, and `min_len_val` to `max_val_or_len`, `min_val_or_len`
1. Repo
    * Updated `README.md`
        * Updated the maven `WAsys_pojo_http_data_servlet3_wrapper` dependency to `0.2.5`
    * Updated `pom.xml`
        * Updaring the artifact to version `0.2.5`
        * Updating the `WAsys_pojo_http_data_servlet3_wrapper` dependency version to `0.2.5`

<hr/>

**Initial Release 0.1** (May 26, 2020)