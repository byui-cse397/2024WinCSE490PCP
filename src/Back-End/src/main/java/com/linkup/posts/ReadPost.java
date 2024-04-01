package com.linkup.posts;

import com.linkup.database.dbActions.ops.ReadDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class ReadPost extends ReadDBAction {
  private Integer postId;

  @Override
  public int getID() {
    return postId;
  }

  public ReadPost(Integer postId) { this.postId = postId; }

  @Override
  public Table getTable() {
    return Table.POST;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullPostIDCheck();
    return true;
  }

  public void nullPostIDCheck() throws FrontEndUsageException {
    if (postId == null | postId == 0) {
      throw new FrontEndUsageException(
          "PostId cannot be null in post reading.") {

      };
    }
  }
}
