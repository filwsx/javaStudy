参考：[尚硅谷经典Java面试题第一季(java面试精讲)](https://www.bilibili.com/video/BV1Eb411P7bP)

# JavaSE

## 1、如下代码的运行结果

```Java
public static void main(String[] args) {
    int i = 1;
    i = i++;
    int j = i++;
    int k = i + ++i * i++;
    System.out.println("i=" + i);
    System.out.println("j=" + j);
    System.out.println("k=" + k);
}
```

结论

- 赋值=，最后计算
- =右边的从左到右加载值依次压入操作数栈
- 实际先算哪个，看运算符优先级
- 自增、自减操作都是直接修改变量的值，不经过操作数栈
- 最后的赋值之前，临时结果也是存储在操作数栈中
- 建议：《JVM虚拟机规范》关于指令的部分

## 2、编写单例对象

概念

- 单例设计模式，即某个类在整个系统中只能有一个实例对象可被获取和使用的代码模式。

要点

- 一是某个类只能有一个实例；构造器私有化
- 二是它必须自行创建这个实例：含有一个该类的静态变量来保存这个唯一的实例
- 三是它必须自行向整个系统提供这个实例：对外提供获取该实例对象的方式：
  - （1）直接暴露（2）用静态变量的get方法获取

实现方式

- 饿汉式：直接创建对象，不存在线程安全问题
  - 直接实例化饿汉式（简洁直观）
  - 枚举式（最简洁）
  - 静态代码块饿汉式（适合复杂实例化）
- 懒汉式：延迟创建对象
  - 线程不安全（适用于单线程）
  - 线程安全（适用于多线程）
  - 静态内部类形式（适用于多线程）

小结

- 如果是饿汉式，枚举形式最简单
- 如果是懒汉式，静态内部类形式最简单

## 3、类和实例初始化

```Java
/*
 * 父类的初始化<clinit>：
 * （1）j = method();
 * （2）父类的静态代码块
 * 
 *  父类的实例化方法：
 * （1）super()（最前）
 * （2）i = test();
 * （3）父类的非静态代码块
 * （4）父类的无参构造（最后）
 * 
 * 非静态方法前面其实有一个默认的对象this
 * this在构造器（或<init>）它表示的是正在创建的对象，因为这里是在创建Son对象，所以
 * test()执行的是子类重写的代码（面向对象多态）
 * 
 * 这里i=test()执行的是子类重写的test()方法
 */
public class Father{
	private int i = test();
	private static int j = method();
	
	static{
		System.out.print("(1)");
	}
	Father(){
		System.out.print("(2)");
	}
	{
		System.out.print("(3)");
	}
	
	
	public int test(){
		System.out.print("(4)");
		return 1;
	}
	public static int method(){
		System.out.print("(5)");
		return 1;
	}
}

/*
 * 子类的初始化<clinit>：
 * （1）j = method();
 * （2）子类的静态代码块
 * 
 * 先初始化父类：(5)(1)
 * 初始化子类：（10）(6)
 * 
 * 子类的实例化方法<init>：
 * （1）super()（最前）      （9）（3）（2）
 * （2）i = test();    （9）
 * （3）子类的非静态代码块    （8）
 * （4）子类的无参构造（最后） （7）
 * 
 * 因为创建了两个Son对象，因此实例化方法<init>执行两次
 * 
 * （9）（3）（2）（9）（8）（7）
 */
public class Son extends Father{
	private int i = test();
	private static int j = method();
	static{
		System.out.print("(6)");
	}
	Son(){
//		super();//写或不写都在，在子类构造器中一定会调用父类的构造器
		System.out.print("(7)");
	}
	{
		System.out.print("(8)");
	}
	public int test(){
		System.out.print("(9)");
		return 1;
	}
	public static int method(){
		System.out.print("(10)");
		return 1;
	}
	public static void main(String[] args) {
		Son s1 = new Son();
		System.out.println();
		Son s2 = new Son();
	}
}
```

### 类初始化过程

- 一个类要创建实例需要先加载并初始化该类
  - main方法所在的类需要先加载和初始化
- 一个子类要初始化需要先初始化父类
- 一个类初始化就是执行\<clinit\>()方法
  - \<clinit\>()方法由静态类变量显示赋值代码和静态代码块组成
  - 类变量显示赋值代码和静态代码块代码从上到下顺序执行
  - \<clinit\>()方法只执行一次

### 实例初始化过程

实例初始化就是执行<init>()方法

- \<init\>()方法可能重载有多个，有几个构造器就有几个\<init\>方法
- \<init\>()方法由非静态实例变量显示赋值代码和非静态代码块、对应构造器代码组成
- 非静态实例变量显示赋值代码和非静态代码块代码从上到下顺序执行，而对应构造器的代码最后执行
- 每次创建实例对象，调用对应构造器，执行的就是对应的\<init\>方法
- \<init\>方法的首行是super()或super(实参列表)，即对应父类的\<init\>方法

### 方法的重写

①哪些方法不可以被重写

- final方法
- 静态方法
- private等子类中不可见方法

②对象的多态性

- 子类如果重写了父类的方法，通过子类对象调用的一定是子类重写过的代码
- 非静态方法默认的调用对象是this
- this对象在构造器或者说\<init\>方法中就是正在创建的对象

## 4、方法的参数传递机制

```Java
import java.util.Arrays;
public class Exam4 {
	public static void main(String[] args) {
		int i = 1;
		String str = "hello";
		Integer num = 200;
		int[] arr = {1,2,3,4,5};
		MyData my = new MyData();
		
		change(i,str,num,arr,my);
		
		System.out.println("i = " + i);
		System.out.println("str = " + str);
		System.out.println("num = " + num);
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("my.a = " + my.a);
	}
	public static void change(int j, String s, Integer n, int[] a,MyData m){
		j += 1;
		s += "world";
		n += 1;
		a[0] += 1;
		m.a += 1;
	}
}
class MyData{
	int a = 10;
}
```

- 形参是基本数据类型
  - 传递数据值
- 实参是引用数据类型
  - 地址值的拷贝
  - 特殊的类型：String、包装类等对象不可变性

## 5、递归与迭代

编程题：有n步台阶，一次只能上1步或2步，共有多少种走法？

递归：

```Java
public class TestStep{
	@Test
	public void test(){
		long start = System.currentTimeMillis();
		System.out.println(f(100));//165580141
		long end = System.currentTimeMillis();
		System.out.println(end-start);//586ms
	}
	
	//实现f(n)：求n步台阶，一共有几种走法
	public int f(int n){
		if(n<1){
			throw new IllegalArgumentException(n + "不能小于1");
		}
		if(n==1 || n==2){
			return n;
		}
		return f(n-2) + f(n-1);
	}
}
```

迭代

```java
public class TestStep2 {
	@Test
	public void test(){
		long start = System.currentTimeMillis();
		System.out.println(loop(100));//165580141
		long end = System.currentTimeMillis();
		System.out.println(end-start);//<1ms
	}
	
	public int loop(int n){
		if(n<1){
			throw new IllegalArgumentException(n + "不能小于1");
		}
		if(n==1 || n==2){
			return n;
		}
		
		int one = 2;//初始化为走到第二级台阶的走法
		int two = 1;//初始化为走到第一级台阶的走法
		int sum = 0;
		
		for(int i=3; i<=n; i++){
			//最后跨2步 + 最后跨1步的走法
			sum = two + one;
			two = one;
			one = sum;
		}
		return sum;
	}
}
```

小结

- 方法调用自身称为递归，利用变量的原值推出新值称为迭代。
- 递归
  - 优点：大问题转化为小问题，可以减少代码量，同时代码精简，可读性好；
  - 缺点：递归调用浪费了空间，而且递归太深容易造成堆栈的溢出。
- 迭代
  - 优点：代码运行效率好，因为时间只因循环次数增加而增加，而且没有额外的空间开销；
  - 缺点：代码不如递归简洁，可读性好

## 6、成员变量与局部变量

```Java
public class Exam5 {
	static int s;//成员变量，类变量
	int i;//成员变量，实例变量
	int j;//成员变量，实例变量
	{
		int i = 1;//非静态代码块中的局部变量 i
		i++;
		j++;
		s++;
	}
	public void test(int j){//形参，局部变量,j
		j++;
		i++;
		s++;
	}
	public static void main(String[] args) {//形参，局部变量，args
		Exam5 obj1 = new Exam5();//局部变量，obj1
		Exam5 obj2 = new Exam5();//局部变量，obj1
		obj1.test(10);
		obj1.test(20);
		obj2.test(30);
		System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
		System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
	}
}
```

### 区别

①声明的位置

- 局部变量：方法体{}中，形参，代码块{}中
- 成员变量：类中方法外
- 类变量：有static修饰
- 实例变量：没有static修饰

②修饰符

- 局部变量：final
- 成员变量：public、protected、private、final、static、volatile、transient

③值存储的位置

- 局部变量：栈
- 实例变量：堆
- 类变量：方法区

④作用域

- 局部变量：从声明处开始，到所属的}结束
- 实例变量：在当前类中“this.”(有时this.可以缺省)，在其他类中“对象名.”访问
- 类变量：在当前类中“类名.”(有时类名.可以省略)，在其他类中“类名.”或“对象名.”访问

