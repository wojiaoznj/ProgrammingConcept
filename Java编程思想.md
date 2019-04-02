#                                                                                                                                                                                                                                                                          Java编程思想
##1.数据存储
    1. 寄存器：最快的存储区，由编译器根据需求进行分配，我们在程序中无法控制. 
     2. 栈：
      物理位置：随机存储器（Random Access Memory）
      优点：存取速度比堆要快，仅次于直接位于CPU中的寄存器，且栈数据可以共享。
      缺点：存在栈中的数据大小与生存期必须是确定的，缺乏灵活性。
      存放数据：存放基本类型的变量数据引用和对象的引用，但对象本身不存放在栈中，而是存放在堆（new 出来的对象）或者常量池中（字符串常量对象存放在常量池中。） 
      内存释放：栈上变量的生存时间受限于当前函数的生存时间，函数退出了，变量就不存在了。
     3. 堆：
      物理位置：随机存储器（Random Access Memory）
      优点：可以动态地分配内存大小，生存期也不必事先告诉编译器，Java的垃圾收集器会自动收走这些不再使用的数据。
      缺点：由于要在运行时动态分配内存，存取速度较慢。
      存放数据：所有new出来的对象。 
      内存释放：在堆中分配的对象实例，当不再有任何一个引用变量指向它时，这个对象就可以被垃圾回收机制回收了。
     4. 静态域：存放静态成员（static定义的） 
     5. 常量池：存放字符串常量和基本类型常量（public static final）。
     6. 非RAM存储：硬盘等永久存储空间



##2域与静态方法

   1.子类继承父类时，只有普通的方法调用可以是多态的

```java
 public class Father{
   public int field=0;
   
   public void name(){
      System.out.println("Father()...");
   }
 }
 
 class Son extends Father{
   public int field=1;
   
   public void name(){
     System.out.println("Son()...");
   
   public static void main(String[] args){
     Father father=new Son();
     System.out.println(father.field); //0
     System.out.println(father.name()); //Son()...
   }
 }
```

   

 2.如果某个方法是静态的，它的行为就不具有多态

   ```java
   class  StaticSuper{
     public static String staticGet(){
       return "Base staticGet()";
     }
     public String dynamicGet(){
       return "Base dynamicGet";
     }
   }
   
   public class StaticSub extends StaticSuper{
     public static String staticGet(){
       return "Derived staticGet()";
     }
     
     public String dynamicGet(){
       return "Derived dynamicGet()";
     }
   }
   
   public class StaticPolymorphism{
     public static void main(String[] args){
       StaticSuper sup=new StaticSub();
       System.out.println(sup.staticGet()); //Base staticGet()
       System.out.println(sup.dynamicGet()); //Derived dynamicGet()
     }
   }
   ```



3.一个类加载的顺序，如果他继承了一个父类，

​      首先加载父类，父类中有静态属性或方法先加载静态域，之后在加载成员变量和成员方法，最后加载构造器。

​      父类构造器加载完毕后，加载子类的静态域，加载子类的成员变量和方法，最后加载构造器。



## 3.内部类

  **1.定义在方法的类(局部内部类)**

```java
public class ParcelSix {

    public Destination destination(String s){

        class PDestination implements Destination{

        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }
    return new PDestination(s);
}

public static void main(String[] args) {
    ParcelSix ps=new ParcelSix();
    ps.destination("Hello,World");
}
```
}


 PDestination类是destination()方法的一部分，而不是ParcelSix的一部分，所以在destination()之外不能访问PDestination

 注意出现在return语句中的向上转型——返回的是Destination的引用，它是PDestination的基类。

匿名内部类，继承的基类只有一个带参构造器时，使用方法的参数时，参数必须为final。



**2.嵌套类**

   1).要创建嵌套类的对象，并不需要其外围类的对象。

   2).不能从嵌套类的对象中访问非静态的外围类对象。

   嵌套类与普通的内部类的还有一个区别。普通内部类的字段与方法，只能放在类的外部层次上，所以普通的内部类不能

   有static数据和static字段，也不能包含嵌套类。但嵌套类可以包含所有这些东西。



**3.为什么需要内部类**

 每个内部类都能独立地继承自一个(接口的)实现，所以无论外围类是否已经继承了某个(接口的)实现，对于内部类都没有

 影响。接口解决了部分问题，而内部类有效地实现了"多重继承"。也就是说，内部类允许继承多个非接口类型(类或抽

 象类)。好处如下:

​    1).利用其外部类的方法创建并返回内部类实例，隐藏你不想让别人知道的操作。

​    2).一个内部类对象可以访问创建它的外部类对象的内容，甚至包括私有变量。



