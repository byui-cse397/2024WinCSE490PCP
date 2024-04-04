package com.linkup.posts;

import com.linkup.database.dbActions.ops.DeleteDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class DeletePost extends DeleteDBAction {
  private Integer postId;

  @Override
  public int getID() {
    return postId;
  }

  public DeletePost(Integer postId) { this.postId = postId; }

  @Override
  public Table getTable() {
    return Table.POST;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullPostIDCheck();
    emptyPostIDCheck();
    return true;
  }

  public void nullPostIDCheck() throws FrontEndUsageException {
    if (postId == null) {
      throw new FrontEndUsageException(
          "PostId cannot be null in post deletion.") {

      };
    }
  }

  public void emptyPostIDCheck() throws FrontEndUsageException {
    if (postId < 1) {
      throw new FrontEndUsageException(
          "PostId cannot be less than 1 in post deletion.") {

      };
    }
  }
}
