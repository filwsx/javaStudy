# 基础概念

1、Java特点

- 面向对象：封装、继承、多态
- 一次编写，随处运行

2、JVM vs JDK vs JRE

- Java 虚拟机（JVM）是运行 Java 字节码的虚拟机。JVM有很多，**只要满足 JVM 规范即可。** 平常接触的 HotSpot VM 仅仅是是 JVM 规范的一种实现而已。
- JDK 是 Java Development Kit 缩写，它是功能齐全的 Java SDK。包含JRE、编译器（javac）和其他工具（如 javadoc 和 jdb）。
- JRE 是 Java 运行时环境。包括 Java 虚拟机（JVM），Java 类库，java 命令和其他的一些基础构件。不能用于创建新程序。

3、字节码

- JVM 可以理解的代码就叫做字节码（即扩展名为 `.class` 的文件），它不面向任何特定的处理器，只面向虚拟机。
- Java代码编译为字节码文件，交由JVM去解释执行。

4、Oracle JDK vs OpenJDK：非常接近

5、Java 和 C++ 的区别?

- Java 不提供指针来直接访问内存，程序内存更加安全
- Java 的类是单继承的，C++ 支持多重继承；虽然 Java 的类不可以多继承，但是接口可以多继承。
- Java 有自动内存管理垃圾回收机制(GC)，不需要程序员手动释放无用内存。

# 基本语法

1、字符型常量和字符串常量的区别

- **形式**：字符常量是单引号引起的一个字符，字符串常量是双引号引起的 0 个或若干个字符。
- **含义** : 字符常量相当于一个整型值( ASCII 值),可以参加表达式运算; 字符串常量代表一个地址值(该字符串在内存中存放位置)。
- **占内存大小** ： 字符常量只占 2 个字节; 字符串常量占若干个字节。

（**`char` 在 Java 中占两个字节**）

2、Java 中的注释有三种：单行注释、多行注释、文档注释

3、标识符和关键字的区别：略

4、自增自减运算符：略。在前边就先自增/自减然后参与其他运算。

5、 continue、break 和 return 的区别是什么：略

6、静态方法为什么不能调用非静态成员

- 静态方法是属于类的，在类加载的时候就会分配内存，可以通过类名直接访问。
- 非静态成员属于实例对象，只有在对象实例化之后才存在，需要通过类的实例对象去访问。

7、静态方法和实例方法有何不同？

- **调用方式**：调用静态方法可以无需创建对象。在外部调用静态方法时，可以使用 `类名.方法名` 的方式，也可以使用 `对象.方法名` 的方式，而实例方法只有后面这种方式。
- **访问类成员的限制：**静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），不允许访问实例成员（即实例成员变量和实例方法），而实例方法不存在这个限制。

8、重载和重写的区别

- 两个完全不同的东西，仅仅是名字相似。
- 重载：相同的方法名，但是参数类型不同、个数不同、顺序不同。发生在同一个类或者父类和子类之间。方法返回值和访问修饰符可以不同。
- **重写**：发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。
- **方法的重写要遵循“两同两小一大”**：
  - “两同”即方法名相同、形参列表相同；
  - “两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；
  - “一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。

9、可变长参数：

- 本质是一个数组，要在参数声明最后
- 遇到方法重载的情况，会优先匹配固定参数

# 基本数据类型

1、Java 中有 8 种基本数据类型，分别为：

- 6 种数字类型：
  - 4 种整数型：`byte`、`short`、`int`、`long`
  - 2 种浮点型：`float`、`double`
- 1 种字符类型：`char`
- 1 种布尔型：`boolean`。

2、基本类型和包装类型的区别

- 成员变量包装类型不赋值就是 `null` ，而基本类型有默认值且不是 `null`。
- 包装类型可用于泛型，而基本类型不可以。
- 基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中
- 基本数据类型的成员变量（未被 `static` 修饰 ）存放在 Java 虚拟机的堆中。
- 包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。
- 相比于对象类型， 基本数据类型占用的空间非常小。

3、包装类型的缓存机制

- `Byte`,`Short`,`Integer`,`Long` 这 4 种包装类默认创建了数值 **[-128，127]** 的相应类型的缓存数据
- `Character` 创建了数值在 **[0,127]** 范围的缓存数据
- `Boolean` 直接返回 `True` or `False`。

4、自动装箱和拆箱

5、封装、继承、多态

6、接口和抽象类的异同

**共同点** ：

- 都不能被实例化。
- 都可以包含抽象方法。
- 都可以有默认实现的方法（Java 8 可以用 `default` 关键字在接口中定义默认方法）。

**区别** ：

- 接口主要用于对类的行为进行约束，你实现了某个接口就具有了对应的行为。抽象类主要用于代码复用，强调的是所属关系（比如说我们抽象了一个发送短信的抽象类，）。
- 一个类只能继承一个类，但是可以实现多个接口。
- 接口中的成员变量只能是 `public static final` 类型的，不能被修改且必须有初始值，而抽象类的成员变量默认 default，可在子类中被重新定义，也可被重新赋值。

7、深拷贝和浅拷贝区别，什么是引用拷贝？

- **浅拷贝**：创建一个新的对象（区别于引用拷贝的一点），并复制内部属性，但是如果存在内部对象，仅仅复制其地址。也就是说拷贝对象和原对象共用一个内部对象。
- **深拷贝** ：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象。
- 引用拷贝：仅复制地址。

