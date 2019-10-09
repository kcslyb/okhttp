package com.example.example.trace;

import java.io.Serializable;

/**
 * @author kcs
 * @date 2019-10-08 20:48
 **/
public class LoginDto implements Serializable {

    private String encryptionPsw;
    private String logisticsCentreId;
    private String orgCode;
    private String type;
    private String username;
    private String validateCode;

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
}
