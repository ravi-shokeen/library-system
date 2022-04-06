package com.ravi.library.repository;

import com.ravi.library.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberRepository {
    private HashMap<Long, Member> members = new HashMap<>();

    public void addMember(Member member){
        members.put(member.getMemberId(), member);
    }

    public Member getMemberByMemberId(long memberId){
        return members.get(memberId);
    }

    public List<Member> getAllMembers(){
        return new ArrayList<>(members.values());
    }
}
