package com.linkup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.linkup.user.UserProfile;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class UserProfileTest {

  private UserProfile userProfile;

  @Before
  public void setUp() {
    userProfile = new UserProfile(123456, "john_doe", "john@example.com");
  }

  // testUserProfileInitialization:
  // Checks if the user profile is initialized correctly with default values.

  @Test
  public void testUserProfileInitialization() {
    assertNotNull(userProfile);
    assertEquals(123456, userProfile.getUserId());
    assertEquals("john_doe", userProfile.getUsername());
    assertEquals("john@example.com", userProfile.getEmail());
    assertEquals("", userProfile.getFullName());
    assertEquals("", userProfile.getBio());
    assertEquals("", userProfile.getProfilePictureUrl());
    assertEquals(null, userProfile.getRegistrationDate());
    assertEquals(null, userProfile.getLastLoginDate());
  }

  // testSetFullName:
  // Tests the setFullName method to ensure that the full name of the user can
  // be set and retrieved correctly.

  @Test
  public void testSetFullName() {
    userProfile.setFullName("John Doe");
    assertEquals("John Doe", userProfile.getFullName());
  }

  // testSetBio:
  // Tests the setBio method to ensure that the user's bio can be set and
  // retrieved correctly.

  @Test
  public void testSetBio() {
    userProfile.setBio("Software Engineer");
    assertEquals("Software Engineer", userProfile.getBio());
  }

  // testSetProfilePictureUrl:
  // Tests the setProfilePictureUrl method to ensure that the profile picture
  // URL can be set and retrieved correctly.

  @Test
  public void testSetProfilePictureUrl() {
    userProfile.setProfilePictureUrl("https://example.com/profile.jpg");
    assertEquals("https://example.com/profile.jpg",
                 userProfile.getProfilePictureUrl());
  }

  // testSetLastLoginDate:
  // Tests the setLastLoginDate method to ensure that the last login date can be
  // set and retrieved correctly.

  @Test
  public void testSetLastLoginDate() {
    Date lastLoginDate = new Date();
    userProfile.setLastLoginDate(lastLoginDate);
    assertEquals(lastLoginDate, userProfile.getLastLoginDate());
  }
}