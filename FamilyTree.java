package com.pasley.lumencodingchallenge.family.tree;

import com.pasley.lumencodingchallenge.family.member.FamilyMember;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class FamilyTree<T> {

    private FamilyMember root;

    public FamilyTree(int key) {
        root = new FamilyMember(key);
    }

    public FamilyTree() {
        root = new FamilyMember();
    }

    public void add(int nodeId, FamilyMember current, int treeDepth) {
        root = addNewMembers(current, nodeId, treeDepth);
    }

    private FamilyMember addNewMembers(FamilyMember current, int nodeId, int treeDepth) {
        if (current.getParentId().equalsIgnoreCase("null")) {
            root = current;
        }

        if (nodeId == treeDepth) {
            return new FamilyMember();
        }

        if (nodeId < treeDepth) {
            root.setLeft(addNewMembers(current, nodeId, treeDepth-1));
        } else if (nodeId > treeDepth) {
            root.setRight(addNewMembers(current, nodeId, treeDepth-1));
        } else {
            return current;
        }

        return current;
    }




}
