package com.zgs.shell;

import com.alibaba.fastjson.JSONObject;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Smily on 2017/8/25.
 */
@Controller
public class LinuxSSHController {
    private static LinuxSSHShell linuxSSHShell;
    @RequestMapping("/webshell")
    public String webshell(HttpServletRequest request){
        return  "/webshell/run";
    }

    @PostMapping("/ssh/init")
    @ResponseBody
    public JSONObject initSsh(HttpServletRequest request){
        JSONObject object=new JSONObject();
        String host=request.getParameter("host");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        linuxSSHShell=LinuxSSHShell.getLinuxSSHShell();
        Session session=linuxSSHShell.getSession(host,username, password,true);
        linuxSSHShell.openShell(session);
        object.put("result","success");
        object.put("execResult",linuxSSHShell.getExecResult());
        return  object;
    }

    @PostMapping("/ssh/exec")
    @ResponseBody
    public JSONObject getSsh(HttpServletRequest request){
        String cmd=request.getParameter("cmd");
        JSONObject object=new JSONObject();
        String result=linuxSSHShell.execCommand(cmd);
//        System.out.println(result);
        object.put("result","success");
        object.put("execResult",linuxSSHShell.getExecResult());
        return  object;
    }
}