⑤生命周期

- 局部变量：每一个线程，每一次调用执行都是新的生命周期
- 实例变量：随着对象的创建而初始化，随着对象的被回收而消亡，每一个对象的实例变量是独立的
- 类变量：随着类的初始化而初始化，随着类的卸载而消亡，该类的所有对象的类变量是共享的

### 就近原则

①局部变量与实例变量重名：在实例变量前面加“this.”

②局部变量与类变量重名：在类变量前面加“类名.”

# SSM

## 1、Spring Bean作用域之间的区别



## 2、Spring支持的



## 3、Spring MVC 在POST中解决中文乱码的



## 4、Spring MVC的工作流程



## 5、MyBatis中实体类属性名与表明



# Java高级



# 项目经验



# 设计模式

​	设计模式就是一种现成方案和解决思路，是在大量的实践中总结和理论化之后优选的代码结构、编程风格、 以及解决问题的思考方式。设计模免去我们自己再思考和摸索。

## 一、MVC

MVC是常用的设计模式之一，将整个程序分为三个层次： **视图模型层**，**控制器层**，与**数据模型层。**

这种将程序输入输出、数据处理，以及数据的展示分离开来的设计模式使程序结构变的灵活而且清晰，同时也描述了程序各个对象间的通信方式，降低了程序的耦合性。

