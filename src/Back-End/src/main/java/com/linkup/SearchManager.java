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

    public XMLNode<XMLParent> search(FILTER operation) throws FrontEndUsageException {
    	if(operation == FILTER.USER){
        	FindUser findUser = new FindUser(this.user);
        	return findUser.performDBAction();
    	}else {
        	FindCommunity findCommunity = new FindCommunity(this.community);
        	return findCommunity.performDBAction();
    	}

    }
    
    static enum FILTER {
        USER,
        COMMUNITY,
      }
}

