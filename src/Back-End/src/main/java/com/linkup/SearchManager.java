package com.linkup;

import com.linkup.communities.FindCommunity;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.FindUser;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.common.XMLParsing.XMLNode;

public class SearchManager {
    private String user;
    private String community;

    public SearchManager(String user, String community) {
        this.user = user;
        this.community = community;
    }

    public void search() throws FrontEndUsageException {
    	FindUser findUser = new FindUser(this.user);
    	FindCommunity findCommunity = new FindCommunity(this.community);
    	
    	XMLNode<XMLParent> parentNode = findUser.performDBAction();
        XMLNode<XMLParent> parentNode1 = findCommunity.performDBAction();
        System.out.println(parentNode.getValue());
        System.out.println(parentNode1.getValue());
    }
}
