package com.github.hicolors.leisure.member.api;

import com.github.hicolors.leisure.common.model.expression.ColorsExpression;
import com.github.hicolors.leisure.member.model.model.member.*;
import com.github.hicolors.leisure.member.model.persistence.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "member", description = "对人员的相关操作")
@RequestMapping("member")
public interface MemberApi {

    @ApiOperation("人员 - 注册")
    @PostMapping
    Member signUp(@RequestBody MemberSignUpModel model);

    @ApiOperation("人员 - 修改用户名")
    @PatchMapping("/{id}/username")
    Member modifyUsername(@PathVariable("id") Long id, @RequestBody MemberUsernameModel model);

    @ApiOperation("人员 - 修改信息")
    @PatchMapping("/{id}")
    Member modify(@PathVariable("id") Long id, @RequestBody MemberPatchModel model);

    @ApiOperation("人员 - 修改绑定手机号信息")
    @PatchMapping("/{id}/mobile")
    Member modifyMobile(@PathVariable("id") Long id, @RequestBody MemberMobileModel model);

    @ApiOperation("人员 - 修改绑定邮箱信息")
    @PatchMapping("/{id}/email")
    Member modifyEmail(@PathVariable("id") Long id, @RequestBody MemberEmailModel model);

    @ApiOperation("人员 - 查询（分页筛选）")
    @GetMapping
    Page<Member> query(@PageableDefault(page = 0) Pageable pageable, List<ColorsExpression> filters);

    @ApiOperation("人员 - 获取人员信息通过 id")
    @GetMapping("/{id}")
    Member queryById(@PathVariable("id") Long id);

    @ApiOperation("人员 - 获取人员信息通过 mobile")
    @GetMapping("/mobile")
    Member queryByMobile(@RequestParam("mobile") String mobile);

    @ApiOperation("人员 - 获取人员信息通过 email")
    @GetMapping("/email")
    Member queryByEmail(@RequestParam("email") String email);

    @ApiOperation("人员 - 获取人员信息通过 username 和 password")
    @GetMapping("/username/password")
    Member queryByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password);

}