**4.内部类可以被覆盖吗?**

   这个例子说明，当继承了某个外部类的时候，内部类并没有发生什么特别神奇的变化，这两个内部类是完全独立的两

   个实体，各自在自己的命名空间里。

  ```java
class Egg{
  private Yolk y;
  protected class Yolk{
    public Yolk(){
      System.out.println("Egg Yolk");
    }
  }
  public Egg(){
    System.out.println("New Egg");
    new Yolk();
  }
}

public class BigEgg extends Egg{
  protected class Yolk{
    public Yolk(){
      System.out.println("BigEgg Yolk");
    }
  }
  
  public static void main(String[] args){
    new BigEgg();
  }
}
/*
  Output：
   New Egg
   Egg Yolk
*/
  ```

 

## 4.持有对象

​     1.数组将数字(下标)与对象联系起来。它保存类型明确的对象，查询对象时，不需要对结果做类型转换。它可以是多维

​        的，可以保存基本类型的数据。但是，数组一旦生成其容量就不能改变。

​     2.Collection保存单一的元素，而Map保存相关联的键值对。有了Java的泛型，你就可以指定容器中存放的对象类型，

​        因此你就不会将错误类型的对象放置到容器中，并且在从容器中获取元素时，不必进行类型转换，各种Collection和

​        各种Map都可以在你向其中添加更多的元素时，自动调整其尺寸。容器不能持有基本类型，但是自动包装机制会仔细

​        地执行基本类型到容器中所持有的包装器类型之间的双向转换。

​     3.像数组一样，List也建立数字索引与对象的关联，因此数组和List都是排好序的容器，List能够自动扩大容量。

​     4.如果要进行大量的随机访问，就使用ArrayList；如果要经常从表中间插入或删除元素，则应该使用LinkedList。

​     5.各种Queue以及栈的行为，由LinkedList提供支持。

​     6.Map是一种将对象(而非数字)与对象相关联的设计。HashMap设计用来快速访问；而TreeMap保持"键"始终处于排序

​         状态，所以没有HashMap快。LinkedHashMap保持元素插入的顺序，但是也通过散列提供了快速访问能力。

​     7.Set不接受重复元素。HashSet提供最快的查询速度，而TreeSet保持元素处于排序状态。LinkedHashSet以插入元素

​         的顺序。



## 5.类型信息

​        1.当使用".class"来创建对Class对象的引用时，不会自动地初始化该Class对象。为了使用类而做的

​           准备工作实际包含三个步骤:

​                   a.加载,这是由类加载器执行的，该步骤将查找字节码(通常在classpath所指定的l路径中查找，但这并非是

​                   必须的)，并从这些字节码中创建一个Class对象。

​                   b.链接，在链接阶段将验证类中的字节码，为静态域分配存储空间，并且如果必须的话，将解析这个类创

​                   建的对其他类的所有引用。

​                    c.初始化，如果该类具有超类，则对其初始化执行静态初始化器和静态初始化。

​            初始化被延迟到了对静态方法(构造器隐式地是静态的)或者非常数静态域进行首次引用时才执行。



## 6.容器深入研究

​        1.当在HashMap中使用自己的类作为键时，需要注意:

​              1).当两个对象里面的内容相同时，将两个对象加入时，对象的键不会被相互覆盖

​              2).问题出在HashMap的键是先对比键的散列码，自定义的类会继承自基类Object,而Object默认是使用

​                  对象的地址计算散列码。

​              3).当你在类中覆盖hashCode()方法后，还是无法正常运行，因为HashMap中，是先以hashCode值做

​                  对比，在使用equals方法进行对比，在这里的equals方法也是Object自定义的，对比的也是对象的地址。

​                  所以还需重写equals方法。

​                 **正确的equals()方法必须满足5个条件:**

​                      a.自反性。对任意x，x.equals(x)一定返回true

​                      b.对称性。对任意x和y，如果y.equals(x)返回是true，那么x.equals(y)返回的也是true。

​                      c.一致性。对任意的x和y，如果用于对比的信息没有发生改变，那么无论调用多少次，返回结果与第一

​                        次一致。

​                      d.对任何不是null的x，x.equals(null)一定返回false.

​          2.为速度而散列

​                     如果键没有按照任何特定顺序保存，所以只能使用简单的线性查询，而线性查询是最慢的查询方法。

​                     散列的价值在于速度：散列使得查询得以快速进行。由于瓶颈位于键的查询速度，因此解决方法之一就是

​                     保持键的排序状态，然后使用Collection.binarySearch()进行查询。

​                     散列则更进一步，他将键保存在某处，以便能够很快找到。存储一组元素最快的数据结构是数组，所以使用

​                     他来表示键的信息(键的信息，不是键本身)，但是因为数组的容量是固定的，而我们想保存的数量并不确定

​                     其实数组并不保存键本身，而是通过键对象生成一个数字，将其作为数组的下标，这个数字就是散列码，由

​                     定义在Object中的、且可能由你的类覆盖的hashCode()方法生成。

