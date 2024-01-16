package com.example.lonua.branch.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
<<<<<<< HEAD:src/main/java/com/example/lonua/branch/model/request/GetReadReq.java
@ApiModel(description = "가게 1개의 정보를 이름을 통해 가져오는 요청할 때 쓰는 DTO", value = "A Branch ReadRequest DTO")
public class GetReadReq {
    @Length(max = 50)
    @ApiModelProperty(value = "조회할 가게의 이름",name = "가게 이름")
=======
public class PostBranchRegisterRes {
    private Integer branchIdx;
>>>>>>> develop:src/main/java/com/example/lonua/branch/model/response/PostBranchRegisterRes.java
    private String branchName;
    private String branchAddress;
    private Integer brandIdx;
}
