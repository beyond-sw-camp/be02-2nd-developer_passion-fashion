package com.example.lonua.category.controller;

import com.example.lonua.category.model.request.PostCategoryReq;
import com.example.lonua.category.service.CategoryService;
<<<<<<< HEAD
import com.example.lonua.common.BaseRes;
=======
import com.example.lonua.config.BaseRes;
import io.swagger.annotations.ApiOperation;
>>>>>>> feature/swagger
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "카테고리 등록하기")
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity register(@RequestBody @Valid PostCategoryReq postCategoryReq) {
        BaseRes baseRes = categoryService.register(postCategoryReq);

        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "카테고리 정보 수정하기")
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody @Valid PostCategoryReq postCategoryReq) {
        BaseRes baseRes = categoryService.update(postCategoryReq);

        return ResponseEntity.ok().body(baseRes);
    }
    @ApiOperation(value = "카테고리 삭제하기")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable @Min(value = 1) Integer idx) {
        BaseRes baseRes = categoryService.delete(idx);

        return ResponseEntity.ok().body(baseRes);
    }
}