①模型层 model 主要处理数据

>数据对象封装 model.bean/domain
>
>数据库操作类 model.dao
>
>数据库 model.db

②控制层 controller 处理业务逻辑

>应用界面相关 controller.activity
>
>存放 fragment controller.fragment
>
>显示列表的适配器 controller.adapter
>
>服务相关的 controller.service
>
>抽取的基类 controller.base

③视图层 view 显示数据

>相关工具类 view.utils
>
>自定义 view view.ui

![image-20220102101643745](../assets/image-20220102101643745.png)

## 二、单例模式

​	概念：所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对 某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。

​	饿汉式

```java
class Singleton {
	// 1.私有化构造器
	private Singleton() {
	}
	// 2.内部提供一个当前类的实例
	// 4.此实例也必须静态化
	private static Singleton single = new Singleton();
	// 3.提供公共的静态的方法，返回当前类的对象
	public static Singleton getInstance() {
		return single;
	}
}
```

​	懒汉式

```java
/**
*懒汉式暂时还存在线程安全问题，讲到多线程时，可修复
*/
class Singleton {
	// 1.私有化构造器
	private Singleton() {
	}
	// 2.内部提供一个当前类的实例
	// 4.此实例也必须静态化
	private static Singleton single;
	// 3.提供公共的静态的方法，返回当前类的对象
	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}
}
```

应用场景

```java
//网站的计数器，一般也是单例模式实现，否则难以同步。
//应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志
//文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
//数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
//项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
//Application也是单例的典型应用
//Windows的Task Manager(任务管理器)就是很典型的单例模式
//Windows的Recycle Bin(回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
```

## 三、模板方法

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

解决的问题:

​	当功能内部一部分实现 是确定的一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现 。

​	换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式。

```java
abstract class Template {
	public final void getTime() {
		long start = System.currentTimeMillis();
    	code();
		long end = System.currentTimeMillis();
		System.out.println("执行时间是："+ (end - start))
	}
	public abstract void code();
}
class SubTemplate extends Template {
	public void code() {
		for (int i = 0; i < 10000; i ++){
			System.out.println(i);
        }
	}
}
```

## 四、代理模式

![image-20220126212057319](assets/image-20220126212057319.png)

```java
//代理的设计模式，测试
public class NetworkTest {
	public static void main(String args[]) {
		Server s = new Server();
		ProxyServer p = new ProxyServer(s);
		p.browse();
	}
}
interface Network {
	public void browse();
}
//被代理类
class Server implements Network{
	@Override
	public void browse() {
		System.out.println("开始访问网络");
	}
}
//代理类
class ProxyServer implements Network{
	private Network nw;
	public void check() {
		System.out.println("联网前的检查");
	}
	public ProxyServer(Network nw) {
		this.nw = nw;
	}
	@Override
	public void browse() {
		check();
		nw.browse();
	}
}
```

应用场景
	安全代理： 屏蔽对真实角色的直接访问 。
	远程代理： 通过代理类处理远程方法调用RMI。
	延迟加载： 先加载轻量级的代理对象，真正需要再加载真实对象。
分类
	静态代理 静态定义代理类
	动态代理 动态生成代理类：JDK自带的动态代理 需要反射等知识

## 五、工厂模式

意义：实现了创建者与调用者的分离，即将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。



# 算法

## 概论

书籍：



## 排序



## 数组

（尚硅谷，2019 Java入门课程，3.4）

1.数组元素的赋值：**杨辉三角**、回形数等

2.求数值型：数组中元素的最大值、最小值、平均数、总和等

3.数组的复制 、**反转**、查找(线性查找、**二分法查找**)

4.数组元素的排序算法(**冒泡排序**)

## 字符串

（尚硅谷，2019 Java入门课程，9.1-练习5）

1.模拟一 个 trim 方法，去除字符串两端的空格 。

2.将字符串中指定部分进行反转 。比如"ab[cdef]g"反转为"ab[fedc]g"

**3.获取一个字符串在另一个字符串中出现的次数。**
		比如：获取"ab"在"abkkcadkabkebfkabkskab"中出现的次数。

**4.获取两个字符串中最大相同子串。**
​		比如：str1 = "abcwerthelloyuiodef“; str2 = "cvhellobnm";
​		提示：将短的那个串进行长度依次递减的子串与较长的串比较。
