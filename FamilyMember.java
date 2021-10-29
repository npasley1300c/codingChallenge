package com.pasley.lumencodingchallenge.family.member;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FamilyMember {

    private String parentId;
    private int nodeId;
    private String nodeName;
    private FamilyMember left;
    private FamilyMember right;
    private FamilyMember parent;

    public FamilyMember(int familyMemberNode) {
        nodeId = familyMemberNode;
        left = null;
        right = null;
        parent = null;
    }

    public FamilyMember() {}

}
