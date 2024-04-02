package com.linkup.posts;

import com.linkup.database.dbActions.ops.CreateDBAction;
import com.linkup.database.dbActions.ops.UpdateDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdatePost extends UpdateDBAction {
  private String Content_text;
  private Integer Accounts_id;
  private String Post_time;
  private Integer Community_id;
  private Integer Id;

  @Override
  public int getID() {
    return Id;
  }

  public UpdatePost(Integer postId, String postText, Integer accountId,
                    Integer communityId) {
    Content_text = postText;
    Accounts_id = accountId;
    Community_id = communityId;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    Post_time = now.format(formatter).toString();
    Id = postId;
  }

  @Override
  public Table getTable() {
    return Table.POST;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullPostTextCheck();
    nullAccountIDCheck();
    nullCommunityIDCheck();
    return true;
  }

  public void nullPostTextCheck() throws FrontEndUsageException {
    if (Content_text == null | Content_text.length() == 0) {
      throw new FrontEndUsageException("Post text cannot be null.") {

      };
    }
  }

  public void nullAccountIDCheck() throws FrontEndUsageException {
    if (Accounts_id == null | Accounts_id == 0) {
      throw new FrontEndUsageException(
          "Account Id cannot be null in post creation.") {

      };
    }
  }

  public void nullCommunityIDCheck() throws FrontEndUsageException {
    if (Community_id == null | Community_id == 0) {
      throw new FrontEndUsageException(
          "Community Id cannot be null in post creation.") {

      };
    }
  }
}
