public class Counter {

  private long count = 0;

  public void add(long i) {
    System.out.println("足し算します");
    synchronized (this) { //内部にsysnchronizedを埋め込む
      this.count += i;
    }
  }
  public synchronized void mul(long i) { // メソッド名に定義するのもアリ
    System.out.println("掛け算します");
    this.count *= i;
  }
}
