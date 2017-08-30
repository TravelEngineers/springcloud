package com.zgs.shell;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by Smily on 2017/8/25.
 */
public class LinuxSSHShell {
    private static LinuxSSHShell linuxSSHShell;
    private String host;
    private String username;
    private String password;
    private Session session;
    private BufferedReader mBufferedReader;
    private DataOutputStream mDataOutputStream;
    private Channel mChannel;
    private String execResult="";
    private LinuxSSHShell() {
    }
    public static LinuxSSHShell getLinuxSSHShell() {
        if (linuxSSHShell == null) {
            linuxSSHShell = new LinuxSSHShell();
        }
        return linuxSSHShell;
    }
    public Session getSession(String host,String username,String password,boolean refresh){
        if(refresh){
           initSession(host,username,password);
        }else {
            if(this.session==null){
                initSession(host,username,password);
            }
        }
        return session;
    }

    /**
     * 打开shell模式
     * @param session
     */
    public void openShell(Session session){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(session==null&&!session.isConnected()){
                    System.out.println("session is error");
                }else{
                    try{
                        mChannel = session.openChannel("shell");
                        mChannel.connect();
                        mBufferedReader = new BufferedReader(new InputStreamReader(mChannel.getInputStream(), Charset.forName("UTF-8")));
                        mDataOutputStream = new DataOutputStream(mChannel.getOutputStream());
                        String resultLine;
                        while ((resultLine = mBufferedReader.readLine()) != null) {
//                            System.out.println("resultLine:"+resultLine);
                            execResult=execResult+resultLine+" <br>";
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    /**
     * 执行命令
     * @param command
     */
    public String execCommand(String command) {
        execResult="";
        if (mDataOutputStream != null) {
            try {
                if(command.trim().equals("ll")||command.trim().equals("ls")){
                    mDataOutputStream.writeBytes(command +" --color=never" +"\r\n");
                }else{
                    mDataOutputStream.writeBytes(command +"\r\n");
                }
                mDataOutputStream.flush();
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(" DataOutputStream channel is empty !");
        }
        return execResult;
    }

    /**
     * 断开连接
     */
    public synchronized void disconnect() {
        try {
            //disconnect channel
            if (mChannel != null)
                mChannel.disconnect();
            //close streams
            mDataOutputStream.flush();
            mDataOutputStream.close();
            mBufferedReader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取执行结果
     * @return
     */
    public String getExecResult(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.execResult;
    }
    /**
     * 初始化Session
     * @param host
     * @param username
     * @param password
     */
    private void initSession(String host,String username,String password){
        try{
            JSch jsch = new JSch();
            this.session = jsch.getSession(username,host, 22); // port 22
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking","no");
            session.connect();
        }catch (Exception e){
            System.out.println(" session init error !");
            e.printStackTrace();
        }
    }
}
