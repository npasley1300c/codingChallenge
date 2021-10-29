package com.pasley.lumencodingchallenge.family.tree;


import com.pasley.lumencodingchallenge.FamilyTreeBuilder;
import com.pasley.lumencodingchallenge.family.member.FamilyMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FamilyTreeBuilderImpl implements FamilyTreeBuilder {


    @Override
    public boolean populateFamilyTree(String input) {
        //Parse the pipe delimited input string and place each element into an object (FamilyMember)
        //Insert familyMemberNodes into a FamilyTree data structure ordered by nodeId
        //Use a recursive method to add to FamilyMembers to the tree

        List<String> familyMemberList = new ArrayList<>();
        String [] members = input.split("\\|", -1);

        familyMemberList.addAll(Arrays.asList(members));

        for (String f : familyMemberList) {
            var nodeId = Integer.parseInt(f.substring(f.indexOf(",") + 1, f.lastIndexOf(",")));
            var familyMember = new FamilyMember(nodeId);
            familyMember.setParentId(f.substring(0, f.indexOf(",")));
            familyMember.setNodeName(f.substring(f.lastIndexOf(",") + 1));
            familyMember.setNodeId(nodeId);

            FamilyTree<FamilyMember> tree = new FamilyTree<>(nodeId);

            tree.add(nodeId, familyMember, familyMemberList.size());

        }

        return true;
    }


}
