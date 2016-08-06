

package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import org.openhmis.dto.UserDTO;


@XmlRootElement
public class AccountDTO extends BaseDTO {
    private String externalId;
    private UserDTO user;

    public AccountDTO() {}

    @JsonProperty
    public String getExternalId() {
        return this.externalId;
    }

    @JsonProperty
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty
    public UserDTO getUser() {
        return this.user;
    }

    @JsonProperty
    public void setUser(UserDTO user) {
        this.user = user;
    }
    
}
