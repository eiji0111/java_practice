import org.apache.commons.lang3.builder.*;

public class Bank {
  String name;
  String address;

  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  public Bank(String name) {
    this.name = name;
  }
}
