package cn.boot1112.sdemo2.controller;


import cn.boot1112.sdemo2.Mapper.UserMapper;
import cn.boot1112.sdemo2.entity.User;
import cn.boot1112.sdemo2.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

//@Controller
//@ResponseBody//告诉SpringBoot这是一个返回json的控制器
@RestController//告诉SpringBoot这是一个返回json的控制器+告诉SpringBoot这是一个控制器
public class UserController {
    @Autowired//告诉SpringBoot自动注入
    private UserMapper userMapper;//创建UserMapper对象
    @RequestMapping("/login")///映射路径
    public JsonResult login(String username, String password){

        JsonResult jsonResult = new JsonResult();//创建JsonResult对象
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
        return jsonResult;//返回jsonResult对象
    }
    @RequestMapping("/register")
    public JsonResult register(String username, String password){
        JsonResult jsonResult = new JsonResult();
        User user = userMapper.findbyusername(username);
        if(user == null){
            int result = userMapper.addUser(new User(username,password));
            if(result > 0){
                jsonResult.setState(1);
            }else{
                jsonResult.setState(2);
            }
        }else{
            jsonResult.setState(3);
        }
        return jsonResult;
    }
}
