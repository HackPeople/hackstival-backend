package com.example.hackstival.user.dto;

import com.example.hackstival.common.domain.Address;
import com.example.hackstival.request.domain.RequestType;
import com.example.hackstival.user.domain.SexType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "유저 기본 DTO")
public class UserDTO {
    private Long id;
      // persnal info
    @Schema(description = "회원 아이디", defaultValue = "juju0v0")
    private String userId;
    @Schema(description = "회원 비번", defaultValue = "1234")
    private String userPw;
    @Schema(description = "회원 이름", defaultValue = "김숙자")
    private String userName;
    @Schema(description = "회원 전화번호", defaultValue = "01012341234")
    private String userPhoneNumber;

    // social info
    @Schema(description = "프로필사진주소", defaultValue = "https://i.namu.wiki/i/2u9xTyPEH2gTYyb07v9YYvJxF3wlX5-z3iyqN1a2yR_iRIGkM7gTNx23OBP8gQIdJinbkMUx4YbfXNOjiVBsvg.webp")
    private String profileImage;
    // 주소
    @Schema(description = "주소")
    private Address address;
    // 성별
    @Schema(description = "성별")
    private SexType sexType;
    @Schema(description = "흥미영역")
    private RequestType interestedRequestType;
}
