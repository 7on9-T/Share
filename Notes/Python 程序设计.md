# Python 程序设计
引入
-
#### 为什么选择Python？当然是简单、易学、开发效率高。  
在Python的安装目录下，解释器为Python.exe  
我们可以把代码写入一个以“. py ”结尾的文件中，使用python命令去运行它。  

Python程序的开发有许多种方式，一般常见的有：  
1.Python解释器环境内，执行单行代码。  
2.使用Python解释器程序，执行Python代码文件。  
3.使用第三方IDE（集成开发工具），如PyCharm，来开发Python程序。  

PyCharm是当下全球Python开发者，使用最频繁的Python IDE。


1.1 Python的字面量
-
字面量：在代码中，被写下来的固定的值，称之为字面量。

Python中常用的有6种值（数据）的类型

### a.数字（Number）：
    1.整数（int） 
    int，如：10、-8

    2.浮点数（float） 
    float，如：1.1、-1.3

    3.复数（complex） 
    complex，如：4+5j，以j结尾表示复数
    
    4.布尔（bool）	
    bool表达现实生活中的逻辑，即真和假，True或者False ，True本质上是一个数字记作1，False记作0

### b.字符串（String）	
    描述文本的一种数据类型	

    String由任意数量的字符组成，又称文本，是由任意数量的字符如中文、英文、各类符号、数字等组成。所以叫做字符的串，在Python中，字符串需要用双引号（”）包围起来。亦或是被引号包围起来的，都是字符串。  
### c.列表（List）	
    有序的可变序列	
    Python中使用最频繁的数据类型，可有序记录一堆数据  
### d.元组（Tuple）	
    有序的不可变序列	
    可有序记录一堆不可变的Python数据集合  
### e.集合（Set）	
     无序不重复集合	
     可无序记录一堆不重复的Python数据集合  
### f.字典 （Dictionary）	
    无序Key-Value集合	
    可无序记录一堆Key-Value型的Python数据集合  

1.2 Python中的注释
-

```py
# 我是单行注释

"""
   我是多行注释
   我是多行注释
   我是多行注释
"""
```

1.3 Python中的变量
-
变量就是程序运行时，用来记录数据的
变量的定义格式： 变量名 = 变量值
变量的特征： 变量的值可以改变
print输出多份内容
print(内容1,内容2,......,内容N)

练习：
钱包余额（变量名：money），初始余额为50元，请通过程序计算，在购买了10元的冰淇淋，5元的可乐后，钱包还剩多少元。请通过print语句进行输出。

```py
# 定义一个变量，用来记录钱包余额
money = 12.3
#print(money)
money = money - 10
#print(money)

money1 = 50
print("当前钱包余额：",money1,"元")
ice = 10
print("购买了冰淇淋，花费：",ice,"元")
cola = 5
print("购买了可乐，花费：",cola,"元")
money1 = money1 - ice - cola
print("最终，钱包还剩：",money1,"元")
```

1.4 Python中的数据类型
-
使用type可以查看数据的类型。

```py
# 方法1：使用print直接输出类型信息
print(type("Hello World"))
print(type(123))
print(type(1.23))
print("----------------------------")

# 方法2.使用变量存储type()语句的结果
str_type = type("Hello World")
int_type = type(123)
float_type = type(1.1)
print(str_type)
print(int_type)
print(float_type)
print("--------------------------------")

# 方法3.使用type()语句，查看变量中存储的数据类型信息
name = "Hello World"
name_type = type(name)
print(name_type)
```

1.5 Python中的数据类型转换
-
```python
# 将数字类型转换成字符串

num_str = str(11)
print(type(num_str),num_str)

float_str = str (12.10)
print(type(float_str),float_str)

# 将字符串转换成数字

num = int("7")
print(type(num),num)

num2 = float("111.11")
print(type(num2),num2)

# 报错
# num3 = int("哇")
# print(type(num3),num3)
# 因为"哇"不是数字哦。

# 整数转浮点数
float_num = float(11)
print(type(float_num),float_num)

# 浮点数转整数
a = int(12.83)
print(type(a),a)
```
1.6 Python中的标识符
-

```py
# 规则1.内容限定，限定只能使用：中文、英文、数字、下划线，注意：不能以数字开头
# 1n = "1"
# )n = "1"
name_ = "peter"
_name = "peter1"
name_1 = "peter2"
# 规则2.大小写敏感
name = "peter3"
Name = 167294
print(name)
print(Name)
# 规则3.不可使用关键字
#if = 1
#else = "2121f544ef545sd"
```
1.7 Python中的运算符
-

```py

"""
+ - * / : 加减乘除
// : 取整除 返回商的部分 例如：9//2结果是4，9.0//2.0结果是4.0
% : 取余 返回除法的余数
** : 指数
"""

print("1 + 1 = ",1+1)
print("2 - 1 = ",2-1)
print("3 * 3 = ",3*3)
print("4 / 2 = ",4/2)
print("11 / 2 = ",11//2)
print("9 % 2 = ",9%2)
print("2 ** 2 = ",2**2)
```

