package model;

public class Announcement {
   private String title;
   protected AnnouncementCategory category;
   private String details;
   private String datePosted;

   public Announcement(String var1, AnnouncementCategory var2, String var3, String var4) {
      this.title = var1;
      this.category = var2;
      this.details = var3;
      this.datePosted = var4;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public AnnouncementCategory getCategory() {
      return this.category;
   }

   public void setCategory(AnnouncementCategory var1) {
      this.category = var1;
   }

   public String getDetails() {
      return this.details;
   }

   public void setDetails(String var1) {
      this.details = var1;
   }

   public String getDatePosted() {
      return this.datePosted;
   }

   public void setDatePosted(String var1) {
      this.datePosted = var1;
   }

   public void displayAnnouncement() {
      System.out.println("Title: " + this.title);
      System.out.println("Category: " + String.valueOf(this.category));
      System.out.println("Date Posted: " + this.datePosted);
      System.out.println("Details: " + this.details);
   }
}
