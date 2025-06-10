package cn.boot1112.sdemo2.controller;


import cn.boot1112.sdemo2.Mapper.UserMapper;
import cn.boot1112.sdemo2.entity.User;
import cn.boot1112.sdemo2.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永无BUG     永不修改                  //
////////////////////////////////////////////////////////////////////


/************
  * 路径/login
  * 参数：username,password
  * 返回：JsonResult
  * 业务逻辑：用户是否为null:
  *         是：state=2
  *         否：用户名正确
  *              判断查询结果的密码和参数密码是否一致
  *              是：state=1
  *              否：state=3
 *****************/

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/login")
    public JsonResult login(String username, String password){

        JsonResult jsonResult = new JsonResult();
        User user = userMapper.findbyusername(username);
        if(user == null){
            jsonResult.setState(2);
        }else{
            if(user.getPassword().equals(password)) {
                jsonResult.setState(1);
            }else{
                jsonResult.setState(3);
            }
        }
        return jsonResult;
    }

}
