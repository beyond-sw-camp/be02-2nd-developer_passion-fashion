package com.example.lonua.style.controller;

import com.example.lonua.common.BaseRes;
import com.example.lonua.style.model.entity.request.PatchUpdateStyleReq;
import com.example.lonua.style.model.entity.request.PostRegisterStyleReq;
import com.example.lonua.style.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/style")
public class StyleController {

    private final StyleService styleService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
<<<<<<< HEAD
    public ResponseEntity register(@RequestBody PostRegisterStyleReq postRegisterStyleReq) {
=======
    public ResponseEntity register(@RequestBody @Valid PostRegReq postRegReq) {
        styleService.register(postRegReq);
>>>>>>> feature/swagger

        BaseRes baseRes = styleService.register(postRegisterStyleReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        BaseRes baseRes = styleService.list();

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(@RequestBody PatchUpdateStyleReq patchUpdateStyleReq) {
        BaseRes baseRes = styleService.update(patchUpdateStyleReq);

        return ResponseEntity.ok().body(baseRes);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idx}")
    public ResponseEntity delete(@PathVariable Integer idx) {
        BaseRes baseRes = styleService.delete(idx);

        return ResponseEntity.ok().body(baseRes);
    }

}
