public enum Role {
  STUDENT(1), OFFICER(2), ADMIN(3);

  private final int level;

  Role(int level) {
    this.level = level;
  }

  public boolean hasAtLeast(Role other) {
    return this.level >= other.level;
  }
}
