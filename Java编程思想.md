#                        Java编程思想
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



## 3.在方法和作用域内的内部类

  1.定义在方法的类(局部内部类)

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
}
         ```

 PDestination类是destination()方法的一部分，而不是ParcelSix的一部分，所以在destination()之外不能访问PDestination

 注意出现在return语句中的向上转型——返回的是Destination的引用，它是PDestination的基类。