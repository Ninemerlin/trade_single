package com.dlut.tradesys.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserFormDTO {
    private String nickname;
    private String intro;
    private String gender;
}
