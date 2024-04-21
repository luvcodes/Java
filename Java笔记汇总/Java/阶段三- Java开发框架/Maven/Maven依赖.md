# 依赖配置

### 排除依赖

在Maven中，"排除依赖"（Exclusion）是一种管理传递依赖的机制。当你添加一个依赖到你的项目中，这个依赖可能会带有它自己的传递依赖。有时，你可能不希望某些传递依赖被包含在你的项目中，这时你可以使用排除依赖。

# 依赖范围

依赖的jar包，默认情况下，可以在任何地方使用。可以通过<scope>...</scope>设置其作用范围

# 生命周期

Maven 的生命周期是一组预定义的阶段，用于管理构建项目的过程。以下是 Maven 生命周期的主要阶段：

1. **validate** - 验证项目是否正确，所有必需信息都可用。
2. **compile** - 编译源代码。
3. **test** - 使用合适的单元测试框架（如 JUnit）测试编译后的源代码。这些测试不应该需要代码被打包或部署。
4. **package** - 打包编译后的代码到其可分发格式，如 JAR。
5. **verify** - 对集成测试的结果进行检查，以确保质量达标。
6. **install** - 将包安装到本地仓库，以供其他项目使用。
7. **deploy** - 在构建环境中完成的包复制到远程仓库以供共享。

这些阶段按照特定的顺序执行，以确保构建过程的逻辑流程。

执行一个阶段时，它之前的所有阶段也会被执行。例如，如果执行 mvn install，那么 validate、compile、test、package 和 verify 也会被执行。

# 依赖管理

### 依赖传递

### 直接依赖与间接依赖

直接依赖(Direct Dependencies):在项目的pom.xml文件中明确声明依赖的其他项目或库。这些是项目直接依赖的资源。

间接依赖(Transitive Dependencies):项目依赖的其他项目或库本身依赖的项目或库。这些是项目间接依赖的资源,通过直接依赖传递而来。

举个例子:

- 项目A直接依赖项目B
- 项目B直接依赖项目C和项目D

那么对于项目A来说:

- 项目B是直接依赖
- 项目C和项目D是间接依赖

Maven会自动处理传递依赖,把项目所需的全部依赖(直接依赖和间接依赖)都带入项目的classpath中。这极大地简化了依赖管理。

### 依赖冲突

在Maven中,依赖冲突指的是同一个依赖artifact被不同版本引入的情况。主要有以下两种场景:

1. 直接依赖冲突

项目的直接依赖中引入了同一artifact的不同版本。

例如:

```Plain
<dependency>
  <groupId>org.apache</groupId>
  <artifactId>commons-lang</artifactId>
  <version>2.6</version>
</dependency>

<dependency>
  <groupId>org.apache</groupId>
  <artifactId>commons-lang</artifactId>
  <version>3.4</version>
</dependency>
```

1. 继承依赖冲突

项目依赖和父项目依赖中存在同一artifact的不同版本。

例如:

```Plain
<!-- 父项目A -->
<dependency>
  <groupId>org.apache</groupId>
  <artifactId>commons-lang</artifactId>
  <version>2.6</version>
</dependency>

<!-- 项目B继承项目A -->

<parent>
  <groupId>org.example</groupId>
  <artifactId>project-A</artifactId>
  <version>1.0</version>
</parent>

<dependency>
  <groupId>org.apache</groupId>
  <artifactId>commons-lang</artifactId>
  <version>3.4</version>
</dependency>
```

**Maven****处理依赖冲突的原则**:

1. 路径最近者优先,直接依赖版本覆盖继承的版本
2. 声明顺序优先,后声明的依赖版本覆盖前面声明的版本
3. 特殊优先, 当同级配置了相同资源的不同版本，后配置的覆盖先配置的

解决方式:

1. 排除依赖
2. 锁定版本
3. 直接指定版本号

所以在多模块项目或继承结构中,需要注意依赖一致性,避免冲突。

### 可选依赖 (不透明)

在Maven中,可选依赖(Optional Dependency)指的是被声明为可选的依赖关系。这类依赖对项目来说是非必需的,如果不存在也不会影响项目的正常编译和运行。

可选依赖有以下两个主要特征:

1. 可选依赖不会传递。如果项目A依赖可选依赖B,项目C依赖项目A,那么项目C不会继承项目A的可选依赖B。
2. 可选依赖的版本冲突不会被识别。如果项目依赖了多个版本的可选依赖,不会视为冲突。

可选依赖在pom.xml中通过<optional>true</optional>来标识:

```Plain
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang</artifactId>
  <version>2.6</version>
  <optional>true</optional>
</dependency>
```

使用可选依赖的场景例如:

- 项目中的一些测试代码需要用到该依赖,但主代码不需要
- 依赖是为插件服务的,项目本身代码不会用到

### 排除依赖 (不需要)

在Maven的依赖管理中,有时需要排除某些不需要的传递依赖,可以使用exclusions标签来实现。

主要有以下两种排除依赖的方式:

**1. 排除指定groupId和artifactId的依赖**

```Plain
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.9.8</version>
  <exclusions>
    <exclusion>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

这种方式是排除特定的依赖。

**2. 排除所有传递依赖**

```Plain
<dependency>
  <groupId>com.google.guava</groupId>
  <artifactId>guava</artifactId>
  <version>28.1-jre</version>
  <exclusions>
    <exclusion>
      <groupId>*</groupId>
      <artifactId>*</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

使用通配符*可以排除所有的传递依赖。

排除依赖可以避免依赖污染、减少 Jar 包大小、解决依赖冲突等问题。但需要根据实际情况进行评估,不要过度排除导致项目运行出错。

# 继承依赖

在 Maven 中，**继承****依赖是通过使用父** **POM****（****Project Object Model****）文件来实现的**。**一个 Maven 项目可以继承另一个项目的 POM 文件**，后者称为父 POM。这允许多个子项目共享父 POM 中定义的配置，从而提高了管理多个模块的效率，保持一致性，以及减少重复配置。

1. **父** **POM**：一个 Maven 项目可以声明一个父 POM，在 <parent> 标签中指定父项目的 groupId、artifactId 和 version。子项目通过继承可以使用父项目中定义的依赖和插件。
2. **依赖管理（Dependency Management）**：在父 POM 的 <dependencyManagement> 部分中，可以指定项目依赖的版本和范围，这样所有子模块在声明依赖时就不需要指定版本号。子模块只需声明它们需要的依赖项的 groupId 和 artifactId，版本号会从父 POM 继承而来。
3. **插件管理（Plugin Management）**：与 <dependencyManagement> 类似，<pluginManagement> 允许在父 POM 中管理插件的版本和配置，子模块会继承这些配置。
4. **属性（Properties）**：可以在父 POM 中定义属性（在 <properties> 元素中），子模块可以使用这些属性来避免硬编码配置值。
5. **配置共享**：除了依赖和插件配置，其他 Maven 构建配置，如构建目录、资源、测试配置等，也可以在父 POM 中定义并被子项目继承。
6. **重载和合并**：子 POM 可以重载父 POM 中的配置。如果子 POM 声明了自己的版本，那么这个版本会覆盖父 POM 中的相应依赖版本。有些配置元素如 dependencies 和 plugins 会进行合并处理。
7. **多模块项目**：在多模块项目中，父 POM 通常位于项目的根目录，定义共享的配置，而各个子模块的 POM 会继承这些配置。