8、Object类

9、== 和 equals() 的区别

10、toString()

11、hashCode()

12、String、StringBuffer、StringBuilder

13、字符串拼接用“+” 还是 StringBuilder?

14、字符串常量池

- **字符串常量池** 是 JVM 为了提升性能和减少内存消耗针对字符串（String 类）专门开辟的一块区域，主要目的是为了避免字符串的重复创建。
- String s1 = new String("abc");这句话创建了几个字符串对象？
  - 会创建 1 或 2 个字符串对象。
  - 如果字符串常量池中不存在字符串对象“abc”的引用，那么会在堆中创建 2 个字符串对象“abc”。

# 异常

## Exception 和 Error

## try-catch-finally 

# 泛型

# 反射

## 动态代理

# 注解

# I/O

## 序列化

## Java 中 IO 流分为几种?

- 按照流的流向分，可以分为输入流和输出流；
- 按照操作单元划分，可以划分为字节流和字符流；
- 按照流的角色划分为节点流和处理流。

# 其他

## 为什么 Java 中只有值传递？

Java 对引用类型的参数采用的是引用传递。

实际上，并不是的，这里传递的还是值，不过，这个值是实参的地址罢了！

## Java 序列化详解

## 反射机制详解

## Java 代理模式详解

## IO 模型详解

## BigDecimal 详解

# Collection

## 总结

### List

- 【有序、可重复】
- `Arraylist`： `Object[]` 数组
- `Vector`：`Object[]` 数组
- `LinkedList`： 双向链表(JDK1.6 之前为循环链表，JDK1.7 取消了循环)

### Set

- 【无序、不可重复】
- `HashSet`(无序，唯一): 基于 `HashMap` 实现的，底层采用 `HashMap` 来保存元素
- `LinkedHashSet`: `LinkedHashSet` 是 `HashSet` 的子类，并且其内部是通过 `LinkedHashMap` 来实现的。有点类似于我们之前说的 `LinkedHashMap` 其内部是基于 `HashMap` 实现一样，不过还是有一点点区别的
- `TreeSet`(有序，唯一): 红黑树(自平衡的排序二叉树)

### Queue

- 【有序、可重复、按特定规则排序】
- `PriorityQueue`: `Object[]` 数组来实现二叉堆
- `ArrayQueue`: `Object[]` 数组 + 双指针

### Map

- 【键值对（key-value）存储】
- 【每个键最多映射到一个值】
- 【key 无序、不可重复；value 无序、可重复】
- `HashMap`： JDK1.8 之前 `HashMap` 由数组+链表组成的，数组是 `HashMap` 的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）。JDK1.8 以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间
- `LinkedHashMap`： `LinkedHashMap` 继承自 `HashMap`，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。另外，`LinkedHashMap` 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。详细可以查看：[《LinkedHashMap 源码详细分析（JDK1.8）》open in new window](https://www.imooc.com/article/22931)
- `Hashtable`： 数组+链表组成的，数组是 `Hashtable` 的主体，链表则是主要为了解决哈希冲突而存在的
- `TreeMap`： 红黑树（自平衡的排序二叉树）

## 如何选用集合?

主要根据集合的特点来选用，比如我们需要根据键值获取到元素值时就选用 `Map` 接口下的集合，需要排序时选择 `TreeMap`,不需要排序时就选择 `HashMap`,需要保证线程安全就选用 `ConcurrentHashMap`。

当我们只需要存放元素值时，就选择实现`Collection` 接口的集合，需要保证元素唯一时选择实现 `Set` 接口的集合比如 `TreeSet` 或 `HashSet`，不需要就选择实现 `List` 接口的比如 `ArrayList` 或 `LinkedList`，然后再根据实现这些接口的集合的特点来选用。

## 为什么要使用集合？

当我们需要保存一组类型相同的数据的时候，我们应该是用一个容器来保存，这个容器就是数组，但是，使用数组存储对象具有一定的弊端， 因为我们在实际开发中，存储的数据的类型是多种多样的，于是，就出现了“集合”，集合同样也是用来存储多个数据的。

数组的缺点是一旦声明之后，长度就不可变了；同时，声明数组时的数据类型也决定了该数组存储的数据的类型；而且，数组存储的数据是有序的、可重复的，特点单一。 但是集合提高了数据存储的灵活性，Java 集合不仅可以用来存储不同类型不同数量的对象，还可以保存具有映射关系的数据。

## HashMap

HashMap的底层实现原理？

HashMap 和 Hashtable的异同？

CurrentHashMap 与 Hashtable的异同？（暂时不讲）

谈谈你对HashMap中put/get方法的认识？如果了解再谈谈 HashMap的扩容机制？默认大小是多少？什么是负载因子( 或填充比)？什么是吞吐临界值(或阈值、threshold)

```
  负载因子的大小决定了HashMap的数据密度。
  负载因子越大密度越大，发生碰撞的几率越高，数组中的链表越容易长,造成查询或插入时的比较次数增多，性能会下降。
  负载因子越小，就越容易触发扩容，数据密度也越小，意味着发生碰撞的几率越小，数组中的链表也就越短，查询和插入时比较的次数也越小，性能会更高。但是会浪费一定的内容空间。而且经常扩容也会影响性能，建议初始化预设大一点的空间。
  按照其他语言的参考及研究经验，会考虑将负载因子设置为0.7~0.75，此时平均检索长度接近于常数。
```

# Thread
