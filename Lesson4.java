import java.util.*;

public class Lesson4 {
  public static void main(String[] args) {
    
  }
}

class Book implements Comparable<Book>, Cloneable {
  private String title;
  private Date publishDate;
  private String comment;

  public String getTitle() {
    return this.title;
  }
  public Date getPablishDate() {
    return this.publishDate;
  }
  public String getComment() {
    return this.comment;
  }

  public boolean equals(Object obj) {
    if( obj == this ) { return true;}
    if( obj == null ) { return false;}
    if( !(obj instanceof Book) ) { return false;}
    Book b = (Book) obj;
    if(!publishDate.equals(b.publishDate)) {
      return false;
    }
    if(!title.equals(b.title)) {
      return false;
    }
    return true;
  }
  public int hashCode() {
    int result = 37;
    result = result * 31 + title.hashCode();
    result = result * 31 + publishDate.hashCode();
    return result;
  }

  public int compareTo(Book obj) {
    return this.publishDate.compareTo(obj.publishDate);
  }

  public Book clone() {
    Book result = new Book();
    result.title = this.title;
    result.publishDate = (Date) this.publishDate.clone();
    result.comment = this.comment;
    return result;
  }
}