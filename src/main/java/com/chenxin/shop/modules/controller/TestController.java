package com.chenxin.shop.modules.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.chenxin.shop.common.CommonPage;
import com.chenxin.shop.enums.BusinessExceptionEnum;
import com.chenxin.shop.exception.GlobalException;
import com.chenxin.shop.modules.entity.Users;
import com.chenxin.shop.modules.service.TestService;

import java.util.List;

/**
 * @Description:
 * @title: TestController
 * @Author Star_Chen
 * @Date: 2021/12/23 10:55
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * @Date: 2021/12/24 9:05
     * @Author: Star_Chen
     * @Description: 测试接口demo
     * @Return: {@link null}
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET/*, consumes = "application/json"*/)
    public List<Users> test() {

        List<Users> userList = testService.getUserList();
        return userList;
    }

    /**
     * @Date: 2022/4/8 15:36
     * @Author: Star_Chen
     * @Param: * @param null
     * @Description: 业务异常处理demo
     */
    @RequestMapping(value = "/testException", method = RequestMethod.GET/*, consumes = "application/json"*/)
    public List<Users> testException(String id) {

        if (StringUtils.isEmpty(id)) {
            throw new GlobalException(BusinessExceptionEnum.CONFIG_NOT_EXIST);
        }

        List<Users> userList = testService.getUserList();
        if (userList.size() == 0 || userList == null) {
            throw new GlobalException(BusinessExceptionEnum.DATA_IS_NOLL);
        }

        return userList;
    }


    /**
     * @Date: 2022/4/8 15:36
     * @Author: Star_Chen
     * @Param: * @param null
     * @Description: 形参传递校验demo
     * 注意区分@Validated  和 @RequestBody
     */
    @RequestMapping(value = "/testValidated", method = RequestMethod.POST/*, consumes = "application/json"*/)
    public List<Users> testValidated(@Validated @RequestBody Users users) {

        if (StringUtils.isEmpty(users.getName())) {
            throw new GlobalException(BusinessExceptionEnum.PARAM_IS_NULL);
        }

        List<Users> userList = testService.getUserList();
        if (userList.size() == 0 || userList == null) {
            throw new GlobalException(BusinessExceptionEnum.DATA_IS_NOLL);
        }

        return userList;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<Users> list(@RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<Users> userList = testService.getUserPageList(keyword, pageNum, pageSize);
        return CommonPage.restPage(userList);
    }

  
    /**
     * @Date: 2022/4/22 22:50
     * @Description: 
     * @param keyword : 
     * @param pageNum : 
     * @param pageSize : 
     * @Return:  * @return : com.chenxin.shop.common.CommonPage<com.chenxin.shop.modules.entity.Users>
     */
    @RequestMapping(value = "/xmlList", method = RequestMethod.GET)
    public CommonPage<Users> xmlList(@RequestParam(value = "keyword", required = false) String keyword,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<Users> userList = testService.getXmlUserPageList(keyword, pageNum, pageSize);
        return CommonPage.restPage(userList);
    }


    @PostMapping("/insert")
    public Boolean insert(@RequestBody @Validated Users users){

        boolean save = testService.save(users);
        return save;
    }
}
