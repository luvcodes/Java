# 示例图像

![[/Untitled 6.png|Untitled 6.png]]

# JDBC快速入门

### 操作步骤

### 创建工程，导入驱动jar包

### 注册驱动

`Class.forName("com.mysql.jdbc.Driver");`

### 获取连接

`Connection connection = DriverManager.getConnection(url, username, password);`

### 定义SQL语句

`String sql = "update...";`

### 获取执行SQL对象

`Statement stmt = connection.createStatement();`

### 执行SQL

`stmt.executeUpdate(sql);`

### 处理返回结果

### 释放资源

# JDBC API

## Driver Manger

- 注册驱动
- 获取数据库连接

## Connection

- 获取执行SQL的对象
- 管理事务