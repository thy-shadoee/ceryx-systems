package model;

public class DeadlineAnnouncement extends Announcement {
   private String subject;
   private String dueDate;

   public DeadlineAnnouncement(String var1, String var2, String var3, String var4, String var5) {
      super(var1, AnnouncementCategory.DEADLINE, var2, var3);
      this.subject = var4;
      this.dueDate = var5;
   }

   public String getSubject() {
      return this.subject;
   }

   public String getDueDate() {
      return this.dueDate;
   }
   @Override 
   public void displayAnnouncement() {
      super.displayAnnouncement();
      System.out.println("Subject: " + this.subject);
      System.out.println("Due Date: " + this.dueDate);
   }
}