​                     为解决数组容量被固定的问题，相同的键可以产生相同的下标，而不同的键也可能会产生相同的下标，这就 

​                     导致了冲突的产生，数组并不直接保存值，而是保存值的list,采用数组加链表的实现方式，相同的键中可能

​                     有不同的值，然后对list中的值采用equals()方法进行线性的查询，虽然比较慢，但是只对很少的元素比较。

## 7.线程状态

​           1).新建(new)：当线程被创建时，它只会短暂地处于这种状态。此时它已经分配了必须的系统资源，并执行了初始

​                化。此刻线程已经有资格获得CPU时间了，之后调度器将把这个线程转变为可运行状态或阻塞状态。

​            2).就绪(Runnable)：在这种状态下，只要调度器把时间片分配给线程，线程就可以运行。也就是说，在任意时刻

​                线程可以运行也可以不运行。只要调度器能分配时间片给线程，他就可以运行；这不同于死和阻塞状态。

​           3).阻塞(Blocked):线程能够运行，但有某个条件阻止它的运行。当线程处于阻塞状态时，调度器将忽略线程，不会

​                分配给线程任何CPU时间。直到线程重新进入了就绪状态，它才有可能执行操作。

​           4).死亡(Dead):处于死亡或终止状态的线程将不再是可调度的，并且再也不会得到CPU时间，它的任务已结束，或

​                不再是可运行的。任务死亡的通常方式是从run()方法返回，但是任务的线程还可以被中断。

​            **进入阻塞状态**

​                      一个任务进入阻塞状态，可能有如下原因:

​                      1).通过调用sleep(milliseconds)使任务进入休眠状态，在这种情况下，任务在指定的时间内不会运行。

​                      2).你通过调用wait()使线程挂起。直到线程得到了notify()或notifyAll()消息,线程才会进入就绪状态。

​                      3).任务在等待某个输入/输出完成。

​                      4).任务试图在某个对象上调用其同步控制方法，但是对象锁不可用，因为另一个任务已经获取了这个锁。

## 8.线程死锁

​              共享资源类

```java
package com.diagens.five.dielock;

/**
 * @author ZNJ
 * @create 2019-03-29 13:17
 */
public class Chopstick {
    private boolean taken=false;

    //拿起筷子
    public synchronized void take() throws InterruptedException {
        while (taken){
            wait();
        }
        taken=true;
    }

    //放下筷子
    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}

```

​               执行任务者

```java
package com.diagens.five.dielock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 13:19
 */
//每个哲学家要左右两个筷子
//每次吃饭前会思考一会
//一共只有五根筷子
//一共五个哲学家，等待别人吃完以后放下筷子，它才能吃
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random=new Random(47);

    private void pause() throws InterruptedException {
        if(ponderFactor==0){
            return;
        }
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
    }
    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this+" thinking");
                pause();
                System.out.println(this+" grabbing right");
                right.take();
                System.out.println(this+" grabbing left");
                left.take();
                System.out.println(this+" eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
```

​        产生死锁

````java
package com.diagens.five.dielock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 13:26
 */
//产生死锁
//哲学家思考的时间过短
//一起来争抢筷子，会造成的情况是，每个人手里一只筷子
//但都不能吃饭，同时都在等待另一个人吃完饭放下筷子
public class DeadlockingDiningPhilosophers {
    public static void main(String [] args) throws InterruptedException {
        int size=5;
        int ponder=0;
        ExecutorService service = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[5];
        for (int i = 0; i < size; i++) {
            chopsticks[i]=new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            service.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%size],i,ponder));
        }
        TimeUnit.SECONDS.sleep(10);
        service.shutdownNow();
    }
}

````

​      产生死锁条件:

​                1).互斥条件。

​                    任务使用的资源中至少一个是不能共享的。这里，一根Chopstick一次就只能被一个Philosopher使用

​                 2).至少一个任务必须持有一个资源且正在等待获取一个当前被别的任务持有的资源。也就是说，要发生

​                     死锁，Philosopher必须拿着一根Chopstick并且等待另一根。

​                 3).资源不能被任务抢占，任务必须把资源释放当作普通条件，Philosopher很有礼貌，他们不会从其他

​                     Philosopher那里抢占Chopstick。

​                  4).必须有循环等待。这时，一个任务等待其他任务所持有的资源，后者又在等待另一个任务所持有的资源

​                      这样一直下去，直到有一个任务在等待第一个任务所持有的资源，使得大家都被锁住。在

​                      DeadlockingDiningPhilosophers中，因为每个Philosopher都试图先得到右边的Chopstick，然后得到左边

​                      的Chopstick，所以发生了循环等待。

​       解决方案:

​                 让最后一个Philosopher拿Chopstick的顺序改变，这样第一个Philosopher就能拿到最后一根Chopstick，就不会

​                 产生死锁。