package com.example.lonua.branch.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/com/example/lonua/branch/model/request/DeleteRemoveReq.java
@ApiModel(description = "가게 데이터를 삭제 요청받을 때 쓰는 DTO",value = "A Branch DeleteRemoveReqDTO")
public class DeleteRemoveReq {

    @Min(value = 1)
    @ApiModelProperty(value = "삭제할 가게의 idx",name = "가게의 idx")
=======
public class PatchBranchUpdateRes {
>>>>>>> develop:src/main/java/com/example/lonua/branch/model/response/PatchBranchUpdateRes.java
    private Integer branchIdx;
    private String branchName;
    private String branchAddress;
    private Integer brandIdx;
}
