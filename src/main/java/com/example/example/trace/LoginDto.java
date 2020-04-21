package com.example.example.trace;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author kcs
 * @date 2019-10-08 20:48
 **/
public class LoginDto implements Serializable {

    private String encryptionPsw;
    private String password;
    private String logisticsCentreId;
    private String orgCode;
    private String type;
    private String username;
    private String validateCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptionPsw() {
        return encryptionPsw;
    }

    public void setEncryptionPsw(String encryptionPsw) {
        this.encryptionPsw = encryptionPsw;
    }

    public String getLogisticsCentreId() {
        return logisticsCentreId;
    }

    public void setLogisticsCentreId(String logisticsCentreId) {
        this.logisticsCentreId = logisticsCentreId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("2020-04-10 15:41:18","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
