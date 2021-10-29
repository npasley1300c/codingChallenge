package com.pasley.lumencodingchallenge.family.tree;

import com.pasley.lumencodingchallenge.family.member.FamilyMember;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTreeImplTest {

    @Test
    void populateFamilyTree() {
        FamilyTreeBuilderImpl familyTree = new FamilyTreeBuilderImpl();
        String input = "null,0,grandpa|0,1,son|0,2,daughter|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid";
        boolean actual = familyTree.populateFamilyTree(input);
        assertTrue(actual);
    }
}