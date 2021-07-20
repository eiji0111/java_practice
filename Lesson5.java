public class Lesson5 {
  public static void main(String[] args) {
    
  }
}

// 鍵の種類
enum Keytype {
  PADLOCK, BUTTON, DIAL, FINGER
}
// インスタンスの型は未定
class StrongBox<E> {
  private E data;
  private Keytype keytype;
  private long count;

  // コンストラクタで鍵の種類を取得
  public StrongBox(Keytype keytype) {
    this.keytype = keytype;
  }

  public void put(E d) { this.data = d; }

  public E get() {
    this.count ++;
    switch(this.keytype) {
      case PADLOCK:
        if (count < 1024) return null;
        break;
      case BUTTON:
        if (count < 10000) return null;
        break;
      case DIAL:
        if (count < 30000) return null;
        break;
      case FINGER:
        if (count < 1000000) return null;
        break;
    }
    this.count = 0;
    return this.data;
  }
}