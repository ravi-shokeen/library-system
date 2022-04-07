package com.ravi.library.controller;

import com.ravi.library.model.Member;
import com.ravi.library.model.RequestModel;
import com.ravi.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @RequestMapping(value="/loanbook", method = RequestMethod.POST)
    public ResponseEntity<String> loanBookToMember(@RequestBody RequestModel requestModel){
        String responseMessage;
        try{
            if(requestModel.getMemberId() == 0 || requestModel.getTitle() == null || requestModel.getTitle().isEmpty())
                return new ResponseEntity<>("Please provide all mandatory request parameters.", HttpStatus.BAD_REQUEST);

            responseMessage  = memberService.loanBook(requestModel.getMemberId(), requestModel.getTitle());
        }
        catch(Exception e){
            responseMessage = e.getMessage();
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping(value = "/returnbook", method = RequestMethod.POST)
    public ResponseEntity<String> returnBookToLibrary(@RequestBody RequestModel requestModel){
        String responseMessage;
        try{
            if(requestModel.getMemberId() == 0 || requestModel.getTitle() == null || requestModel.getTitle().isEmpty())
                return new ResponseEntity<>("Please provide all mandatory request parameters.", HttpStatus.BAD_REQUEST);

            responseMessage = memberService.returnBook(requestModel.getMemberId(), requestModel.getTitle());
        }
        catch(Exception e){
            responseMessage = e.getMessage();
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
