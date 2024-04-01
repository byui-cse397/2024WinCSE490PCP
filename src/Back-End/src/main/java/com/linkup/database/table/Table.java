package com.linkup.database.table;
import java.util.ArrayList;

public enum Table {
  ACCOUNT {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("username");
      list.add("password_hash");
      return list;
    }
  },
  POST {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("content_text");
      list.add("accounts_id");
      list.add("post_time");
      list.add("community_id");
      return list;
    }
  },
  DEPARTING {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("location_text");
      list.add("post_id");
      return list;
    }
  },
  ARRIVING {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("location_text");
      list.add("post_id");
      return list;
    }
  },
  FORUMS {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("forum_name");
      list.add("parent_account_id");
      return list;
    }
  },
  COMMUNITY {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("community_name");
      list.add("parent_account_id");
      return list;
    }
  },
  COMMENTS {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("comment_text");
      list.add("post_id");
      return list;
    }
  },
  MESSAGES {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("message_content");
      list.add("message_time");
      list.add("sender_id");
      list.add("receiver_id");
      return list;
    }
  };

  public abstract ArrayList<String> getFields();

  @Override
  public String toString() {
    return this.name();
  }
}
