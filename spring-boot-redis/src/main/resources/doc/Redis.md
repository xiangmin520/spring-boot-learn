### 一、字符串String    Key-Value

字符串是Redis中最常用的类型，是一个由字节组成的序列，它在Redis中是二进制安全的，这便意味着该类型可以接受任何格式的数据。

Value最多可以容纳的数据长度为512MB。

set key value          例如 set name "xiami"

往key中存入一个值(value)
get key  

获取键为key的值

　　注意：redis中的Key和Value时区分大小写的，命令不区分大小写， redis是单线程 不适合存储大容量的数据

　　incr key      ---对应的value 自增1,如果没有这个key值 自动给你创建创建 并赋值为1

　　decr key     ---对应的value 自减1

　   注意：自增的value是可以转成数字的