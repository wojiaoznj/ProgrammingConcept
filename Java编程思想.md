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